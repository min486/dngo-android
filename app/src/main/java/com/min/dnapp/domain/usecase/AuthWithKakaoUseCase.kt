package com.min.dnapp.domain.usecase

import android.content.Context
import com.min.dnapp.domain.repository.AuthRepository
import javax.inject.Inject

class AuthWithKakaoUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(context: Context): Result<Unit> {
        return authRepository.signInWithKakao(context)
    }
}
