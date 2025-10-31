package com.min.dnapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.model.User
import com.min.dnapp.domain.usecase.GetCurrentUserIdUseCase
import com.min.dnapp.domain.usecase.GetUserDataUseCase
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
    private val getCurrentUserIdUseCase: GetCurrentUserIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            // 로딩 상태 시작
            _uiState.value = HomeUiState.Loading

            // 인증 정보 요청
            val uid = try {
                getCurrentUserIdUseCase()
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("인증 정보 가져오기 실패")
                return@launch
            }

            // uid 유효성 검사
            if (uid.isNullOrEmpty()) {
                _uiState.value = HomeUiState.Error("로그인 필요")
                return@launch
            }

            // firestore 데이터 요청 및 매핑
            try {
                val user = getUserDataUseCase(uid)
                Log.d("home", "loadHomeData - user: $user")

                val successState = mapUserToHomeUiState(user)
                Log.d("home", "loadHomeData - successState: $successState")

                _uiState.value = successState
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("사용자 정보 가져오기 실패: ${e.message}")
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
