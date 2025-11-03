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

    // 회원탈퇴 완료 모달창 상태
    private val _showUserRemoveSuccessDialog = MutableStateFlow(false)
    val showUserRemoveSuccessDialog: StateFlow<Boolean> = _showUserRemoveSuccessDialog.asStateFlow()

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
     * 로그아웃 처리
     * - 카카오 SDK 로그아웃
     * - firebase auth 로그아웃
     */
    fun onLogoutClicked(
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = logoutUseCase()
                Log.d("auth", "onLogoutClicked - result : $result")

                result.onSuccess {
                    onSuccess()
                }.onFailure { exception ->
                    onFailure(exception)
                }
            } catch (e: Exception) {
                Log.e("auth", "onLogoutClicked - unexpected error", e)
                onFailure(e)
            }
        }
    }

    /**
     * 회원탈퇴 완료 모달창 열기
     */
    fun openDialog() {
        _showUserRemoveSuccessDialog.value = true
    }

    /**
     * 회원탈퇴 처리
     * - firebase auth 사용자 삭제
     * - firestore "users" 문서 삭제
     * - 카카오 연결 끊기
     */
    fun onUnlinkClicked(
//        onSuccess: () -> Unit,
//        onFailure: (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val result = unlinkUseCase()
                Log.d("auth", "onUnlinkClicked - result : $result")

                result.onSuccess {
//                    onSuccess()
                    openDialog()
                }.onFailure { exception ->
//                    onFailure(exception)
                    Log.e("auth", "회원탈퇴 처리 실패", exception)
                }
            } catch (e: Exception) {
                Log.e("auth", "onUnlinkClicked - unexpected error", e)
//                onFailure(e)
            }
        }
    }
}
