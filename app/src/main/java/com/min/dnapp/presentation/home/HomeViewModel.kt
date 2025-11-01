package com.min.dnapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.model.User
import com.min.dnapp.domain.usecase.GetCurrentUserIdUseCase
import com.min.dnapp.domain.usecase.GetUserDataUseCase
import com.min.dnapp.domain.usecase.GetUserRecordUseCase
import com.min.dnapp.presentation.common.BadgeMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getCurrentUserIdUseCase: GetCurrentUserIdUseCase,
    private val getUserRecordUseCase: GetUserRecordUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            // 로딩 시작
            _uiState.value = HomeUiState.Loading

            // 인증 정보 요청
            val uid = try {
                getCurrentUserIdUseCase() ?: throw Exception("사용자 인증 정보 없음")
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("인증 정보 로드 실패: ${e.message}")
                return@launch
            }

            // 사용자 정보 로드 및 Success 상태 초기화
            val successState: HomeUiState.Success
            try {
                val user = getUserDataUseCase(uid)
                Log.d("home", "loadHomeData - user: $user")

                successState = mapUserToHomeUiState(user)

                _uiState.value = successState
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("사용자 정보 로드 실패: ${e.message}")
                return@launch
            }

            // 여행기록 정보 로드 및 상태 업데이트
            try {
                val userRecords = getUserRecordUseCase()
                Log.d("home", "loadHomeData - userRecords: $userRecords")
                val finalSuccessState = successState.copy(
                    records = userRecords
                )
                _uiState.value = finalSuccessState
            } catch (e: Exception) {
                _uiState.value = successState.copy(
                    records = emptyList()
                )
                Log.e("home", "기록 정보 로드 실패", e)
            }
        }
    }

    private fun mapUserToHomeUiState(user: User): HomeUiState.Success {
        val imageResId = BadgeMapper.getBadgeImageResId(user.badgeLv)

        return HomeUiState.Success(
            nickname = user.nickname,
            recordCnt = user.recordCnt,
            stampCnt = user.stampCnt,
            badgeName = user.badgeName,
            badgeImageResId = imageResId
        )
    }
}
