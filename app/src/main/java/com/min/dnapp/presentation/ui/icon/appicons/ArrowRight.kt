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

public val AppIcons.ArrowRight: ImageVector
    get() {
        if (_arrowRight != null) {
            return _arrowRight!!
        }
        _arrowRight = Builder(name = "ArrowRight", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.546f, 12.0f)
                lineTo(18.9f, 11.646f)
                lineTo(19.253f, 12.0f)
                lineTo(18.9f, 12.354f)
                lineTo(18.546f, 12.0f)
                close()
                moveTo(6.547f, 12.5f)
                curveTo(6.414f, 12.5f, 6.287f, 12.447f, 6.193f, 12.354f)
                curveTo(6.099f, 12.26f, 6.047f, 12.133f, 6.047f, 12.0f)
                curveTo(6.047f, 11.867f, 6.099f, 11.74f, 6.193f, 11.646f)
                curveTo(6.287f, 11.553f, 6.414f, 11.5f, 6.547f, 11.5f)
                verticalLineTo(12.5f)
                close()
                moveTo(14.901f, 7.646f)
                lineTo(18.9f, 11.646f)
                lineTo(18.192f, 12.354f)
                lineTo(14.193f, 8.354f)
                lineTo(14.901f, 7.646f)
                close()
                moveTo(18.9f, 12.354f)
                lineTo(14.901f, 16.354f)
                lineTo(14.193f, 15.646f)
                lineTo(18.192f, 11.646f)
                lineTo(18.9f, 12.354f)
                close()
                moveTo(18.546f, 12.5f)
                horizontalLineTo(6.547f)
                verticalLineTo(11.5f)
                horizontalLineTo(18.546f)
                verticalLineTo(12.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.546f, 12.0f)
                lineTo(18.9f, 11.646f)
                lineTo(19.253f, 12.0f)
                lineTo(18.9f, 12.354f)
                lineTo(18.546f, 12.0f)
                close()
                moveTo(6.547f, 12.5f)
                curveTo(6.414f, 12.5f, 6.287f, 12.447f, 6.193f, 12.354f)
                curveTo(6.099f, 12.26f, 6.047f, 12.133f, 6.047f, 12.0f)
                curveTo(6.047f, 11.867f, 6.099f, 11.74f, 6.193f, 11.646f)
                curveTo(6.287f, 11.553f, 6.414f, 11.5f, 6.547f, 11.5f)
                verticalLineTo(12.5f)
                close()
                moveTo(14.901f, 7.646f)
                lineTo(18.9f, 11.646f)
                lineTo(18.192f, 12.354f)
                lineTo(14.193f, 8.354f)
                lineTo(14.901f, 7.646f)
                close()
                moveTo(18.9f, 12.354f)
                lineTo(14.901f, 16.354f)
                lineTo(14.193f, 15.646f)
                lineTo(18.192f, 11.646f)
                lineTo(18.9f, 12.354f)
                close()
                moveTo(18.546f, 12.5f)
                horizontalLineTo(6.547f)
                verticalLineTo(11.5f)
                horizontalLineTo(18.546f)
                verticalLineTo(12.5f)
                close()
            }
        }
        .build()
        return _arrowRight!!
    }

private var _arrowRight: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.ArrowRight, contentDescription = "")
    }
}
