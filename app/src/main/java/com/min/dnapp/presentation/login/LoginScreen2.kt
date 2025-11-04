package com.min.dnapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Kakao
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.KakaoYellow
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun LoginScreen2(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier
            // 시스템바 영역 피하기 (status bar, navigation bar 모두 적용)
            .systemBarsPadding()
            .fillMaxSize(),
        color = MomentoTheme.colors.brownW80
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LoginHeaderSection()
            LoginButtonSection(
                onClick = {
                    viewModel.onKakaoLoginClicked(
                        context = context,
                        onSuccess = {
                            navController.navigate("home") {
                                popUpTo("login") { inclusive = true }
                            }
                        },
                        onFailure = {

                        }
                    )
                }
            )
        }
    }

    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MomentoTheme.colors.black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = MomentoTheme.colors.white,
                strokeWidth = 4.dp
            )
        }
    }
}

@Composable
fun LoginHeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(60.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(R.drawable.login_cloud),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Image(
                modifier = Modifier.offset(y = 28.dp),
                painter = painterResource(R.drawable.login_momento),
                contentDescription = null
            )
        }

        Spacer(Modifier.height(48.dp))

        Text(
            text = "모멘토에 오신 것을 환영합니다!",
            style = MomentoTheme.typography.title01,
            color = MomentoTheme.colors.brownB60
        )
    }
}

@Composable
fun LoginButtonSection(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.offset(y = 20.dp),
            painter = painterResource(R.drawable.login_mount),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(color = KakaoYellow, shape = RoundedCornerShape(10.dp))
            ) {
                Row(
                    modifier = Modifier
                        .clickable { onClick() }
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = AppIcons.Kakao,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "카카오로 로그인하기",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.height(60.dp))
        }
    }
}

@Preview
@Composable
fun LoginScreen2Preview() {
    DngoTheme {
//        LoginScreen2()
    }
}
