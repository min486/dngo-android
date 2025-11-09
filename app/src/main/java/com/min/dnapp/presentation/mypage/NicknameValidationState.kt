package com.min.dnapp.presentation.mypage

data class NicknameValidationState(
    val currentNickname: String = "",
    val errorMessage: String? = null,
    val isValid: Boolean = false,
    val isSaving: Boolean = false
)
