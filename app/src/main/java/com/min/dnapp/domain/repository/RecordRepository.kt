package com.min.dnapp.domain.repository

import android.net.Uri
import com.min.dnapp.data.remote.dto.RecordEntity

interface RecordRepository {
    suspend fun uploadImageAndGetUrl(imageUri: Uri, userId: String): String
    suspend fun savePrivateRecord(record: RecordEntity): RecordEntity
    suspend fun saveSharedRecord(record: RecordEntity)
}
