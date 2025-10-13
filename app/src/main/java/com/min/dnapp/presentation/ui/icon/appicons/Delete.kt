package com.min.dnapp.presentation.ui.icon.appicons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
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

public val AppIcons.Delete: ImageVector
    get() {
        if (_delete != null) {
            return _delete!!
        }
        _delete = Builder(name = "Delete", defaultWidth = 18.0.dp, defaultHeight = 18.0.dp,
                viewportWidth = 18.0f, viewportHeight = 18.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(9.0f, 0.0f)
                curveTo(13.971f, 0.0f, 18.0f, 4.029f, 18.0f, 9.0f)
                curveTo(18.0f, 13.971f, 13.971f, 18.0f, 9.0f, 18.0f)
                curveTo(4.029f, 18.0f, 0.0f, 13.971f, 0.0f, 9.0f)
                curveTo(0.0f, 4.029f, 4.029f, 0.0f, 9.0f, 0.0f)
                close()
                moveTo(9.0f, 8.293f)
                lineTo(6.0f, 5.293f)
                lineTo(5.293f, 6.0f)
                lineTo(8.293f, 9.0f)
                lineTo(5.293f, 12.0f)
                lineTo(6.0f, 12.707f)
                lineTo(9.0f, 9.707f)
                lineTo(12.0f, 12.707f)
                lineTo(12.707f, 12.0f)
                lineTo(9.707f, 9.0f)
                lineTo(12.707f, 6.0f)
                lineTo(12.0f, 5.293f)
                lineTo(9.0f, 8.293f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(9.0f, 0.0f)
                curveTo(13.971f, 0.0f, 18.0f, 4.029f, 18.0f, 9.0f)
                curveTo(18.0f, 13.971f, 13.971f, 18.0f, 9.0f, 18.0f)
                curveTo(4.029f, 18.0f, 0.0f, 13.971f, 0.0f, 9.0f)
                curveTo(0.0f, 4.029f, 4.029f, 0.0f, 9.0f, 0.0f)
                close()
                moveTo(9.0f, 8.293f)
                lineTo(6.0f, 5.293f)
                lineTo(5.293f, 6.0f)
                lineTo(8.293f, 9.0f)
                lineTo(5.293f, 12.0f)
                lineTo(6.0f, 12.707f)
                lineTo(9.0f, 9.707f)
                lineTo(12.0f, 12.707f)
                lineTo(12.707f, 12.0f)
                lineTo(9.707f, 9.0f)
                lineTo(12.707f, 6.0f)
                lineTo(12.0f, 5.293f)
                lineTo(9.0f, 8.293f)
                close()
            }
        }
        .build()
        return _delete!!
    }

private var _delete: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Delete, contentDescription = "")
    }
}
