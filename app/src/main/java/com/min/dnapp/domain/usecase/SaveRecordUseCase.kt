package com.min.dnapp.domain.usecase

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.min.dnapp.data.mapper.RecordMapper
import com.min.dnapp.data.mapper.UserDataMapper
import com.min.dnapp.domain.repository.RecordRepository
import com.min.dnapp.presentation.write.RecordWriteUiState
import javax.inject.Inject

class SaveRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val firebaseAuth: FirebaseAuth
) {
    suspend operator fun invoke(
        uiState: RecordWriteUiState,
        imageUri: Uri?
    ): Result<Unit> {
        return try {
            // 이미지 업로드 (URL 획득)
            val imageUrl = if (imageUri != null) {
                recordRepository.uploadImageAndGetUrl(imageUri)
            } else {
                null
            }

            // domain 모델 생성 (UiState -> TripRecord)
            val tripRecord = RecordMapper.fromUiState(uiState, imageUrl)

            // 현재 사용자 ID
            val userId = firebaseAuth.currentUser?.uid ?: return Result.failure(IllegalStateException("user not login"))

            // 사용자 데이터 가져오기
            val user = getUserDataUseCase(userId)

            // User -> UserData 변환
            val userData = UserDataMapper.fromUser(user)

            // TripRecord + UserData -> RecordEntity
            val recordEntity = RecordMapper.fromDomain(tripRecord, userData)
                .copy(userId = userId)

            // 개인 기록 컬렉션에 저장 (필수)
            // recordId가 포함된 RecordEntity를 받아 새 변수에 저장
            val savedRecord = recordRepository.savePrivateRecord(recordEntity)

            // 공유 여부에 따라 전체공유 컬렉션에도 저장 (선택)
            if (uiState.isShareChecked) {
                // 동일한 recordId 포함된 savedRecord 사용
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
