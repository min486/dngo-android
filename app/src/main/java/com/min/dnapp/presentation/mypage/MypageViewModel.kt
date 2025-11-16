package com.min.dnapp.presentation.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.GetCurrentUserIdUseCase
import com.min.dnapp.domain.usecase.GetUserDataUseCase
import com.min.dnapp.domain.usecase.UpdateNicknameUseCase
import com.min.dnapp.domain.usecase.UpdateProfileImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MypageViewModel @Inject constructor(
    private val getCurrentUserIdUseCase: GetCurrentUserIdUseCase,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val updateProfileImageUseCase: UpdateProfileImageUseCase,
    private val saveNicknameUseCase: UpdateNicknameUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MypageUiState>(MypageUiState.Loading)
    val uiState: StateFlow<MypageUiState> = _uiState.asStateFlow()

    // 프로필 이미지 변경 모달창 상태
    private val _showImageUpdateDialog = MutableStateFlow(false)
    val showImageUpdateDialog: StateFlow<Boolean> = _showImageUpdateDialog.asStateFlow()

    // 현재 선택된 프로필 이미지
    private val _selectedImage = MutableStateFlow<ProfileImageType?>(null)
    val selectedImage: StateFlow<ProfileImageType?> = _selectedImage.asStateFlow()

    private val _nicknameState = MutableStateFlow(NicknameValidationState())
    val nicknameState: StateFlow<NicknameValidationState> = _nicknameState

    private val MIN_LENGTH = 2
    private val MAX_LENGTH = 10

    // 한글, 영문, 숫자, .(마침표), _(언더만)만 허용
    private val ALLOWED_CHARS_REGEX = Regex("^[가-힣a-zA-Z0-9._]*$")

    init {
        loadMyData()
    }

    private fun loadMyData() {
        viewModelScope.launch {
            // 로딩 시작
            _uiState.value = MypageUiState.Loading

            // 사용자 ID 가져오기
            val uid = try {
                getCurrentUserIdUseCase() ?: throw Exception("사용자 인증 정보 없음")
            } catch (e: Exception) {
                _uiState.value = MypageUiState.Error("인증 정보 조회 실패: ${e.message}")
                return@launch
            }

            // 사용자 정보 가져오기
            try {
                val user = getUserDataUseCase(uid)
                Log.d("my", "loadMyData - user: $user")
                val successState = MypageUiState.Success(
                    user = user
                )
                _uiState.value = successState
            } catch (e: Exception) {
                Log.e("my", "사용자 정보 조회 실패", e)
            }
        }
    }

    /**
     * 프로필 이미지 선택
     */
    fun selectImage(image: ProfileImageType) {
        // 선택된 이미지 다시 선택하면 해제
        _selectedImage.value = if (_selectedImage.value == image) null else image
    }

    /**
     * 프로필 이미지 변경 모달창 열기
     */
    fun openDialog() {
        _showImageUpdateDialog.value = true
    }

    /**
     * 프로필 이미지 변경 모달창 닫기
     */
    fun closeDialog() {
        _showImageUpdateDialog.value = false
    }

    /**
     * 프로필 이미지 변경
     */
    fun updateProfileImage() {
        viewModelScope.launch {
            selectedImage.value?.let { image ->
                val result = updateProfileImageUseCase(image.key)

                result.onSuccess {
                    closeDialog()
                    loadMyData()
                    Log.d("my", "updateProfileImage 성공")
                }.onFailure { exception ->
                    Log.e("my", "updateProfileImage 실패", exception)
                }
            }
        }
    }

    /**
     * 사용자의 입력에 따라 닉네임 검사 및 업데이트
     */
    fun onNicknameChange(newInput: String) {

        // 10자 초과 입력 차단
        val finalInput = if (newInput.length > MAX_LENGTH) {
            newInput.substring(0, MAX_LENGTH)
        } else {
            newInput
        }
        Log.d("my", "onNicknameChange finalInput: $finalInput")

        val (isValid, errorMessage) = validateNickname(finalInput)

        _nicknameState.update {
            it.copy(
                currentNickname = finalInput,
                errorMessage = errorMessage,
                isValid = isValid
            )
        }
    }

    private fun validateNickname(nickname: String): Pair<Boolean, String?> {

        // 빈 문자열인 경우
        if (nickname.isEmpty()) {
            return Pair(false, null)
        }

        // 문자 제한 검사
        if (!nickname.matches(ALLOWED_CHARS_REGEX)) {
            return Pair(false, "한글, 영문, 숫자, .(마침표), _(언더바)만 가능합니다")
        }

        // 글자수 제한 검사
        if (nickname.length < MIN_LENGTH) {
            return Pair(false, "2~10자로 입력해주세요")
        }

        // 모든 조건 통과
        return Pair(true, null)
    }

    /**
     * 새로운 닉네임 저장
     */
    fun updateNickname(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val nicknameState = _nicknameState.value

            if (!nicknameState.isValid || nicknameState.isSaving) {
                return@launch
            }

            // 저장 시작
            _nicknameState.update { it.copy(isSaving = true) }

            val newNickname = nicknameState.currentNickname
            val result = saveNicknameUseCase(newNickname)

            result.onSuccess {
                // 프로필 데이터 갱신
                loadMyData()
                // Dialog 닫기 신호 전달
                onSuccess()
                Log.d("my", "updateNickname 성공")
            }.onFailure { exception ->
                Log.e("my", "updateNickname 실패", exception)
            }

            _nicknameState.update { it.copy(isSaving = false) }
        }
    }
}
