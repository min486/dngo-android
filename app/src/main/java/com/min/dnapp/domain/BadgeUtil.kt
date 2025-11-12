package com.min.dnapp.domain

import com.min.dnapp.R
import com.min.dnapp.domain.model.Badge

val AllBadges = listOf(
    Badge(
        level = 1,
        name = "새내기",
        description = "다음 뱃지까지 5개 남았어요",
        minStamp = 0,
        nextBadgeRemainStamp = 5,
        resId = R.drawable.badge_new,
    ),
    Badge(
        level = 2,
        name = "여린이",
        description = "다음 뱃지까지 15개 남았어요",
        minStamp = 5,
        nextBadgeRemainStamp = 15,
        resId = R.drawable.badge_bronze
    ),
    Badge(
        level = 2,
        name = "여행자",
        description = "다음 뱃지까지 10개 남았어요",
        minStamp = 20,
        nextBadgeRemainStamp = 10,
        resId = R.drawable.badge_silver
    ),
    Badge(
        level = 3,
        name = "마스터",
        description = "최고 뱃지에 도달하셨어요",
        minStamp = 30,
        nextBadgeRemainStamp = 0,
        resId = R.drawable.badge_gold
    )
)

fun getNewBadgeData(totalStamp: Int): Badge? {
    return AllBadges.firstOrNull { it.minStamp == totalStamp }
}
