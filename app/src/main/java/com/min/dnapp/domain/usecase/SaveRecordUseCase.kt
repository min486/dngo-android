package com.min.dnapp.domain.usecase

import android.net.Uri
import com.min.dnapp.data.mapper.RecordMapper
import com.min.dnapp.domain.repository.AuthRepository
import com.min.dnapp.domain.repository.RecordRepository
import com.min.dnapp.presentation.write.RecordWriteUiState
import javax.inject.Inject

class SaveRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository,
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        uiState: RecordWriteUiState,
        imageUri: Uri?
    ): Result<Unit> {
        return try {
            val userId = authRepository.getCurrentUserId() ?: return Result.failure(IllegalStateException("user not login"))

            // 이미지 업로드 (URL 획득)
            val imageUrl = if (imageUri != null) {
                recordRepository.uploadImageAndGetUrl(imageUri, userId)
            } else {
                null
            }

            // uiState를 Entity로 변환
            val recordEntity = RecordMapper.toEntity(uiState, imageUrl)

            // 개인 기록 컬렉션에 저장 (필수)
            // recordId가 포함된 RecordEntity를 받아 새 변수에 저장
            val savedRecord = recordRepository.savePrivateRecord(recordEntity)

            // 공유 여부에 따라 전체공유 컬렉션에도 저장 (선택)
            if (uiState.isShareChecked) {
                // ID가 포함된 savedRecord 사용
                recordRepository.saveSharedRecord(savedRecord)
            }

            // 기록/스탬프 수 1씩 증가
            recordRepository.increaseRecordAndStamp()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
