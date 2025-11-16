package com.min.dnapp.domain.repository

import com.min.dnapp.data.remote.dto.UserEntity
import com.min.dnapp.domain.model.Badge

interface UserRepository {
    suspend fun getUserData(uid: String): UserEntity
    suspend fun updateProfileImage(profileImageName: String): Result<Unit>
    suspend fun updateNickname(nickname: String): Result<Unit>
    suspend fun updateBadge(badge: Badge): Result<Unit>
}
