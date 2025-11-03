package com.min.dnapp.data.repository

import android.net.Uri
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.toObjects
import com.google.firebase.storage.FirebaseStorage
import com.min.dnapp.data.mapper.RecordMapper
import com.min.dnapp.data.remote.dto.RecordEntity
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.domain.repository.RecordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecordRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage,
    private val firebaseAuth: FirebaseAuth
) : RecordRepository {

    // 현재 로그인된 사용자 ID 가져오기
    private val currentUserId: String
        get() = firebaseAuth.currentUser?.uid ?: throw IllegalStateException("user not authenticated")

    /**
     * Storage에 이미지 업로드 및 URL 반환
     */
    override suspend fun uploadImageAndGetUrl(imageUri: Uri): String {
        // 사용자 ID 가져오기
        val userId = currentUserId

        // firebase storage 경로는 사용자별로 분리
        val storageRef = storage.reference
            .child("images")
            .child(userId)
            .child("${System.currentTimeMillis()}_${imageUri.lastPathSegment}")

        // 이미지 업로드 및 URL 가져오기
        storageRef.putFile(imageUri).await()
        return storageRef.downloadUrl.await().toString()
    }

    /**
     * 개인 기록 컬렉션에 저장
     */
    override suspend fun savePrivateRecord(record: RecordEntity): RecordEntity {
        // 사용자 ID 가져오기
        val userId = currentUserId

        val recordCollection = firestore
            .collection("records")
            .document(userId)
            .collection("private_records")

        // firestore에서 새로운 문서 ID 생성
        val newDoc = recordCollection.document()
        val recordId = newDoc.id

        // RecordEntity의 ID 관련 필드 채우기
        val recordWithId = record.copy(
            recordId = recordId,
            userId = userId
        )

        // set()을 사용하여 해당 ID로 저장
        newDoc.set(recordWithId).await()

        return recordWithId
    }

    /**
     * 전체공유 컬렉션에 저장
     */
    override suspend fun saveSharedRecord(record: RecordEntity) {
        // 사용자 ID 가져오기
        val userId = currentUserId

        val sharedCollection = firestore.collection("shared_records")

        val recordWithId = record.copy(userId = userId)

        // set()을 사용하여 개인 기록과 동일한 ID로 저장
        recordWithId.recordId?.let { recordId ->
            sharedCollection.document(recordId).set(recordWithId).await()
        }
    }

    override suspend fun getUserRecord(): List<TripRecord> {
        // 사용자 ID 가져오기
        val userId = currentUserId

        return withContext(Dispatchers.IO) {
            try {
                // querySnapshot 객체 가져오기 (사용자의 전체 문서)
                val querySnapshot = firestore
                    .collection("records")
                    .document(userId)
                    .collection("private_records")
                    .orderBy("startDateMillis", Query.Direction.DESCENDING)
                    .get()
                    .await()

                val entityList = querySnapshot.toObjects<RecordEntity>()
                val domainList = entityList.map { RecordMapper.fromEntity(it) }

                return@withContext domainList
            } catch (e: Exception) {
                Log.e("record", "getUserRecord error", e)
                return@withContext emptyList()
            }
        }
    }

    /**
     * 기록/스탬프 수 1씩 증가
     */
    override suspend fun increaseRecordAndStamp() {
        val userId = currentUserId
        val userDoc = firestore.collection("users").document(userId)

        // Map으로 업데이트할 필드와 값을 지정
        val updateCnt = mapOf<String, Any>(
            "recordCnt" to FieldValue.increment(1),
            "stampCnt" to FieldValue.increment(1)
        )

        userDoc.update(updateCnt).await()
    }

    override suspend fun getSharedRecord(): List<TripRecord> {
        return withContext(Dispatchers.IO) {
            try {
                val querySnapshot = firestore
                    .collection("shared_records")
                    .orderBy("createdAt", Query.Direction.DESCENDING)
                    .get()
                    .await()

                val entityList = querySnapshot.toObjects<RecordEntity>()
                val domainList = entityList.map { RecordMapper.fromEntity(it) }

                return@withContext domainList
            } catch (e: Exception) {
                Log.e("record", "getSharedRecord error", e)
                return@withContext emptyList()
            }
        }
    }
}
