package com.min.dnapp.presentation.mypage

import androidx.annotation.DrawableRes
import com.min.dnapp.R

enum class ProfileImageType(
    val key: String,
    @DrawableRes val resId: Int
) {
    BOAT("boat", R.drawable.logo_profile),
    TENT("tent", R.drawable.logo_profile2),
    SEA("sea", R.drawable.logo_profile3),
    BAG("bag", R.drawable.logo_profile4),
    PLANE("plane", R.drawable.logo_profile5),
    TELESCOPE("telescope", R.drawable.logo_profile6),
    MAP("map", R.drawable.logo_profile7),
    MOUNT("mount", R.drawable.logo_profile8)
}
