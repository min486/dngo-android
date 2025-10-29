package com.min.dnapp.data.mapper

import com.min.dnapp.data.remote.dto.PlaceEntity
import com.min.dnapp.data.remote.dto.RecordEntity
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.presentation.write.RecordWriteUiState

/**
 * RecordWriteUiState -> RecordEntity 변환
 */
fun RecordWriteUiState.toEntity(userId: String, imageUrl: String?): RecordEntity {
    return RecordEntity(
        userId = userId,
        title = this.recordTitle,
        content = this.recordContent,
        startDateMillis = this.selectedStartDateMillis,
        endDateMillis = this.selectedEndDateMillis,
        emotionKey = this.selectedEmotion?.key,
        weatherKey = this.selectedWeather?.key,
        selectedPlace = this.selectedPlace?.toEntity(),
        overseasPlace = this.overseasPlace,
        isShareChecked = this.isShareChecked,
        // 업로드 후 받은 URL
        imageUrl = imageUrl
    )
}

/**
 * LocalPlace -> PlaceEntity 변환
 */
fun LocalPlace.toEntity(): PlaceEntity {
    return PlaceEntity(
        title = this.title,
        category = this.category,
        roadAddress = this.roadAddress
    )
}
