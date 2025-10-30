package com.min.dnapp.presentation.mypage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.min.dnapp.presentation.login.LoginViewModel
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "설정",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MomentoTheme.colors.brownBg
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { navController.popBackStack() }
                            .padding(16.dp),
                        imageVector = AppIcons.Back,
                        contentDescription = null
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.onLogoutClicked(
                            onSuccess = {
                                // 로그아웃 성공 후 이동
                                navController.navigate("login") {
                                    // 최상위 그래프의 ID까지 스택 모두 제거
                                    popUpTo(navController.graph.id) { inclusive = true }
                                }
                            },
                            onFailure = {

                            }
                        )
                    }
            ) {
                Text(
                    text = "로그아웃",
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.height(28.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.onUnlinkClicked(
                            onSuccess = {
                                // 회원탈퇴 성공 후 이동
                                navController.navigate("login") {
                                    // 최상위 그래프의 ID까지 스택 모두 제거
                                    popUpTo(navController.graph.id) { inclusive = true }
                                }
                            },
                            onFailure = {

                            }
                        )
                    }
            ) {
                Text(
                    text = "계정 탈퇴",
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    DngoTheme {
//        SettingScreen()
    }
}
