package com.min.dnapp.presentation.write

import android.net.Uri
import com.min.dnapp.domain.model.EmotionType
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.model.WeatherType

data class SearchState(
    val isLoading: Boolean = false,
    val places: List<LocalPlace> = emptyList(),
    val error: String? = null,
    val query: String = ""
)

data class RecordWriteUiState(
    val isSaving: Boolean = false,
    val recordTitle: String = "",
    val recordContent: String = "",
    val selectedStartDateMillis: Long? = null,
    val selectedEndDateMillis: Long? = null,
    val selectedEmotion: EmotionType? = null,
    val selectedWeather : WeatherType? = null,
    val searchState: SearchState = SearchState(),
    val selectedPlace: LocalPlace? = null,
    val overseasPlace: String = "",
    val selectedImageUri: Uri? = null,
    val isShareChecked: Boolean = true
)
