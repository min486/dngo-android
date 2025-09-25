package com.min.dnapp.presentation.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.model.UserProfile
import com.min.dnapp.domain.usecase.LogoutUseCase
import com.min.dnapp.domain.usecase.SignInWithKakaoUseCase
import com.min.dnapp.domain.usecase.UnlinkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInWithKakaoUseCase: SignInWithKakaoUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val unlinkUseCase: UnlinkUseCase
) : ViewModel() {

    // 로그인 결과 저장
    private val _loginResult = MutableStateFlow<Result<UserProfile>?>(null)
    val loginResult: StateFlow<Result<UserProfile>?> = _loginResult.asStateFlow()

    // 로딩 상태 관리
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    /**
     * 카카오 로그인 버튼 클릭 시 호출
     */
    fun onKakaoLoginClicked(context: Context) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _loginResult.value = null

                val result = signInWithKakaoUseCase(context)
                _loginResult.value = result
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    // 로그인 결과 상태를 초기화
    fun clearLoginResult() {
        _loginResult.value = null
    }

    /**
     * 로그아웃 버튼 클릭 시 호출
     */
    fun onLogoutClicked(onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            try {
                val result = logoutUseCase()
                result.onSuccess {
                    onSuccess()
                }.onFailure { exception ->
                    onFailure(exception)
                }
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }

    /**
     * 회원탈퇴 버튼 클릭 시 호출
     */
    fun onUnlinkClicked(onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        viewModelScope.launch {
            try {
                val result = unlinkUseCase()
                result.onSuccess {
                    onSuccess()
                }.onFailure { exception ->
                    onFailure(exception)
                }
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }
}
