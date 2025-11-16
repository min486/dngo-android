package com.min.dnapp.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.min.dnapp.data.remote.dto.UserEntity
import com.min.dnapp.domain.model.Badge
import com.min.dnapp.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : UserRepository {

    // 사용자 ID 가져오기
    private val currentUserId: String
        get() = firebaseAuth.currentUser?.uid ?: throw IllegalStateException("user not authenticated")

    override suspend fun getUserData(uid: String): UserEntity {
        // I/O 작업을 위해 Dispatchers.IO로 스레드 전환
        return withContext(Dispatchers.IO) {
            try {
                val document = firestore
                    .collection("users")
                    .document(uid)
                    .get()
                    .await()

                val userEntity = document.toObject(UserEntity::class.java)

                return@withContext userEntity ?: throw Exception("user document problem")
            } catch (e: Exception) {
                throw Exception("failed getUserData: ${e.message}", e)
            }
        }
    }

    override suspend fun updateProfileImage(profileImageName: String): Result<Unit> {
        val userID = currentUserId
        val userDoc = firestore.collection("users").document(userID)

        val updateImage = mapOf(
            "profileImageName" to profileImageName
        )

        return withContext(Dispatchers.IO) {
            try {
                userDoc.update(updateImage).await()
                Result.success(Unit)
            } catch (e: Exception) {
                Log.e("record", "updateProfileImage error", e)
                // 실패 정보 상위 레이어로 전달
                Result.failure(e)
            }
        }
    }

    override suspend fun updateNickname(nickname: String): Result<Unit> {
        val userId = currentUserId
        val userDoc = firestore.collection("users").document(userId)

        val newNickname = mapOf(
            "nickname" to nickname
        )

        return withContext(Dispatchers.IO) {
            try {
                userDoc.update(newNickname).await()
                Result.success(Unit)
            } catch (e: Exception) {
                Log.e("record", "updateNickname error", e)
                Result.failure(e)
            }
        }
    }

    override suspend fun updateBadge(badge: Badge): Result<Unit> {
        val userId = currentUserId
        val userDoc = firestore.collection("users").document(userId)

        val newBadge = mapOf(
            "badgeLv" to badge.level,
            "badgeName" to badge.name
        )

        return withContext(Dispatchers.IO) {
            try {
                userDoc.update(newBadge).await()
                Result.success(Unit)
            } catch (e: Exception) {
                Log.e("user", "updateBadge error", e)
                Result.failure(e)
            }
        }
    }
}
