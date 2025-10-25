package com.min.dnapp.domain.model

import androidx.annotation.DrawableRes
import com.min.dnapp.R

enum class WeatherType(
    val key: String,
    @DrawableRes val resId: Int
) {
    SUN("sun", R.drawable.weather_sun),
    WIND("wind", R.drawable.weather_wind),
    MOON("moon", R.drawable.weather_moon),
    THUNDER("thunder", R.drawable.weather_thunder),
    RAIN("rain", R.drawable.weather_rain),
    CLOUD("cloud", R.drawable.weather_cloud),
    SNOW("snow", R.drawable.weather_snow)
}
