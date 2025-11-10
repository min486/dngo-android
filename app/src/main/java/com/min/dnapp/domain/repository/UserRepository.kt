package com.min.dnapp.domain.repository

import com.min.dnapp.data.remote.dto.UserEntity

interface UserRepository {
    suspend fun getUserData(uid: String): UserEntity
    suspend fun updateProfileImage(profileImageName: String): Result<Unit>
    suspend fun updateNickname(nickname: String): Result<Unit>
}
