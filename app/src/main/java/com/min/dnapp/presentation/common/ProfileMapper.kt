package com.min.dnapp.presentation.common

import com.min.dnapp.R

object ProfileMapper {
    fun getProfileImageResId(profileName: String): Int {
        return when (profileName) {
            "01_boat" -> R.drawable.logo_profile
            "02_tent" -> R.drawable.logo_profile2
            "03_sea" -> R.drawable.logo_profile3
            "04_bag" -> R.drawable.logo_profile4
            "05_plane" -> R.drawable.logo_profile5
            "06_telescope" -> R.drawable.logo_profile6
            "07_map" -> R.drawable.logo_profile7
            "08_mount" -> R.drawable.logo_profile8
            else -> R.drawable.logo_profile
        }
    }
}
