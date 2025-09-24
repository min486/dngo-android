package com.min.dnapp.data.repository

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.min.dnapp.domain.model.UserProfile
import com.min.dnapp.domain.repository.AuthRepository
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {
    override suspend fun signInWithKakao(context: Context): Result<UserProfile> =
        suspendCancellableCoroutine { continuation ->

            // 카카오톡 앱 설치 여부에 따라 로그인 방식 결정
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                // 카카오톡 앱을 통한 로그인
                UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                    // 코루틴이 이미 취소된 경우 처리하지 않음
                    if (continuation.isCancelled) return@loginWithKakaoTalk

                    handleKakaoLoginResult(token, error, continuation)
                }
            } else {
                // 카카오 계정을 통한 웹 로그인
                UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                    // 코루틴이 이미 취소된 경우 처리하지 않음
                    if (continuation.isCancelled) return@loginWithKakaoAccount

                    handleKakaoLoginResult(token, error, continuation)
                }
            }

        }

    // 카카오 로그인 결과를 처리
    private fun handleKakaoLoginResult(
        token: OAuthToken?,
        error: Throwable?,
        continuation: CancellableContinuation<Result<UserProfile>>
    ) {
        if (error != null) {
            // 카카오 로그인 실패 시
            continuation.resumeWith(Result.failure(error))
        } else if (token != null) {
            // 카카오 로그인 성공 시, 사용자 정보 조회
            getUserInfoAndSignInToFirebase(continuation)
        } else {
            // 토큰이 null인 경우
            continuation.resumeWith(Result.failure(Exception("카카오 로그인 토큰을 받을 수 없습니다")))
        }
    }

    // 카카오 사용자 정보를 가져오고 firebase에 로그인/회원가입
    private fun getUserInfoAndSignInToFirebase(
        continuation: CancellableContinuation<Result<UserProfile>>
    ) {
        UserApiClient.instance.me { user, error ->
            // 코루틴이 취소된 경우 처리 중단
            if (continuation.isCancelled) return@me

            if (error != null) {
                // 사용자 정보 조회 실패
                continuation.resumeWith(Result.failure(error))
                return@me
            }

            if (user == null) {
                continuation.resumeWith(Result.failure(Exception("카카오 사용자 정보를 가져올 수 없습니다")))
                return@me
            }

            // 카카오 사용자 id를 firebase auth용 이메일/비밀번호로 변환
            val userId = user.id.toString()
            val email = "$userId@kakao.com"
            val password = userId

            val userProfile = UserProfile(
                nickname = user.kakaoAccount?.profile?.nickname,
                profileImageUrl = user.kakaoAccount?.profile?.profileImageUrl
            )

            // firebase auth에 로그인 시도 (기존 사용자인 경우)
            signInToFirebaseAuth(email, password, userProfile, continuation)
        }
    }

    // firebase auth 로그인 처리
    private fun signInToFirebaseAuth(
        email: String,
        password: String,
        userProfile: UserProfile,
        continuation: CancellableContinuation<Result<UserProfile>>
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (continuation.isCancelled) return@addOnCompleteListener

                if (task.isSuccessful) {
                    // 기존 사용자 로그인 성공
                    Log.e("AuthRepository", "kakao : 기존 사용자 로그인 성공")
                    continuation.resumeWith(Result.success(Result.success(userProfile)))
                } else {
                    // 기존 사용자가 아닌 경우, 새로 회원가입 진행
                    Log.e("AuthRepository", "kakao : 새로운 사용자! 회원가입 진행")
                    createFirebaseUser(email, password, userProfile, continuation)
                }
            }
            .addOnFailureListener { exception ->
                if (!continuation.isCancelled) {
                    continuation.resumeWith(Result.failure(exception))
                }
            }
    }

    // firebase auth 회원가입 및 firestore에 사용자 정보 저장
    private fun createFirebaseUser(
        email: String,
        password: String,
        userProfile: UserProfile,
        continuation: CancellableContinuation<Result<UserProfile>>
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { createTask ->
                if (continuation.isCancelled) return@addOnCompleteListener

                if (createTask.isSuccessful) {
                    // firebase auth 회원가입 성공, firestore에 사용자 정보 저장
                    saveUserToFirestore(userProfile, continuation)
                } else {
                    // 회원가입 실패
                    val exception = createTask.exception ?: Exception("firebase 회원가입 실패")
                    continuation.resumeWith(Result.failure(exception))

                }
            }
            .addOnFailureListener { exception ->
                if (!continuation.isCancelled) {
                    continuation.resumeWith(Result.failure(exception))
                }
            }
    }

    // firestore에 사용자 정보 저장 함수
    private fun saveUserToFirestore(
        userProfile: UserProfile,
        continuation: CancellableContinuation<Result<UserProfile>>
    ) {
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser == null) {
            continuation.resumeWith(Result.failure(Exception("firebase 사용자 정보를 찾을 수 없습니다")))
            return
        }

        // firestore에 저장할 사용자 데이터 맵
        val userMap = mapOf(
            "nickname" to userProfile.nickname,
            "profileImageUrl" to userProfile.profileImageUrl,
            "createdAt" to FieldValue.serverTimestamp()
        )

        // firestore의 users 컬렉션에 사용자 정보 저장
        firestore.collection("users").document(firebaseUser.uid)
            .set(userMap)
            .addOnSuccessListener {
                // firestore 저장 성공
                continuation.resumeWith(Result.success(Result.success(userProfile)))
            }
            .addOnFailureListener { exception ->
                // firestore 저장 실패
                if (!continuation.isCancelled) {
                    continuation.resumeWith(Result.failure(exception))
                }
            }
    }
}
