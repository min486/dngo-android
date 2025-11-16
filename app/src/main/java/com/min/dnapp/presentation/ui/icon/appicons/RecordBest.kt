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

public val AppIcons.RecordBest: ImageVector
    get() {
        if (_recordBest != null) {
            return _recordBest!!
        }
        _recordBest = Builder(name = "RecordBest", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(13.661f, 17.5f)
                horizontalLineTo(4.128f)
                curveTo(3.702f, 17.499f, 3.293f, 17.33f, 2.992f, 17.029f)
                curveTo(2.69f, 16.728f, 2.521f, 16.319f, 2.52f, 15.893f)
                verticalLineTo(10.536f)
                curveTo(2.52f, 9.65f, 3.241f, 8.929f, 4.127f, 8.929f)
                horizontalLineTo(6.0f)
                curveTo(6.959f, 7.607f, 7.728f, 6.157f, 8.283f, 4.621f)
                lineTo(8.78f, 3.242f)
                curveTo(8.9f, 2.819f, 9.324f, 2.5f, 9.799f, 2.5f)
                lineTo(9.935f, 2.504f)
                curveTo(10.605f, 2.541f, 11.227f, 2.856f, 11.656f, 3.379f)
                curveTo(11.853f, 3.619f, 12.001f, 3.894f, 12.093f, 4.19f)
                lineTo(12.129f, 4.319f)
                curveTo(12.215f, 4.663f, 12.223f, 5.022f, 12.153f, 5.37f)
                lineTo(11.656f, 7.856f)
                horizontalLineTo(15.336f)
                lineTo(15.465f, 7.861f)
                curveTo(16.101f, 7.898f, 16.68f, 8.209f, 17.061f, 8.73f)
                curveTo(17.237f, 8.966f, 17.361f, 9.236f, 17.427f, 9.521f)
                lineTo(17.451f, 9.645f)
                curveTo(17.507f, 9.977f, 17.483f, 10.317f, 17.381f, 10.638f)
                lineTo(15.708f, 15.995f)
                curveTo(15.443f, 16.839f, 14.705f, 17.423f, 13.837f, 17.493f)
                lineTo(13.661f, 17.5f)
                close()
                moveTo(13.664f, 16.428f)
                curveTo(13.892f, 16.428f, 14.115f, 16.355f, 14.298f, 16.22f)
                lineTo(14.365f, 16.166f)
                curveTo(14.515f, 16.036f, 14.626f, 15.867f, 14.686f, 15.676f)
                lineTo(16.36f, 10.319f)
                curveTo(16.41f, 10.159f, 16.421f, 9.988f, 16.394f, 9.823f)
                curveTo(16.366f, 9.657f, 16.3f, 9.5f, 16.201f, 9.364f)
                curveTo(16.102f, 9.228f, 15.972f, 9.117f, 15.822f, 9.041f)
                curveTo(15.672f, 8.965f, 15.506f, 8.926f, 15.337f, 8.927f)
                horizontalLineTo(11.003f)
                lineTo(10.944f, 8.923f)
                curveTo(10.885f, 8.917f, 10.827f, 8.901f, 10.774f, 8.875f)
                curveTo(10.702f, 8.841f, 10.638f, 8.793f, 10.588f, 8.731f)
                curveTo(10.538f, 8.67f, 10.502f, 8.598f, 10.482f, 8.521f)
                curveTo(10.463f, 8.444f, 10.461f, 8.364f, 10.477f, 8.286f)
                lineTo(11.102f, 5.16f)
                lineTo(11.124f, 5.014f)
                curveTo(11.137f, 4.868f, 11.126f, 4.72f, 11.09f, 4.577f)
                curveTo(11.043f, 4.386f, 10.953f, 4.207f, 10.828f, 4.055f)
                curveTo(10.703f, 3.903f, 10.546f, 3.781f, 10.368f, 3.697f)
                curveTo(10.19f, 3.613f, 9.996f, 3.57f, 9.799f, 3.57f)
                lineTo(9.292f, 4.983f)
                horizontalLineTo(9.296f)
                curveTo(8.695f, 6.646f, 7.858f, 8.215f, 6.81f, 9.639f)
                verticalLineTo(16.428f)
                horizontalLineTo(13.664f)
                close()
                moveTo(5.735f, 16.428f)
                verticalLineTo(9.999f)
                horizontalLineTo(4.128f)
                lineTo(4.023f, 10.01f)
                curveTo(3.954f, 10.024f, 3.889f, 10.051f, 3.831f, 10.09f)
                lineTo(3.75f, 10.156f)
                curveTo(3.649f, 10.257f, 3.592f, 10.393f, 3.592f, 10.535f)
                verticalLineTo(15.893f)
                curveTo(3.592f, 16.035f, 3.649f, 16.171f, 3.75f, 16.272f)
                curveTo(3.825f, 16.347f, 3.92f, 16.398f, 4.023f, 16.419f)
                lineTo(4.128f, 16.428f)
                horizontalLineTo(5.735f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.661f, 17.5f)
                horizontalLineTo(4.128f)
                curveTo(3.702f, 17.499f, 3.293f, 17.33f, 2.992f, 17.029f)
                curveTo(2.69f, 16.728f, 2.521f, 16.319f, 2.52f, 15.893f)
                verticalLineTo(10.536f)
                curveTo(2.52f, 9.65f, 3.241f, 8.929f, 4.127f, 8.929f)
                horizontalLineTo(6.0f)
                curveTo(6.959f, 7.607f, 7.728f, 6.157f, 8.283f, 4.621f)
                lineTo(8.78f, 3.242f)
                curveTo(8.9f, 2.819f, 9.324f, 2.5f, 9.799f, 2.5f)
                lineTo(9.935f, 2.504f)
                curveTo(10.605f, 2.541f, 11.227f, 2.856f, 11.656f, 3.379f)
                curveTo(11.853f, 3.619f, 12.001f, 3.894f, 12.093f, 4.19f)
                lineTo(12.129f, 4.319f)
                curveTo(12.215f, 4.663f, 12.223f, 5.022f, 12.153f, 5.37f)
                lineTo(11.656f, 7.856f)
                horizontalLineTo(15.336f)
                lineTo(15.465f, 7.861f)
                curveTo(16.101f, 7.898f, 16.68f, 8.209f, 17.061f, 8.73f)
                curveTo(17.237f, 8.966f, 17.361f, 9.236f, 17.427f, 9.521f)
                lineTo(17.451f, 9.645f)
                curveTo(17.507f, 9.977f, 17.483f, 10.317f, 17.381f, 10.638f)
                lineTo(15.708f, 15.995f)
                curveTo(15.443f, 16.839f, 14.705f, 17.423f, 13.837f, 17.493f)
                lineTo(13.661f, 17.5f)
                close()
                moveTo(13.664f, 16.428f)
                curveTo(13.892f, 16.428f, 14.115f, 16.355f, 14.298f, 16.22f)
                lineTo(14.365f, 16.166f)
                curveTo(14.515f, 16.036f, 14.626f, 15.867f, 14.686f, 15.676f)
                lineTo(16.36f, 10.319f)
                curveTo(16.41f, 10.159f, 16.421f, 9.988f, 16.394f, 9.823f)
                curveTo(16.366f, 9.657f, 16.3f, 9.5f, 16.201f, 9.364f)
                curveTo(16.102f, 9.228f, 15.972f, 9.117f, 15.822f, 9.041f)
                curveTo(15.672f, 8.965f, 15.506f, 8.926f, 15.337f, 8.927f)
                horizontalLineTo(11.003f)
                lineTo(10.944f, 8.923f)
                curveTo(10.885f, 8.917f, 10.827f, 8.901f, 10.774f, 8.875f)
                curveTo(10.702f, 8.841f, 10.638f, 8.793f, 10.588f, 8.731f)
                curveTo(10.538f, 8.67f, 10.502f, 8.598f, 10.482f, 8.521f)
                curveTo(10.463f, 8.444f, 10.461f, 8.364f, 10.477f, 8.286f)
                lineTo(11.102f, 5.16f)
                lineTo(11.124f, 5.014f)
                curveTo(11.137f, 4.868f, 11.126f, 4.72f, 11.09f, 4.577f)
                curveTo(11.043f, 4.386f, 10.953f, 4.207f, 10.828f, 4.055f)
                curveTo(10.703f, 3.903f, 10.546f, 3.781f, 10.368f, 3.697f)
                curveTo(10.19f, 3.613f, 9.996f, 3.57f, 9.799f, 3.57f)
                lineTo(9.292f, 4.983f)
                horizontalLineTo(9.296f)
                curveTo(8.695f, 6.646f, 7.858f, 8.215f, 6.81f, 9.639f)
                verticalLineTo(16.428f)
                horizontalLineTo(13.664f)
                close()
                moveTo(5.735f, 16.428f)
                verticalLineTo(9.999f)
                horizontalLineTo(4.128f)
                lineTo(4.023f, 10.01f)
                curveTo(3.954f, 10.024f, 3.889f, 10.051f, 3.831f, 10.09f)
                lineTo(3.75f, 10.156f)
                curveTo(3.649f, 10.257f, 3.592f, 10.393f, 3.592f, 10.535f)
                verticalLineTo(15.893f)
                curveTo(3.592f, 16.035f, 3.649f, 16.171f, 3.75f, 16.272f)
                curveTo(3.825f, 16.347f, 3.92f, 16.398f, 4.023f, 16.419f)
                lineTo(4.128f, 16.428f)
                horizontalLineTo(5.735f)
                close()
            }
        }
        .build()
        return _recordBest!!
    }

private var _recordBest: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.RecordBest, contentDescription = "")
    }
}
