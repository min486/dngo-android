package com.min.dnapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.min.dnapp.data.remote.dto.UserEntity
import com.min.dnapp.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository {
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
}
