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

public val AppIcons.Calendar: ImageVector
    get() {
        if (_calendar != null) {
            return _calendar!!
        }
        _calendar = Builder(name = "Calendar", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFA56C48)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.0f, 6.0f)
                curveTo(18.0f, 5.448f, 17.552f, 5.0f, 17.0f, 5.0f)
                horizontalLineTo(3.0f)
                curveTo(2.448f, 5.0f, 2.0f, 5.448f, 2.0f, 6.0f)
                verticalLineTo(17.0f)
                curveTo(2.0f, 17.552f, 2.448f, 18.0f, 3.0f, 18.0f)
                horizontalLineTo(17.0f)
                curveTo(17.552f, 18.0f, 18.0f, 17.552f, 18.0f, 17.0f)
                verticalLineTo(6.0f)
                close()
                moveTo(20.0f, 17.0f)
                curveTo(20.0f, 18.657f, 18.657f, 20.0f, 17.0f, 20.0f)
                horizontalLineTo(3.0f)
                curveTo(1.343f, 20.0f, 0.0f, 18.657f, 0.0f, 17.0f)
                verticalLineTo(6.0f)
                curveTo(0.0f, 4.343f, 1.343f, 3.0f, 3.0f, 3.0f)
                horizontalLineTo(17.0f)
                curveTo(18.657f, 3.0f, 20.0f, 4.343f, 20.0f, 6.0f)
                verticalLineTo(17.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA56C48)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.0f, 8.0f)
                curveTo(1.0f, 6.114f, 1.0f, 5.172f, 1.586f, 4.586f)
                curveTo(2.172f, 4.0f, 3.114f, 4.0f, 5.0f, 4.0f)
                horizontalLineTo(15.0f)
                curveTo(16.886f, 4.0f, 17.828f, 4.0f, 18.414f, 4.586f)
                curveTo(19.0f, 5.172f, 19.0f, 6.114f, 19.0f, 8.0f)
                horizontalLineTo(1.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA56C48)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.0f, 4.0f)
                verticalLineTo(1.0f)
                curveTo(4.0f, 0.448f, 4.448f, 0.0f, 5.0f, 0.0f)
                curveTo(5.552f, 0.0f, 6.0f, 0.448f, 6.0f, 1.0f)
                verticalLineTo(4.0f)
                curveTo(6.0f, 4.552f, 5.552f, 5.0f, 5.0f, 5.0f)
                curveTo(4.448f, 5.0f, 4.0f, 4.552f, 4.0f, 4.0f)
                close()
                moveTo(14.0f, 4.0f)
                verticalLineTo(1.0f)
                curveTo(14.0f, 0.448f, 14.448f, 0.0f, 15.0f, 0.0f)
                curveTo(15.552f, 0.0f, 16.0f, 0.448f, 16.0f, 1.0f)
                verticalLineTo(4.0f)
                curveTo(16.0f, 4.552f, 15.552f, 5.0f, 15.0f, 5.0f)
                curveTo(14.448f, 5.0f, 14.0f, 4.552f, 14.0f, 4.0f)
                close()
            }
        }
        .build()
        return _calendar!!
    }

private var _calendar: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Calendar, contentDescription = "")
    }
}
