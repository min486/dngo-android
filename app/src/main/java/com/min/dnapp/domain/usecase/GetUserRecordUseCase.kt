package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.domain.repository.RecordRepository
import javax.inject.Inject

class GetUserRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository
) {
    suspend operator fun invoke(): List<TripRecord> {
        return recordRepository.getUserRecord()
    }
}
