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

public val AppIcons.Year: ImageVector
    get() {
        if (_year != null) {
            return _year!!
        }
        _year = Builder(name = "Year", defaultWidth = 15.0.dp, defaultHeight = 18.0.dp,
                viewportWidth = 15.0f, viewportHeight = 18.0f).apply {
            path(fill = SolidColor(Color(0xFFA56C48)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.983f, 7.833f)
                curveTo(12.983f, 7.465f, 12.685f, 7.167f, 12.317f, 7.167f)
                horizontalLineTo(2.983f)
                curveTo(2.615f, 7.167f, 2.317f, 7.465f, 2.317f, 7.833f)
                verticalLineTo(15.167f)
                curveTo(2.317f, 15.535f, 2.615f, 15.833f, 2.983f, 15.833f)
                horizontalLineTo(12.317f)
                curveTo(12.685f, 15.833f, 12.983f, 15.535f, 12.983f, 15.167f)
                verticalLineTo(7.833f)
                close()
                moveTo(14.317f, 15.167f)
                curveTo(14.317f, 16.271f, 13.421f, 17.167f, 12.317f, 17.167f)
                horizontalLineTo(2.983f)
                curveTo(1.879f, 17.167f, 0.983f, 16.271f, 0.983f, 15.167f)
                verticalLineTo(7.833f)
                curveTo(0.983f, 6.729f, 1.879f, 5.833f, 2.983f, 5.833f)
                horizontalLineTo(12.317f)
                curveTo(13.421f, 5.833f, 14.317f, 6.729f, 14.317f, 7.833f)
                verticalLineTo(15.167f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA56C48)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.65f, 7.333f)
                curveTo(1.65f, 6.076f, 1.65f, 5.448f, 2.041f, 5.057f)
                curveTo(2.431f, 4.667f, 3.059f, 4.667f, 4.317f, 4.667f)
                horizontalLineTo(10.983f)
                curveTo(12.241f, 4.667f, 12.869f, 4.667f, 13.259f, 5.057f)
                curveTo(13.65f, 5.448f, 13.65f, 6.076f, 13.65f, 7.333f)
                horizontalLineTo(1.65f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA56C48)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.65f, 3.5f)
                verticalLineTo(1.5f)
                curveTo(3.65f, 1.132f, 3.948f, 0.833f, 4.317f, 0.833f)
                curveTo(4.685f, 0.833f, 4.983f, 1.132f, 4.983f, 1.5f)
                verticalLineTo(3.5f)
                curveTo(4.983f, 3.868f, 4.685f, 4.167f, 4.317f, 4.167f)
                curveTo(3.948f, 4.167f, 3.65f, 3.868f, 3.65f, 3.5f)
                close()
                moveTo(10.317f, 3.5f)
                verticalLineTo(1.5f)
                curveTo(10.317f, 1.132f, 10.615f, 0.833f, 10.983f, 0.833f)
                curveTo(11.351f, 0.833f, 11.65f, 1.132f, 11.65f, 1.5f)
                verticalLineTo(3.5f)
                curveTo(11.65f, 3.868f, 11.351f, 4.167f, 10.983f, 4.167f)
                curveTo(10.615f, 4.167f, 10.317f, 3.868f, 10.317f, 3.5f)
                close()
            }
        }
        .build()
        return _year!!
    }

private var _year: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Year, contentDescription = "")
    }
}
