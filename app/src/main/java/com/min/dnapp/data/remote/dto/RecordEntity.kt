package com.min.dnapp.data.remote.dto

import com.google.firebase.Timestamp
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp

data class RecordEntity(
    // firestore 문서 ID 값
    @get:Exclude
    var recordId: String? = null,

    val userId: String? = null,

    val title: String? = null,
    val content: String? = null,

    val startDateMillis: Long? = null,
    val endDateMillis: Long? = null,

    val emotionKey: String? = null,
    val weatherKey: String? = null,

    val selectedPlace: PlaceEntity? = null,
    val overseasPlace: String? = null,

    val isShareChecked: Boolean? = null,

    val imageUrl: String? = null,

    // 서버 타임스탬프
    @ServerTimestamp
    val createdAt: Timestamp? = null
)

data class PlaceEntity(
    val title: String? = null,
    val category: String? = null,
    val roadAddress: String? = null
)
