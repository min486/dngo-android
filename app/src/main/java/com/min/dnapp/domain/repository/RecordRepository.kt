package com.min.dnapp.domain.repository

import android.net.Uri
import com.min.dnapp.data.remote.dto.RecordEntity
import com.min.dnapp.domain.model.TripRecord

interface RecordRepository {
    suspend fun uploadImageAndGetUrl(imageUri: Uri): String
    suspend fun savePrivateRecord(record: RecordEntity): RecordEntity
    suspend fun saveSharedRecord(record: RecordEntity)
    suspend fun getUserRecord(): List<TripRecord>
    suspend fun increaseRecordAndStamp()
}
