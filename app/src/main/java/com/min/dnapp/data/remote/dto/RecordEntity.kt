package com.min.dnapp.data.remote.dto

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class RecordEntity(
    // firestore 문서 ID 값
    @get:Exclude
    var recordId: String = "",

    val userId: String = "",

    val title: String = "",
    val content: String = "",

    val startDateMillis: Long? = null,
    val endDateMillis: Long? = null,

    val emotionKey: String? = null,
    val weatherKey: String? = null,

    val selectedPlace: PlaceEntity? = null,
    val overseasPlace :String? = "",

    val isShareChecked: Boolean = false,

    val imageUrl: String? = null,

    // 서버 타임스탬프
    @ServerTimestamp
    val createdAt: Date? = null
)

data class PlaceEntity(
    val title: String,
    val category: String,
    val roadAddress: String
)
