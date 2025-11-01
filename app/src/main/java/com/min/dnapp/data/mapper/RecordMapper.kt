package com.min.dnapp.data.mapper

import com.min.dnapp.data.remote.dto.RecordEntity
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.presentation.write.RecordWriteUiState

object RecordMapper {
    /**
     * RecordWriteUiState -> RecordEntity 변환
     */
    fun toEntity(uiState: RecordWriteUiState, imageUrl: String?): RecordEntity {
        return RecordEntity(
            title = uiState.recordTitle,
            content = uiState.recordContent,
            startDateMillis = uiState.selectedStartDateMillis,
            endDateMillis = uiState.selectedEndDateMillis,
            emotionKey = uiState.selectedEmotion?.key,
            weatherKey = uiState.selectedWeather?.key,
            selectedPlace = uiState.selectedPlace?.toEntity(),
            overseasPlace = uiState.overseasPlace,
            isShareChecked = uiState.isShareChecked,
            // 업로드 후 받은 URL
            imageUrl = imageUrl
        )
    }

    /**
     * Entity -> Domain 변환
     */
    fun toDomain(entity: RecordEntity): TripRecord {
        return TripRecord(
            recordId = entity.recordId ?: "",
            userId = entity.userId ?: "",
            title = entity.title ?: "",
            content = entity.content ?: "",
            startDateMillis = entity.startDateMillis ?: 0L,
            endDateMillis = entity.endDateMillis ?: 0L,
            emotionKey = entity.emotionKey ?: "",
            weatherKey = entity.weatherKey ?: "",
            selectedPlace = entity.selectedPlace?.toDomain(),
            overseasPlace = entity.overseasPlace ?: "",
            isShareChecked = entity.isShareChecked ?: false,
            imageUrl = entity.imageUrl ?: "",
            createdAt = entity.createdAt?.toDate()?.time ?: 0L
        )
    }
}
