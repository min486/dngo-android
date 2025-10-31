package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserIdUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): String? {
        return authRepository.getCurrentUserId()
    }
}
