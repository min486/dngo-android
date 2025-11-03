package com.min.dnapp.presentation.mypage

import com.min.dnapp.domain.model.TripRecord

sealed class MyRecordUiState {
    data object Loading: MyRecordUiState()
    data class Success(
        val records: List<TripRecord> = emptyList()
    ) : MyRecordUiState()
    data class Error(val message: String): MyRecordUiState()
}