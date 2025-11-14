package com.min.dnapp.presentation.init

sealed class SaveImageState {
    data object Init : SaveImageState()
    data object Loading : SaveImageState()
    data object Success : SaveImageState()
    data class Error(val message: String) : SaveImageState()
}
