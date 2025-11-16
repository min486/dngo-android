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

public val AppIcons.Bell: ImageVector
    get() {
        if (_bell != null) {
            return _bell!!
        }
        _bell = Builder(name = "Bell", defaultWidth = 16.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 16.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.546f, 16.734f)
                curveTo(10.812f, 16.806f, 10.971f, 17.083f, 10.899f, 17.352f)
                curveTo(10.729f, 17.997f, 10.352f, 18.567f, 9.828f, 18.974f)
                curveTo(9.304f, 19.38f, 8.661f, 19.6f, 8.001f, 19.6f)
                curveTo(7.341f, 19.6f, 6.699f, 19.38f, 6.175f, 18.974f)
                curveTo(5.651f, 18.567f, 5.274f, 17.997f, 5.103f, 17.352f)
                curveTo(5.032f, 17.083f, 5.19f, 16.806f, 5.457f, 16.734f)
                curveTo(5.724f, 16.662f, 5.998f, 16.821f, 6.069f, 17.091f)
                curveTo(6.183f, 17.521f, 6.434f, 17.9f, 6.783f, 18.171f)
                curveTo(7.132f, 18.442f, 7.561f, 18.59f, 8.001f, 18.59f)
                curveTo(8.441f, 18.59f, 8.869f, 18.442f, 9.219f, 18.171f)
                curveTo(9.568f, 17.9f, 9.82f, 17.521f, 9.934f, 17.091f)
                curveTo(10.005f, 16.821f, 10.279f, 16.661f, 10.546f, 16.734f)
                close()
                moveTo(13.001f, 6.463f)
                curveTo(13.001f, 5.123f, 12.474f, 3.838f, 11.537f, 2.891f)
                curveTo(10.599f, 1.943f, 9.327f, 1.41f, 8.001f, 1.41f)
                curveTo(6.675f, 1.41f, 5.403f, 1.943f, 4.466f, 2.891f)
                curveTo(3.528f, 3.838f, 3.001f, 5.123f, 3.001f, 6.463f)
                verticalLineTo(8.484f)
                curveTo(3.001f, 10.233f, 2.44f, 11.935f, 1.401f, 13.334f)
                lineTo(1.4f, 13.335f)
                lineTo(1.188f, 13.617f)
                curveTo(1.15f, 13.67f, 1.127f, 13.704f, 1.106f, 13.733f)
                curveTo(1.097f, 13.746f, 1.09f, 13.755f, 1.085f, 13.762f)
                curveTo(1.081f, 13.769f, 1.078f, 13.772f, 1.078f, 13.772f)
                lineTo(1.077f, 13.771f)
                curveTo(1.031f, 13.844f, 1.006f, 13.929f, 1.002f, 14.016f)
                curveTo(0.998f, 14.103f, 1.015f, 14.19f, 1.054f, 14.267f)
                curveTo(1.092f, 14.345f, 1.15f, 14.412f, 1.222f, 14.461f)
                curveTo(1.293f, 14.509f, 1.375f, 14.538f, 1.46f, 14.545f)
                curveTo(1.46f, 14.545f, 1.461f, 14.546f, 1.463f, 14.546f)
                curveTo(1.465f, 14.546f, 1.469f, 14.546f, 1.473f, 14.546f)
                curveTo(1.481f, 14.546f, 1.492f, 14.547f, 1.508f, 14.547f)
                horizontalLineTo(14.493f)
                curveTo(14.518f, 14.546f, 14.528f, 14.545f, 14.53f, 14.545f)
                lineTo(14.54f, 14.544f)
                curveTo(14.625f, 14.537f, 14.708f, 14.509f, 14.779f, 14.46f)
                curveTo(14.851f, 14.411f, 14.908f, 14.344f, 14.946f, 14.267f)
                curveTo(14.985f, 14.189f, 15.003f, 14.103f, 14.999f, 14.016f)
                curveTo(14.995f, 13.931f, 14.968f, 13.848f, 14.924f, 13.775f)
                curveTo(14.89f, 13.725f, 14.855f, 13.675f, 14.818f, 13.627f)
                lineTo(14.814f, 13.623f)
                lineTo(14.601f, 13.334f)
                verticalLineTo(13.333f)
                curveTo(13.563f, 11.934f, 13.001f, 10.233f, 13.001f, 8.484f)
                verticalLineTo(6.463f)
                close()
                moveTo(14.001f, 8.484f)
                curveTo(14.001f, 9.919f, 14.433f, 11.317f, 15.235f, 12.495f)
                lineTo(15.401f, 12.728f)
                lineTo(15.612f, 13.013f)
                lineTo(15.759f, 13.218f)
                lineTo(15.764f, 13.226f)
                lineTo(15.769f, 13.232f)
                curveTo(15.906f, 13.453f, 15.984f, 13.705f, 15.997f, 13.966f)
                curveTo(16.01f, 14.226f, 15.956f, 14.485f, 15.841f, 14.719f)
                curveTo(15.725f, 14.952f, 15.553f, 15.151f, 15.339f, 15.297f)
                curveTo(15.127f, 15.441f, 14.883f, 15.527f, 14.629f, 15.549f)
                lineTo(14.63f, 15.55f)
                horizontalLineTo(14.627f)
                curveTo(14.625f, 15.55f, 14.623f, 15.551f, 14.621f, 15.551f)
                lineTo(14.62f, 15.55f)
                curveTo(14.55f, 15.557f, 14.46f, 15.557f, 14.358f, 15.557f)
                horizontalLineTo(1.644f)
                curveTo(1.535f, 15.557f, 1.447f, 15.557f, 1.384f, 15.552f)
                horizontalLineTo(1.383f)
                curveTo(1.125f, 15.532f, 0.877f, 15.445f, 0.663f, 15.299f)
                curveTo(0.449f, 15.153f, 0.275f, 14.953f, 0.159f, 14.719f)
                curveTo(0.044f, 14.486f, -0.01f, 14.226f, 0.003f, 13.966f)
                curveTo(0.016f, 13.705f, 0.095f, 13.451f, 0.233f, 13.23f)
                lineTo(0.234f, 13.229f)
                curveTo(0.267f, 13.177f, 0.321f, 13.104f, 0.383f, 13.02f)
                lineTo(0.387f, 13.014f)
                lineTo(0.602f, 12.727f)
                curveTo(1.51f, 11.503f, 2.001f, 10.014f, 2.001f, 8.484f)
                verticalLineTo(6.463f)
                curveTo(2.001f, 4.855f, 2.634f, 3.313f, 3.759f, 2.176f)
                curveTo(4.884f, 1.039f, 6.41f, 0.4f, 8.001f, 0.4f)
                curveTo(9.592f, 0.4f, 11.119f, 1.039f, 12.244f, 2.176f)
                curveTo(13.369f, 3.313f, 14.001f, 4.855f, 14.001f, 6.463f)
                verticalLineTo(8.484f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.546f, 16.734f)
                curveTo(10.812f, 16.806f, 10.971f, 17.083f, 10.899f, 17.352f)
                curveTo(10.729f, 17.997f, 10.352f, 18.567f, 9.828f, 18.974f)
                curveTo(9.304f, 19.38f, 8.661f, 19.6f, 8.001f, 19.6f)
                curveTo(7.341f, 19.6f, 6.699f, 19.38f, 6.175f, 18.974f)
                curveTo(5.651f, 18.567f, 5.274f, 17.997f, 5.103f, 17.352f)
                curveTo(5.032f, 17.083f, 5.19f, 16.806f, 5.457f, 16.734f)
                curveTo(5.724f, 16.662f, 5.998f, 16.821f, 6.069f, 17.091f)
                curveTo(6.183f, 17.521f, 6.434f, 17.9f, 6.783f, 18.171f)
                curveTo(7.132f, 18.442f, 7.561f, 18.59f, 8.001f, 18.59f)
                curveTo(8.441f, 18.59f, 8.869f, 18.442f, 9.219f, 18.171f)
                curveTo(9.568f, 17.9f, 9.82f, 17.521f, 9.934f, 17.091f)
                curveTo(10.005f, 16.821f, 10.279f, 16.661f, 10.546f, 16.734f)
                close()
                moveTo(13.001f, 6.463f)
                curveTo(13.001f, 5.123f, 12.474f, 3.838f, 11.537f, 2.891f)
                curveTo(10.599f, 1.943f, 9.327f, 1.41f, 8.001f, 1.41f)
                curveTo(6.675f, 1.41f, 5.403f, 1.943f, 4.466f, 2.891f)
                curveTo(3.528f, 3.838f, 3.001f, 5.123f, 3.001f, 6.463f)
                verticalLineTo(8.484f)
                curveTo(3.001f, 10.233f, 2.44f, 11.935f, 1.401f, 13.334f)
                lineTo(1.4f, 13.335f)
                lineTo(1.188f, 13.617f)
                curveTo(1.15f, 13.67f, 1.127f, 13.704f, 1.106f, 13.733f)
                curveTo(1.097f, 13.746f, 1.09f, 13.755f, 1.085f, 13.762f)
                curveTo(1.081f, 13.769f, 1.078f, 13.772f, 1.078f, 13.772f)
                lineTo(1.077f, 13.771f)
                curveTo(1.031f, 13.844f, 1.006f, 13.929f, 1.002f, 14.016f)
                curveTo(0.998f, 14.103f, 1.015f, 14.19f, 1.054f, 14.267f)
                curveTo(1.092f, 14.345f, 1.15f, 14.412f, 1.222f, 14.461f)
                curveTo(1.293f, 14.509f, 1.375f, 14.538f, 1.46f, 14.545f)
                curveTo(1.46f, 14.545f, 1.461f, 14.546f, 1.463f, 14.546f)
                curveTo(1.465f, 14.546f, 1.469f, 14.546f, 1.473f, 14.546f)
                curveTo(1.481f, 14.546f, 1.492f, 14.547f, 1.508f, 14.547f)
                horizontalLineTo(14.493f)
                curveTo(14.518f, 14.546f, 14.528f, 14.545f, 14.53f, 14.545f)
                lineTo(14.54f, 14.544f)
                curveTo(14.625f, 14.537f, 14.708f, 14.509f, 14.779f, 14.46f)
                curveTo(14.851f, 14.411f, 14.908f, 14.344f, 14.946f, 14.267f)
                curveTo(14.985f, 14.189f, 15.003f, 14.103f, 14.999f, 14.016f)
                curveTo(14.995f, 13.931f, 14.968f, 13.848f, 14.924f, 13.775f)
                curveTo(14.89f, 13.725f, 14.855f, 13.675f, 14.818f, 13.627f)
                lineTo(14.814f, 13.623f)
                lineTo(14.601f, 13.334f)
                verticalLineTo(13.333f)
                curveTo(13.563f, 11.934f, 13.001f, 10.233f, 13.001f, 8.484f)
                verticalLineTo(6.463f)
                close()
                moveTo(14.001f, 8.484f)
                curveTo(14.001f, 9.919f, 14.433f, 11.317f, 15.235f, 12.495f)
                lineTo(15.401f, 12.728f)
                lineTo(15.612f, 13.013f)
                lineTo(15.759f, 13.218f)
                lineTo(15.764f, 13.226f)
                lineTo(15.769f, 13.232f)
                curveTo(15.906f, 13.453f, 15.984f, 13.705f, 15.997f, 13.966f)
                curveTo(16.01f, 14.226f, 15.956f, 14.485f, 15.841f, 14.719f)
                curveTo(15.725f, 14.952f, 15.553f, 15.151f, 15.339f, 15.297f)
                curveTo(15.127f, 15.441f, 14.883f, 15.527f, 14.629f, 15.549f)
                lineTo(14.63f, 15.55f)
                horizontalLineTo(14.627f)
                curveTo(14.625f, 15.55f, 14.623f, 15.551f, 14.621f, 15.551f)
                lineTo(14.62f, 15.55f)
                curveTo(14.55f, 15.557f, 14.46f, 15.557f, 14.358f, 15.557f)
                horizontalLineTo(1.644f)
                curveTo(1.535f, 15.557f, 1.447f, 15.557f, 1.384f, 15.552f)
                horizontalLineTo(1.383f)
                curveTo(1.125f, 15.532f, 0.877f, 15.445f, 0.663f, 15.299f)
                curveTo(0.449f, 15.153f, 0.275f, 14.953f, 0.159f, 14.719f)
                curveTo(0.044f, 14.486f, -0.01f, 14.226f, 0.003f, 13.966f)
                curveTo(0.016f, 13.705f, 0.095f, 13.451f, 0.233f, 13.23f)
                lineTo(0.234f, 13.229f)
                curveTo(0.267f, 13.177f, 0.321f, 13.104f, 0.383f, 13.02f)
                lineTo(0.387f, 13.014f)
                lineTo(0.602f, 12.727f)
                curveTo(1.51f, 11.503f, 2.001f, 10.014f, 2.001f, 8.484f)
                verticalLineTo(6.463f)
                curveTo(2.001f, 4.855f, 2.634f, 3.313f, 3.759f, 2.176f)
                curveTo(4.884f, 1.039f, 6.41f, 0.4f, 8.001f, 0.4f)
                curveTo(9.592f, 0.4f, 11.119f, 1.039f, 12.244f, 2.176f)
                curveTo(13.369f, 3.313f, 14.001f, 4.855f, 14.001f, 6.463f)
                verticalLineTo(8.484f)
                close()
            }
        }
        .build()
        return _bell!!
    }

private var _bell: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Bell, contentDescription = "")
    }
}
