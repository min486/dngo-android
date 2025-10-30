package com.min.dnapp.data.remote.dto

import com.google.firebase.Timestamp

data class UserEntity(
    val userId: String? = null,
    val nickname: String? = null,
    val profileImageName: String? = "01_boat",
    val badgeLv: Int? = 1,
    val badgeName: String? = "새내기",
    val recordCnt: Int? = 0,
    val stampCnt: Int? = 0,
    val createdAt: Timestamp? = null
)
