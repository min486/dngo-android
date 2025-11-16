package com.min.dnapp.data.mapper

import com.min.dnapp.data.remote.dto.RecordEntity
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.domain.model.UserData
import com.min.dnapp.presentation.write.RecordWriteUiState

object RecordMapper {
    /**
     * RecordWriteUiState -> TripRecord (Domain) 변환
     */
    fun fromUiState(uiState: RecordWriteUiState, imageUrl: String?): TripRecord {
        return TripRecord(
            title = uiState.recordTitle,
            content = uiState.recordContent,
            startDateMillis = uiState.selectedStartDateMillis ?: 0L,
            endDateMillis = uiState.selectedEndDateMillis ?: 0L,
            emotionKey = uiState.selectedEmotion?.key ?: "",
            weatherKey = uiState.selectedWeather?.key ?: "",
            selectedPlace = uiState.selectedPlace,
            overseasPlace = uiState.overseasPlace,
            isShareChecked = uiState.isShareChecked,
            // 업로드 후 받은 URL
            imageUrl = imageUrl ?: "",
            createdAt = 0L,
            userId = "",
            userData = null,
        )
    }

    /**
     * TripRecord (Domain) -> RecordEntity 변환
     */
    fun fromDomain(tripRecord: TripRecord, userData: UserData): RecordEntity {
        return RecordEntity(
            title = tripRecord.title,
            content = tripRecord.content,
            startDateMillis = tripRecord.startDateMillis,
            endDateMillis = tripRecord.endDateMillis,
            emotionKey = tripRecord.emotionKey,
            weatherKey = tripRecord.weatherKey,
            selectedPlace = tripRecord.selectedPlace?.toEntity(),
            overseasPlace = tripRecord.overseasPlace,
            isShareChecked = tripRecord.isShareChecked,
            // 업로드 후 받은 URL
            imageUrl = tripRecord.imageUrl,
            userData = UserDataMapper.fromUserData(userData)
        )
    }

    /**
     * RecordEntity -> TripRecord (Domain) 변환
     */
    fun fromEntity(entity: RecordEntity): TripRecord {
        return TripRecord(
//            recordId = entity.recordId ?: "",
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
            createdAt = entity.createdAt?.toDate()?.time ?: 0L,
            userData = entity.userData?.let { UserDataMapper.fromUserDataEntity(it) }
        )
    }
}
