package com.min.dnapp.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.min.dnapp.R

private val pretendard = FontFamily(
    Font(resId = R.font.pretendard_regular, weight = FontWeight.Normal),
    Font(resId = R.font.pretendard_medium, weight = FontWeight.Medium),
    Font(resId = R.font.pretendard_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.pretendard_bold, weight = FontWeight.Bold)
)

/**
 * 커스텀 폰트 스타일 정의
 */
@Immutable
data class AppTypography(
    val display: TextStyle,
    val title01: TextStyle,
    val title02: TextStyle,
    val body01: TextStyle,
    val body02: TextStyle,
    val body03: TextStyle,
    val label: TextStyle,
    val caption: TextStyle
)

/**
 * CompositionLocal을 통해 커스텀 typography 제공
 */
val LocalAppTypography = staticCompositionLocalOf<AppTypography> {
    error("No AppTypography provided")
}

fun getAppTypography(): AppTypography {
    return AppTypography(
        display = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = (24 * 1.3).sp,  // 130%
            letterSpacing = (-0.01).em   // -1%
        ),
        title01 = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            lineHeight = (20 * 1.3).sp,
            letterSpacing = (-0.01).em
        ),
        title02 = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = (16 * 1.4).sp,
            letterSpacing = (-0.01).em
        ),
        body01 = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = (16 * 1.4).sp,
            letterSpacing = (-0.01).em
        ),
        body02 = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = (14 * 1.4).sp,
            letterSpacing = (-0.01).em
        ),
        body03 = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = (12 * 1.4).sp,
            letterSpacing = (-0.01).em
        ),
        label = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = (12 * 1.3).sp,
            letterSpacing = (-0.01).em
        ),
        caption = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = (10  * 1.3).sp,
            letterSpacing = (-0.01).em
        )
    )
}
