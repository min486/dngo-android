package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.AuthRepository
import javax.inject.Inject

class UnlinkUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return authRepository.unlinkUser()
    }
}
