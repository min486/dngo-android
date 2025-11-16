package com.min.dnapp.util

import android.util.Log
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

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
    Log.d("record", "toDateString - date: $date")

    val formatter = SimpleDateFormat(format, Locale.getDefault())
    Log.d("record", "toDateString - formatter: $formatter")

    return formatter.format(date)
}

/**
 * 현재 시간 기준, 경과 시간으로 변환
 *
 * @return (예: "5분 전, "2시간 전")
 */
fun Long?.toTimeAgoString(): String {
    if (this == null || this == 0L) {
        return "날짜 없음"
    }

    // 현재 시간
    val nowMillis = System.currentTimeMillis()
    // 입력된 시간
    val inputMillis = this

    // 시간 차이
    val diffMillis = Math.abs(nowMillis - inputMillis)

    // 시간 차이를 단위별로 변환
    val seconds = TimeUnit.MILLISECONDS.toSeconds(diffMillis)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis)
    val hours = TimeUnit.MILLISECONDS.toHours(diffMillis)
    val days = TimeUnit.MILLISECONDS.toDays(diffMillis)

    return when {
        // 1분 미만
        seconds < 60 -> "방금 전"
        // 1시간 미만
        minutes < 60 -> "${minutes}분 전"
        // 24시간 미만
        hours < 24 -> "${hours}시간 전"
        // 7일 미만
        days < 7 -> "${days}일 전"
        // 30일 미만
        days < 30 -> "${days / 7}주 전"
        // 1년 미만
        days < 365 -> "${days / 30}달 전"
        // 1년 이상
        else -> "${days / 365}년 전"
    }
}
