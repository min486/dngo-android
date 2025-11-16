package com.min.dnapp.domain.model

import androidx.annotation.DrawableRes

data class Badge(
    val level: Int,
    val name: String,
    val description: String,
    val minStamp: Int,
    val nextBadgeRemainStamp: Int,
    @DrawableRes val resId: Int,
)
