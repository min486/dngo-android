package com.min.dnapp.presentation.home

import com.min.dnapp.domain.model.TripRecord

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(
        val nickname: String,
        val badgeName: String,
        val recordCnt: Int,
        val stampCnt: Int,
        // badgeLv을 통해 매핑된 이미지 리소스 ID
        val badgeImageResId: Int,
        // 기록 목록
        val records: List<TripRecord> = emptyList()
    ) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
