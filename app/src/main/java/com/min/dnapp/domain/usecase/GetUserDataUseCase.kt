package com.min.dnapp.domain.usecase

import com.min.dnapp.data.mapper.UserMapper
import com.min.dnapp.domain.model.User
import com.min.dnapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(uid: String): User {
        val userEntity = userRepository.getUserData(uid)

        // UserEntity -> User 변환
        return UserMapper.toDomain(userEntity)
    }
}
