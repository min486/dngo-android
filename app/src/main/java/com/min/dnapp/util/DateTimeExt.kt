package com.min.dnapp.util

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

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
