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

public val AppIcons.More: ImageVector
    get() {
        if (_more != null) {
            return _more!!
        }
        _more = Builder(name = "More", defaultWidth = 21.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 21.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(5.11f, 10.0f)
                curveTo(5.11f, 10.506f, 4.7f, 10.917f, 4.193f, 10.917f)
                curveTo(3.687f, 10.917f, 3.277f, 10.506f, 3.277f, 10.0f)
                curveTo(3.277f, 9.494f, 3.687f, 9.083f, 4.193f, 9.083f)
                curveTo(4.7f, 9.083f, 5.11f, 9.494f, 5.11f, 10.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.11f, 10.0f)
                curveTo(5.11f, 10.506f, 4.7f, 10.917f, 4.193f, 10.917f)
                curveTo(3.687f, 10.917f, 3.277f, 10.506f, 3.277f, 10.0f)
                curveTo(3.277f, 9.494f, 3.687f, 9.083f, 4.193f, 9.083f)
                curveTo(4.7f, 9.083f, 5.11f, 9.494f, 5.11f, 10.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(11.693f, 10.0f)
                curveTo(11.693f, 10.506f, 11.283f, 10.917f, 10.777f, 10.917f)
                curveTo(10.27f, 10.917f, 9.86f, 10.506f, 9.86f, 10.0f)
                curveTo(9.86f, 9.494f, 10.27f, 9.083f, 10.777f, 9.083f)
                curveTo(11.283f, 9.083f, 11.693f, 9.494f, 11.693f, 10.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.693f, 10.0f)
                curveTo(11.693f, 10.506f, 11.283f, 10.917f, 10.777f, 10.917f)
                curveTo(10.27f, 10.917f, 9.86f, 10.506f, 9.86f, 10.0f)
                curveTo(9.86f, 9.494f, 10.27f, 9.083f, 10.777f, 9.083f)
                curveTo(11.283f, 9.083f, 11.693f, 9.494f, 11.693f, 10.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.277f, 10.0f)
                curveTo(18.277f, 10.506f, 17.866f, 10.917f, 17.36f, 10.917f)
                curveTo(16.854f, 10.917f, 16.443f, 10.506f, 16.443f, 10.0f)
                curveTo(16.443f, 9.494f, 16.854f, 9.083f, 17.36f, 9.083f)
                curveTo(17.866f, 9.083f, 18.277f, 9.494f, 18.277f, 10.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.2f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(18.277f, 10.0f)
                curveTo(18.277f, 10.506f, 17.866f, 10.917f, 17.36f, 10.917f)
                curveTo(16.854f, 10.917f, 16.443f, 10.506f, 16.443f, 10.0f)
                curveTo(16.443f, 9.494f, 16.854f, 9.083f, 17.36f, 9.083f)
                curveTo(17.866f, 9.083f, 18.277f, 9.494f, 18.277f, 10.0f)
                close()
            }
        }
        .build()
        return _more!!
    }

private var _more: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.More, contentDescription = "")
    }
}
