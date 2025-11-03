package com.min.dnapp.presentation.common

import com.min.dnapp.R

object WeatherMapper {
    fun getWeatherImageResId(weatherName: String): Int {
        return when (weatherName) {
            "sun" -> R.drawable.weather_sun
            "wind" -> R.drawable.weather_wind
            "moon" -> R.drawable.weather_moon
            "thunder" -> R.drawable.weather_thunder
            "rain" -> R.drawable.weather_rain
            "cloud" -> R.drawable.weather_cloud
            "snow" -> R.drawable.weather_snow
            else -> R.drawable.weather_sun
        }
    }
}
