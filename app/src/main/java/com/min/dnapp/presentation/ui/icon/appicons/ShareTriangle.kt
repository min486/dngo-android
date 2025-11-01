package com.min.dnapp.presentation.ui.icon.appicons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.icon.AppIcons
import kotlin.Unit

public val AppIcons.ShareTriangle: ImageVector
    get() {
        if (_shareTriangle != null) {
            return _shareTriangle!!
        }
        _shareTriangle = Builder(name = "ShareTriangle", defaultWidth = 12.0.dp, defaultHeight =
                8.0.dp, viewportWidth = 12.0f, viewportHeight = 8.0f).apply {
            path(fill = SolidColor(Color(0xFF6E8B74)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(6.0f, 8.0f)
                lineTo(12.0f, 0.0f)
                horizontalLineTo(0.0f)
                lineTo(6.0f, 8.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.0f, 8.0f)
                lineTo(12.0f, 0.0f)
                horizontalLineTo(0.0f)
                lineTo(6.0f, 8.0f)
                close()
            }
        }
        .build()
        return _shareTriangle!!
    }

private var _shareTriangle: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.ShareTriangle, contentDescription = "")
    }
}
