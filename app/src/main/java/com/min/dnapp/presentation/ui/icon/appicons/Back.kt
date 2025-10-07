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

public val AppIcons.Back: ImageVector
    get() {
        if (_back != null) {
            return _back!!
        }
        _back = Builder(name = "Back", defaultWidth = 16.0.dp, defaultHeight = 12.0.dp,
                viewportWidth = 16.0f, viewportHeight = 12.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.121f, 6.0f)
                lineTo(0.708f, 5.587f)
                lineTo(0.296f, 6.0f)
                lineTo(0.708f, 6.413f)
                lineTo(1.121f, 6.0f)
                close()
                moveTo(15.121f, 6.583f)
                curveTo(15.276f, 6.583f, 15.424f, 6.522f, 15.533f, 6.413f)
                curveTo(15.643f, 6.303f, 15.704f, 6.155f, 15.704f, 6.0f)
                curveTo(15.704f, 5.845f, 15.643f, 5.697f, 15.533f, 5.588f)
                curveTo(15.424f, 5.478f, 15.276f, 5.417f, 15.121f, 5.417f)
                verticalLineTo(6.583f)
                close()
                moveTo(5.374f, 0.92f)
                lineTo(0.708f, 5.587f)
                lineTo(1.534f, 6.413f)
                lineTo(6.2f, 1.746f)
                lineTo(5.374f, 0.92f)
                close()
                moveTo(0.708f, 6.413f)
                lineTo(5.374f, 11.08f)
                lineTo(6.2f, 10.254f)
                lineTo(1.534f, 5.587f)
                lineTo(0.708f, 6.413f)
                close()
                moveTo(1.121f, 6.583f)
                horizontalLineTo(15.121f)
                verticalLineTo(5.417f)
                horizontalLineTo(1.121f)
                verticalLineTo(6.583f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(1.121f, 6.0f)
                lineTo(0.708f, 5.587f)
                lineTo(0.296f, 6.0f)
                lineTo(0.708f, 6.413f)
                lineTo(1.121f, 6.0f)
                close()
                moveTo(15.121f, 6.583f)
                curveTo(15.276f, 6.583f, 15.424f, 6.522f, 15.533f, 6.413f)
                curveTo(15.643f, 6.303f, 15.704f, 6.155f, 15.704f, 6.0f)
                curveTo(15.704f, 5.845f, 15.643f, 5.697f, 15.533f, 5.588f)
                curveTo(15.424f, 5.478f, 15.276f, 5.417f, 15.121f, 5.417f)
                verticalLineTo(6.583f)
                close()
                moveTo(5.374f, 0.92f)
                lineTo(0.708f, 5.587f)
                lineTo(1.534f, 6.413f)
                lineTo(6.2f, 1.746f)
                lineTo(5.374f, 0.92f)
                close()
                moveTo(0.708f, 6.413f)
                lineTo(5.374f, 11.08f)
                lineTo(6.2f, 10.254f)
                lineTo(1.534f, 5.587f)
                lineTo(0.708f, 6.413f)
                close()
                moveTo(1.121f, 6.583f)
                horizontalLineTo(15.121f)
                verticalLineTo(5.417f)
                horizontalLineTo(1.121f)
                verticalLineTo(6.583f)
                close()
            }
        }
        .build()
        return _back!!
    }

private var _back: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Back, contentDescription = "")
    }
}
