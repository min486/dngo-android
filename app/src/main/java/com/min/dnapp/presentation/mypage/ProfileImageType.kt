package com.min.dnapp.presentation.mypage

import androidx.annotation.DrawableRes
import com.min.dnapp.R

enum class ProfileImageType(
    val key: String,
    @DrawableRes val resId: Int
) {
    BOAT("01_boat", R.drawable.logo_profile),
    TENT("02_tent", R.drawable.logo_profile2),
    SEA("03_sea", R.drawable.logo_profile3),
    BAG("04_bag", R.drawable.logo_profile4),
    PLANE("05_plane", R.drawable.logo_profile5),
    TELESCOPE("06_telescope", R.drawable.logo_profile6),
    MAP("07_map", R.drawable.logo_profile7),
    MOUNT("08_mount", R.drawable.logo_profile8)
}
