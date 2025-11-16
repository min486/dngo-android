package com.min.dnapp.presentation.find

import com.min.dnapp.domain.model.TripRecord

sealed class FindUiState {
    data object Loading: FindUiState()
    data class Success(
        val records: List<TripRecord> = emptyList()
    ) : FindUiState()
    data class Error(val message: String): FindUiState()
}
