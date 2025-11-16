package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.UserRepository
import javax.inject.Inject

class UpdateNicknameUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(nickname: String): Result<Unit> {
        return userRepository.updateNickname(nickname)
    }
}
