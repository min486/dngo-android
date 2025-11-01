package com.min.dnapp.data.repository

import android.net.Uri
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
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
    override suspend fun uploadImageAndGetUrl(imageUri: Uri, userId: String): String {
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

        // RecordEntity의 recordId 필드 채우기
        val recordWithId = record.copy(recordId = recordId)

        // set()을 사용하여 해당 ID로 저장
        newDoc.set(recordWithId).await()

        return recordWithId
    }

    /**
     * 전체공유 컬렉션에 저장
     */
    override suspend fun saveSharedRecord(record: RecordEntity) {
        val sharedCollection = firestore.collection("shared_records")

        // set()을 사용하여 개인 기록과 동일한 ID로 저장
        record.recordId?.let { recordId ->
            sharedCollection.document(recordId).set(record).await()
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
                val domainList = entityList.map { RecordMapper.toDomain(it) }

                return@withContext domainList
            } catch (e: Exception) {
                Log.e("record", "getUserRecord error", e)
                return@withContext emptyList()
            }
        }
    }
}
