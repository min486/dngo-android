package com.min.dnapp.presentation

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AppStartViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    // 앱의 시작 상태(로그인 여부)를 저장
    private val _isLogin = MutableStateFlow(firebaseAuth.currentUser != null)
    val isLogin: StateFlow<Boolean> = _isLogin.asStateFlow()
}
