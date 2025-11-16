package com.min.dnapp.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    // viewModel의 상태를 구독
    val isLoading by loginViewModel.isLoading.collectAsStateWithLifecycle()
    val context = LocalContext.current

    // 스택바 상태 관리
    val snackbarHostState = remember { SnackbarHostState() }

    // 로그인 결과에 따른 처리
//    LaunchedEffect(loginResult) {
//        loginResult?.let { result ->
//            result.onSuccess {
//                navController.navigate("home") {
//                    popUpTo("login") { inclusive = true }
//                }
//                loginViewModel.clearLoginResult()
//            }.onFailure { exception ->
//                val errorMessage = when {
//                    exception.message?.contains("network", ignoreCase = true) == true ->
//                        "네트워크 연결을 확인해주세요"
//                    exception.message?.contains("cancelled", ignoreCase = true ) == true ->
//                        "로그인이 취소되었습니다"
//                    else -> "로그인에 실패했습니다"
//                }
//                snackbarHostState.showSnackbar(errorMessage)
//            }
//        }
//    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isLoading) {
                CircularProgressIndicator()
                Text(
                    text = "로그인 중..."
                )
            } else {
                Button(
                    onClick = {
//                        loginViewModel.onKakaoLoginClicked(context)
                    }
                ) {
                    Text("카카오 로그인")
                }
            }
        }
    }
}
