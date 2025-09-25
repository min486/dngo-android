package com.min.dnapp.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.min.dnapp.presentation.login.LoginViewModel

@Composable
fun HomeScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold (
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("홈 화면")

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    loginViewModel.onLogoutClicked(
                        onSuccess = {
                            navController.navigate("login") {
                                popUpTo("login") { inclusive = true }
                            }
                        },
                        onFailure = {
                            Toast.makeText(context, "로그아웃 실패 : ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            ) {
                Text("로그아웃")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    loginViewModel.onUnlinkClicked(
                        onSuccess = {
                            Toast.makeText(context, "회원탈퇴 성공", Toast.LENGTH_SHORT).show()
                            navController.navigate("login") {
                                popUpTo("login") { inclusive = true }
                            }
                        },
                        onFailure = {
                            Toast.makeText(context, "회원탈퇴 실패 : ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            ) {
                Text("회원탈퇴")
            }
        }
    }
}
