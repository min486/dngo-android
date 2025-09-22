package com.min.dnapp

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
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.kakao.sdk.user.UserApiClient
import com.min.dnapp.ui.theme.DngoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
            val userId = user.id.toString()
            val nickname = user.kakaoAccount?.profile?.nickname
            val profileImageUrl = user.kakaoAccount?.profile?.profileImageUrl
            Log.d("aa", "사용자 ID : $userId")
            Log.d("aa", "닉네임 : $nickname")
            Log.d("aa", "프로필이미지 : $profileImageUrl")

            saveUserToFirebase(userId, nickname, profileImageUrl)
        }
    }
}

fun saveUserToFirebase(userId: String, nickname: String?, profileImageUrl: String?) {
    val email = "$userId@kakao.com"
    val password = userId

    Firebase.auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.e("aa", "로그인 성공: 기존 사용자")
                // 로그인 성공: 기존 사용자
                // TODO: 다음 화면으로 이동
            } else {
                Log.e("aa", "로그인 실패: 신규 사용자")
                // 로그인 실패: 신규 사용자
                // 회원가입 시도
                Firebase.auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { create_task ->
                        if (create_task.isSuccessful) {
                            // 회원가입 성공
                            val firebaseUser = Firebase.auth.currentUser

                            firebaseUser?.let { user ->
                                // firestore에 사용자 프로필 정보 저장
                                val userRef = FirebaseFirestore.getInstance().collection("users").document(firebaseUser.uid)
                                val userProfile = mapOf(
                                    "nickname" to nickname,
                                    "profileImageUrl" to profileImageUrl
                                )
                                userRef.set(userProfile)
                                    .addOnSuccessListener {
                                        Log.e("aa", "신규 사용자 - 회원가입 완료")
                                        // TODO: 다음 화면으로 이동
                                    }
                                    .addOnFailureListener {
                                        // TODO: 실패 처리
                                    }
                            }
                        } else {
                            // 회원가입 실패
                            // TODO: 실패 처리
                        }
                    }
            }
        }
}
