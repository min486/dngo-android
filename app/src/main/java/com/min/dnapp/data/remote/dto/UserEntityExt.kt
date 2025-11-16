package com.min.dnapp.data.remote.dto

fun UserEntity.toSaveMap(): MutableMap<String, Any?> {
    return mutableMapOf(
        "userId" to this.userId,
        "nickname" to this.nickname,
        "profileImageName" to this.profileImageName,
        "badgeLv" to this.badgeLv,
        "badgeName" to this.badgeName,
        "recordCnt" to this.recordCnt,
        "stampCnt" to this.stampCnt,
        "createdAt" to this.createdAt
    )
}
