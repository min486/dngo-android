package com.min.dnapp.domain.model

data class TripRecord(
    var recordId: String,
    val userId: String,
    val title: String,
    val content: String,
    val startDateMillis: Long,
    val endDateMillis: Long,
    val emotionKey: String,
    val weatherKey: String,
    // 복합 객체여서 nullable일 수 있음
    val selectedPlace: LocalPlace?,
    val overseasPlace: String,
    val isShareChecked: Boolean,
    val imageUrl: String,
    val createdAt: Long
)
