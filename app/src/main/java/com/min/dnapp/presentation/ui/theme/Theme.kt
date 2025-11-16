package com.min.dnapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class MomentoColors(
    // primary (brown)
    val brownBg: Color,
    val brownW90: Color,
    val brownW80: Color,
    val brownW70: Color,
    val brownW60: Color,
    val brownW50: Color,
    val brownW40: Color,
    val brownW20: Color,
    val brownBase: Color,
    val brownB20: Color,
    val brownB40: Color,
    val brownB60: Color,
    val brownB80: Color,

    // secondary (pink)
    val pinkW80: Color,
    val pinkW60: Color,
    val pinkW40: Color,
    val pinkW20: Color,
    val pinkBase: Color,
    val pinkB20: Color,
    val pinkB40: Color,
    val pinkB60: Color,
    val pinkB80: Color,

    // secondary (green)
    val greenW80: Color,
    val greenW60: Color,
    val greenW40: Color,
    val greenW20: Color,
    val greenBase: Color,

    // gray
    val grayW10: Color,
    val grayW20: Color,
    val grayW40: Color,
    val grayW60: Color,
    val grayW80: Color,
    val grayW90: Color,

    val black: Color,
    val white: Color,

    val isDark: Boolean
)

private val LightColorPalette = MomentoColors(
    brownBg = Brown_Bg,
    brownW90 = Brown_W90,
    brownW80 = Brown_W80,
    brownW70 = Brown_W70,
    brownW60 = Brown_W60,
    brownW50 = Brown_W50,
    brownW40 = Brown_W40,
    brownW20 = Brown_W20,
    brownBase = Brown_Base,
    brownB20 = Brown_B20,
    brownB40 = Brown_B40,
    brownB60 = Brown_B60,
    brownB80 = Brown_B80,
    pinkW80 = Pink_W80,
    pinkW60 = Pink_W60,
    pinkW40 = Pink_W40,
    pinkW20 = Pink_W20,
    pinkBase = Pink_Base,
    pinkB20 = Pink_B20,
    pinkB40 = Pink_B40,
    pinkB60 = Pink_B60,
    pinkB80 = Pink_B80,
    greenW80 = Green_W80,
    greenW60 = Green_W60,
    greenW40 = Green_W40,
    greenW20 = Green_W20,
    greenBase = Green_Base,
    grayW10 = Gray_W10,
    grayW20 = Gray_W20,
    grayW40 = Gray_W40,
    grayW60 = Gray_W60,
    grayW80 = Gray_W80,
    grayW90 = Gray_W90,
    black = Black,
    white = White,
    isDark = false
)

private val DarkColorPalette = LightColorPalette.copy(
    isDark = true
)

/**
 * CompositionLocal을 통해 커스텀 color palette 제공
 */
private val LocalMomentoColors = staticCompositionLocalOf<MomentoColors> {
    error("No MomentoColorPalette provided")
}

// Material3 기본 ColorScheme에 커스텀 color 매핑
private fun momentoLightColorScheme(colors: MomentoColors) = lightColorScheme(
    primary = colors.brownBase,
    onPrimary = colors.white,
    background = colors.brownBg,
    onBackground = colors.black,
    surface = colors.white,
    onSurface = colors.grayW10
)

@Composable
fun DngoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val appTypography = getAppTypography()
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    CompositionLocalProvider(
        LocalAppTypography provides appTypography,
        LocalMomentoColors provides colors
    ) {
        MaterialTheme(
            colorScheme = momentoLightColorScheme(colors),
            content = content
        )
    }
}

/**
 * Momento 디자인 속성에 접근하기 위한 객체
 */
object MomentoTheme {
    val typography: AppTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalAppTypography.current

    val colors: MomentoColors
    @Composable
    @ReadOnlyComposable
    get() = LocalMomentoColors.current
}
