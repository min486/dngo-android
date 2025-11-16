package com.min.dnapp.util

/**
 * 문자열에서 태그를 제거하는 확장함수
 * 네이버 검색 API의 title 필드에 포함된 <b> 태그를 제거하는데 사용
 */
fun String.removeTag(): String {
    return this.replace(Regex("<(/)?b>"), "")
}

/**
 * 카테고리 문자열에서 가장 마지막 카테고리를 추출하는 확장함수
 * 예: "음식점>일식>돈가스" -> "돈가스"
 */
fun String.extractLastCategory(): String {
    return this.split(">").lastOrNull() ?: this
}
