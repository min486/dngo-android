package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.UserRepository
import javax.inject.Inject

class UpdateProfileImageUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(profileImageName: String): Result<Unit> {
        return userRepository.updateProfileImage(profileImageName)
    }
}
