package com.min.dnapp.domain.usecase

import android.content.Context
import com.min.dnapp.domain.model.UserProfile
import com.min.dnapp.domain.repository.AuthRepository
import javax.inject.Inject

class SignInWithKakaoUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(context: Context): Result<UserProfile> {
        return authRepository.signInWithKakao(context)
    }
}
