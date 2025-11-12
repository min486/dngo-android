package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.model.Badge
import com.min.dnapp.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserBadgeUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(badge: Badge): Result<Unit> {
        return userRepository.updateBadge(badge)
    }
}
