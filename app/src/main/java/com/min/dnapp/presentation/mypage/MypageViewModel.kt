package com.min.dnapp.presentation.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.GetCurrentUserIdUseCase
import com.min.dnapp.domain.usecase.GetUserDataUseCase
import com.min.dnapp.domain.usecase.UpdateProfileImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MypageViewModel @Inject constructor(
    private val getCurrentUserIdUseCase: GetCurrentUserIdUseCase,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val updateProfileImageUseCase: UpdateProfileImageUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MypageUiState>(MypageUiState.Loading)
    val uiState: StateFlow<MypageUiState> = _uiState.asStateFlow()

    // 프로필 이미지 변경 모달창 상태
    private val _showImageUpdateDialog = MutableStateFlow(false)
    val showImageUpdateDialog: StateFlow<Boolean> = _showImageUpdateDialog.asStateFlow()

    // 현재 선택된 프로필 이미지
    private val _selectedImage = MutableStateFlow<ProfileImageType?>(null)
    val selectedImage: StateFlow<ProfileImageType?> = _selectedImage.asStateFlow()

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
}
