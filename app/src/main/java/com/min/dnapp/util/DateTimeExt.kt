package com.min.dnapp.util

import android.util.Log
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.util.Locale

/**
 * Long(밀리초) 값을 시스템 기본 시간대를 기준으로 LocalDate로 변환
 */
fun Long?.toLocalDate(): LocalDate? {
    if (this == null || this == 0L) {
        return null
    }

    return Instant.ofEpochMilli(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
}

/**
 * 원하는 날짜 포맷으로 변환
 */
fun Long.toDateString(format: String): String {
    val date = Date(this)
    Log.d("home", "toDateString - date: $date")

    val formatter = SimpleDateFormat(format, Locale.getDefault())
    Log.d("home", "toDateString - formatter: $formatter")

    return formatter.format(date)
}
