package com.min.dnapp.presentation.write

import com.min.dnapp.domain.model.LocalPlace

data class SearchState(
    val isLoading: Boolean = false,
    val places: List<LocalPlace> = emptyList(),
    val error: String? = null,
    val query: String = ""
)
