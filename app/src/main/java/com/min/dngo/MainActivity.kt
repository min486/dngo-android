package com.min.dngo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.kakao.sdk.user.UserApiClient
import com.min.dngo.ui.theme.DngoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DngoTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { kakaoLogin(context) }
        ) {
            Text("카카오 로그인")
        }
    }
}

fun kakaoLogin(context: Context) {
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) {
                Log.e("aa", "로그인 실패", error)
            } else if (token != null) {
                Log.i("aa", "로그인 성공, 토큰 : ${token.accessToken}")
                getUserInfo()
            }
        }
    } else {
        UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
            if (error != null) {
                Log.e("aa", "로그인 실패", error)
            } else if (token != null) {
                Log.i("aa", "로그인 성공, 토큰 : ${token.accessToken}")
                getUserInfo()
            }
        }
    }
}

fun getUserInfo() {
    UserApiClient.instance.me { user, error ->
        if (error != null) {
            Log.e("aa", "사용자 정보 요청 실패", error)
        } else if (user != null) {
            val userId = user.id
            val nickname = user.kakaoAccount?.profile?.nickname
            Log.d("aa", "사용자 ID : $userId")
            Log.d("aa", "닉네임 : $nickname")
        }
    }
}
