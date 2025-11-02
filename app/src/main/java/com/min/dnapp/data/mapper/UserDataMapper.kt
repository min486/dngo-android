package com.min.dnapp.data.mapper

import com.min.dnapp.data.remote.dto.UserDataEntity
import com.min.dnapp.domain.model.User
import com.min.dnapp.domain.model.UserData

object UserDataMapper {
    /**
     * User -> UserData 변환
     */
    fun fromUser(user: User): UserData {
        return UserData(
            badgeLv = user.badgeLv,
            nickname = user.badgeName,
            profileImageName = user.profileImageName
        )
    }

    /**
     * UserData -> UserDataEntity 변환
     */
    fun fromUserData(userData: UserData): UserDataEntity {
        return UserDataEntity(
            badgeLv = userData.badgeLv,
            nickname = userData.nickname,
            profileImageName = userData.profileImageName
        )
    }

    /**
     * UserDataEntity -> UserData 변환
     */
    fun fromUserDataEntity(userDataEntity: UserDataEntity): UserData {
        return UserData(
            badgeLv = userDataEntity.badgeLv ?: 1,
            nickname = userDataEntity.nickname ?: "",
            profileImageName = userDataEntity.profileImageName ?: "01_boat"
        )
    }
}
