package com.min.dnapp.data.mapper

import com.min.dnapp.data.remote.dto.UserEntity
import com.min.dnapp.domain.model.User

object UserMapper {
    /**
     * Entity -> Domain 변환
     */
    fun toDomain(entity: UserEntity): User {
        return User(
            userId = entity.userId ?: "",
            nickname = entity.nickname ?: "",
            profileImageName = entity.profileImageName ?: "01_boat",
            badgeLv = entity.badgeLv ?: 1,
            badgeName = entity.badgeName ?: "새내기",
            recordCnt = entity.recordCnt ?: 0,
            stampCnt = entity.stampCnt ?: 0,
            // Timestamp -> Long 변환
            createdAt = entity.createdAt?.toDate()?.time ?: 0L
        )
    }

    /**
     * Domain -> Entity 변환
     */
    fun toEntity(domain: User): UserEntity {
        return UserEntity(
            userId = domain.userId,
            nickname = domain.nickname,
            profileImageName = domain.profileImageName,
            badgeLv = domain.badgeLv,
            badgeName = domain.badgeName,
            recordCnt = domain.recordCnt,
            stampCnt = domain.stampCnt,
            // firestore 서버에서 시간 기록
            createdAt = null
        )
    }
}
