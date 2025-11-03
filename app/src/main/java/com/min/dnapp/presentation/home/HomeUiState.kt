package com.min.dnapp.presentation.home

import com.min.dnapp.domain.model.TripRecord

sealed class HomeUiState {
    data object Loading : HomeUiState()
    data class Success(
        val nickname: String,
        val badgeLv: Int,
        val badgeName: String,
        val recordCnt: Int,
        val stampCnt: Int,
        // 기록 목록
        val records: List<TripRecord> = emptyList()
    ) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}
