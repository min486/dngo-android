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

public val AppIcons.DeleteLine: ImageVector
    get() {
        if (_deleteLine != null) {
            return _deleteLine!!
        }
        _deleteLine = Builder(name = "DeleteLine", defaultWidth = 16.0.dp, defaultHeight = 16.0.dp,
                viewportWidth = 16.0f, viewportHeight = 16.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(11.764f, 3.764f)
                curveTo(11.895f, 3.634f, 12.106f, 3.634f, 12.236f, 3.764f)
                curveTo(12.366f, 3.894f, 12.366f, 4.105f, 12.236f, 4.235f)
                lineTo(8.471f, 8.0f)
                lineTo(12.236f, 11.764f)
                curveTo(12.366f, 11.894f, 12.366f, 12.105f, 12.236f, 12.236f)
                curveTo(12.106f, 12.366f, 11.895f, 12.366f, 11.764f, 12.236f)
                lineTo(8.0f, 8.471f)
                lineTo(4.236f, 12.236f)
                curveTo(4.106f, 12.366f, 3.895f, 12.366f, 3.764f, 12.236f)
                curveTo(3.634f, 12.105f, 3.634f, 11.894f, 3.764f, 11.764f)
                lineTo(7.529f, 8.0f)
                lineTo(3.764f, 4.235f)
                curveTo(3.634f, 4.105f, 3.634f, 3.894f, 3.764f, 3.764f)
                curveTo(3.895f, 3.634f, 4.106f, 3.634f, 4.236f, 3.764f)
                lineTo(8.0f, 7.528f)
                lineTo(11.764f, 3.764f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.764f, 3.764f)
                curveTo(11.895f, 3.634f, 12.106f, 3.634f, 12.236f, 3.764f)
                curveTo(12.366f, 3.894f, 12.366f, 4.105f, 12.236f, 4.235f)
                lineTo(8.471f, 8.0f)
                lineTo(12.236f, 11.764f)
                curveTo(12.366f, 11.894f, 12.366f, 12.105f, 12.236f, 12.236f)
                curveTo(12.106f, 12.366f, 11.895f, 12.366f, 11.764f, 12.236f)
                lineTo(8.0f, 8.471f)
                lineTo(4.236f, 12.236f)
                curveTo(4.106f, 12.366f, 3.895f, 12.366f, 3.764f, 12.236f)
                curveTo(3.634f, 12.105f, 3.634f, 11.894f, 3.764f, 11.764f)
                lineTo(7.529f, 8.0f)
                lineTo(3.764f, 4.235f)
                curveTo(3.634f, 4.105f, 3.634f, 3.894f, 3.764f, 3.764f)
                curveTo(3.895f, 3.634f, 4.106f, 3.634f, 4.236f, 3.764f)
                lineTo(8.0f, 7.528f)
                lineTo(11.764f, 3.764f)
                close()
            }
        }
        .build()
        return _deleteLine!!
    }

private var _deleteLine: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.DeleteLine, contentDescription = "")
    }
}
