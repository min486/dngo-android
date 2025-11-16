package com.min.dnapp.domain.model

data class User(
    val userId: String,
    val nickname: String,
    val profileImageName: String,
    val badgeLv: Int,
    val badgeName: String,
    val recordCnt: Int,
    val stampCnt: Int,
    val createdAt: Long
)
