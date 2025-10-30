package com.min.dnapp.presentation.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.LogoutUseCase
import com.min.dnapp.domain.usecase.AuthWithKakaoUseCase
import com.min.dnapp.domain.usecase.UnlinkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authWithKakaoUseCase: AuthWithKakaoUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val unlinkUseCase: UnlinkUseCase
) : ViewModel() {

    // 로딩 상태
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    /**
     * 카카오 로그인
     */
    fun onKakaoLoginClicked(
        context: Context,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val result = authWithKakaoUseCase(context)
                Log.d("auth", "onKakaoLoginClicked - result : $result")

                result.onSuccess {
                    onSuccess()
                }.onFailure { exception ->
                    onFailure(exception)
                }
            } catch (e: Exception) {
                Log.e("auth", "onKakaoLoginClicked - unexpected error", e)
                onFailure(e)
            } finally {
                _isLoading.value = false
            }
        }
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
//    fun onUnlinkClicked(onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
    fun onUnlinkClicked() {
        viewModelScope.launch {
            try {
                val result = unlinkUseCase()
                result.onSuccess {
//                    onSuccess()
                }.onFailure { exception ->
//                    onFailure(exception)
                }
            } catch (e: Exception) {
//                onFailure(e)
            }
        }
    }
}
