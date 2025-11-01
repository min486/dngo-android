package com.min.dnapp.presentation.common

import com.min.dnapp.R

object BadgeMapper {
    fun getBadgeImageResId(badgeLv: Int): Int {
        return when (badgeLv) {
            1 -> R.drawable.badge_new
            2 -> R.drawable.badge_bronze
            3 -> R.drawable.badge_silver
            4 -> R.drawable.badge_gold
            else -> R.drawable.badge_new
        }
    }
}
