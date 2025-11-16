package com.min.dnapp.presentation.mypage

import com.min.dnapp.domain.model.User

sealed class MypageUiState {
    data object Loading : MypageUiState()
    data class Success(
        val user: User
    ) : MypageUiState()
    data class Error(val message: String) : MypageUiState()
}
