package com.min.dnapp.data.repository

import android.content.Context
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.min.dnapp.data.mapper.UserMapper
import com.min.dnapp.data.remote.dto.toSaveMap
import com.min.dnapp.domain.model.User
import com.min.dnapp.domain.repository.AuthRepository
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {
    override suspend fun signInWithKakao(context: Context): Result<Unit> =
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

    // 카카오 로그인 콜백 결과 처리
    private fun handleKakaoLoginResult(
        token: OAuthToken?,
        error: Throwable?,
        continuation: CancellableContinuation<Result<Unit>>
    ) {
        if (error != null) {
            // 카카오 로그인 실패 시
            continuation.resumeWith(Result.failure(error))
        } else if (token != null) {
            // 카카오 로그인 성공 시, 사용자 정보 조회
            getUserInfoAndReadyAuth(continuation)
        } else {
            // 토큰이 null인 경우
            continuation.resumeWith(Result.failure(Exception("카카오 로그인 토큰을 받을 수 없습니다")))
        }
    }

    // 카카오 사용자 정보 조회 및 인증 준비
    private fun getUserInfoAndReadyAuth(
        continuation: CancellableContinuation<Result<Unit>>
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

            // 카카오 닉네임
            val nickname = user.kakaoAccount?.profile?.nickname

            // firebase auth에 로그인/회원가입
            signInToFirebaseAuth(email, password, nickname, continuation)
        }
    }

    // firebase auth 기존 사용자 로그인 처리
    private fun signInToFirebaseAuth(
        email: String,
        password: String,
        nickname: String?,
        continuation: CancellableContinuation<Result<Unit>>
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (continuation.isCancelled) return@addOnCompleteListener

                if (task.isSuccessful) {
                    // 기존 사용자 로그인 성공
                    Log.d("auth", "signInToFirebaseAuth - 기존 사용자 로그인 성공")
                    continuation.resumeWith(Result.success(Result.success(Unit)))
                } else {
                    // 기존 사용자가 아닌 경우, 새로 회원가입 진행
                    Log.d("auth", "signInToFirebaseAuth - 새로운 사용자! 회원가입 진행")
                    createFirebaseUser(email, password, nickname, continuation)
                }
            }
    }

    // firebase auth 회원가입 및 사용자 정보 저장
    private fun createFirebaseUser(
        email: String,
        password: String,
        nickname: String?,
        continuation: CancellableContinuation<Result<Unit>>
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { createTask ->
                if (continuation.isCancelled) return@addOnCompleteListener

                if (createTask.isSuccessful) {
                    // firebase auth 회원가입 성공
                    val firebaseUser = firebaseAuth.currentUser

                    if (firebaseUser == null) {
                        continuation.resumeWith(Result.failure(Exception("firebase 사용자 정보를 찾을 수 없습니다")))
                        return@addOnCompleteListener
                    }

                    // 카카오 닉네임 사용하여 User Domain Model 생성
                    val newUser = createUserDomainModel(firebaseUser.uid, nickname)

                    // 콜백 내에서 suspend 함수를 호출하기 위해 코루틴 스코프 시작
                    CoroutineScope(Dispatchers.IO).launch {
                        val saveResult = runCatching {
                            // firestore에 저장
                            saveNewUser(newUser)
                        }

                        if (saveResult.isSuccess) {
                            // firestore 저장 성공
                            Log.d("auth", "createFirebaseUser - firestore 저장 성공. 닉네임 : $nickname")
                            continuation.resumeWith(Result.success(Result.success(Unit)))
                        } else {
                            // firestore 저장 실패
                            continuation.resumeWith(Result.failure(saveResult.exceptionOrNull() ?: Exception("사용자 정보 저장 실패")))
                        }
                    }
                } else {
                    // 회원가입 실패
                    val exception = createTask.exception ?: Exception("firebase 회원가입 실패")
                    continuation.resumeWith(Result.failure(exception))

                }
            }
    }

    private fun createUserDomainModel(
        firebaseUid: String,
        nickname: String?
    ): User {
        return User(
            userId = firebaseUid,
            nickname = nickname ?: "카카오 사용자",
            profileImageName = "01_boat",
            badgeLv = 1,
            badgeName = "새내기",
            recordCnt = 0,
            stampCnt = 0,
            createdAt = 0L
        )
    }

    /**
     * firestore에 사용자 정보 저장
     */
    private suspend fun saveNewUser(user: User) {
        val userEntity = UserMapper.toEntity(user)
        val userId = userEntity.userId ?: throw IllegalArgumentException("saveNewUser - user ID null")

        // Entity를 Map으로 변환
        val dataMap = userEntity.toSaveMap().apply {
            this["createdAt"] = FieldValue.serverTimestamp()
        }

        // Map 사용하여 firestore에 저장
        firestore.collection("users").document(userId).set(dataMap).await()
    }

    override suspend fun getUser(): User {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Result<Unit> = suspendCancellableCoroutine { continuation ->
        // 카카오 SDK 로그아웃
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e("auth", "logout - 카카오 로그아웃 실패", error)
                continuation.resumeWith(Result.failure(error))
                return@logout
            }

            // firebase auth 로그아웃
            firebaseAuth.signOut()
            continuation.resumeWith(Result.success(Result.success(Unit)))
            Log.d("auth", "logout - 카카오 & firebase 로그아웃 성공")
        }
    }

    override suspend fun unlinkUser(): Result<Unit> = suspendCancellableCoroutine { continuation ->
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            continuation.resumeWith(Result.failure(Exception("로그인된 사용자가 없습니다")))
            return@suspendCancellableCoroutine
        }

        // firebase auth 사용자 삭제
        firebaseUser.delete()
            .addOnCompleteListener { authTask ->
                Log.d("auth", "unlinkUser - firebase 계정 삭제 성공")
                if (authTask.isSuccessful) {
                    // firestore 문서 삭제
                    firestore.collection("users").document(firebaseUser.uid).delete()
                        .addOnSuccessListener {
                            Log.d("auth", "unlinkUser - firestore 문서 삭제 성공")
                            // 카카오 연결 끊기
                            UserApiClient.instance.unlink { unlinkError ->
                                if (unlinkError != null) {
                                    continuation.resumeWith(Result.failure(unlinkError))
                                } else {
                                    continuation.resumeWith(Result.success(Result.success(Unit)))
                                    Log.d("auth", "unlinkUser - 카카오 연결 끊기 성공")
                                }
                            }
                        }
                        .addOnFailureListener { firestoreException ->
                            continuation.resumeWith(Result.failure(firestoreException))
                        }
                } else {
                    continuation.resumeWith(Result.failure(authTask.exception ?: Exception("firebase 계정 삭제 실패")))
                }
            }
    }

    /**
     * 현재 로그인된 사용자의 UID를 반환
     */
    override suspend fun getCurrentUserId(): String? {
        return firebaseAuth.currentUser?.uid
    }
}
