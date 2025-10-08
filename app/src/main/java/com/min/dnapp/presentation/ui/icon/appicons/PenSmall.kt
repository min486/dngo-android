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

public val AppIcons.PenSmall: ImageVector
    get() {
        if (_penSmall != null) {
            return _penSmall!!
        }
        _penSmall = Builder(name = "PenSmall", defaultWidth = 10.0.dp, defaultHeight = 11.0.dp,
                viewportWidth = 10.0f, viewportHeight = 11.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(9.021f, 2.772f)
                curveTo(9.021f, 2.635f, 8.965f, 2.51f, 8.853f, 2.364f)
                curveTo(8.745f, 2.223f, 8.584f, 2.06f, 8.37f, 1.845f)
                lineTo(8.353f, 1.83f)
                lineTo(8.223f, 1.7f)
                curveTo(8.009f, 1.486f, 7.847f, 1.324f, 7.706f, 1.216f)
                lineTo(7.599f, 1.143f)
                curveTo(7.496f, 1.08f, 7.4f, 1.049f, 7.297f, 1.048f)
                curveTo(7.159f, 1.048f, 7.034f, 1.104f, 6.889f, 1.215f)
                curveTo(6.747f, 1.323f, 6.584f, 1.485f, 6.37f, 1.7f)
                lineTo(1.554f, 6.515f)
                lineTo(1.532f, 6.537f)
                curveTo(1.419f, 6.65f, 1.359f, 6.713f, 1.319f, 6.784f)
                lineTo(1.318f, 6.785f)
                curveTo(1.277f, 6.858f, 1.255f, 6.942f, 1.215f, 7.101f)
                lineTo(1.207f, 7.131f)
                lineTo(0.758f, 8.924f)
                curveTo(0.736f, 9.009f, 0.717f, 9.096f, 0.704f, 9.183f)
                curveTo(0.702f, 9.214f, 0.703f, 9.242f, 0.708f, 9.267f)
                curveTo(0.713f, 9.29f, 0.723f, 9.31f, 0.741f, 9.328f)
                curveTo(0.76f, 9.347f, 0.779f, 9.356f, 0.801f, 9.361f)
                curveTo(0.826f, 9.367f, 0.854f, 9.367f, 0.885f, 9.364f)
                curveTo(0.978f, 9.351f, 1.069f, 9.332f, 1.159f, 9.307f)
                lineTo(1.172f, 9.303f)
                lineTo(2.938f, 8.862f)
                lineTo(2.947f, 8.86f)
                lineTo(2.967f, 8.855f)
                curveTo(3.125f, 8.815f, 3.211f, 8.792f, 3.284f, 8.751f)
                curveTo(3.357f, 8.709f, 3.422f, 8.648f, 3.536f, 8.534f)
                lineTo(3.557f, 8.511f)
                lineTo(8.353f, 3.715f)
                lineTo(8.37f, 3.7f)
                curveTo(8.584f, 3.485f, 8.745f, 3.322f, 8.853f, 3.181f)
                curveTo(8.965f, 3.034f, 9.021f, 2.91f, 9.021f, 2.772f)
                close()
                moveTo(9.687f, 2.772f)
                curveTo(9.687f, 3.115f, 9.539f, 3.381f, 9.384f, 3.585f)
                lineTo(9.383f, 3.586f)
                curveTo(9.242f, 3.771f, 9.044f, 3.968f, 8.841f, 4.171f)
                lineTo(4.007f, 9.005f)
                curveTo(3.905f, 9.107f, 3.779f, 9.236f, 3.614f, 9.33f)
                curveTo(3.448f, 9.425f, 3.269f, 9.467f, 3.13f, 9.502f)
                lineTo(3.122f, 9.504f)
                lineTo(3.1f, 9.508f)
                lineTo(1.355f, 9.944f)
                lineTo(1.342f, 9.948f)
                curveTo(1.218f, 9.983f, 1.092f, 10.009f, 0.965f, 10.026f)
                lineTo(0.956f, 10.027f)
                curveTo(0.819f, 10.041f, 0.516f, 10.047f, 0.269f, 9.799f)
                curveTo(0.023f, 9.553f, 0.028f, 9.251f, 0.042f, 9.114f)
                lineTo(0.042f, 9.106f)
                lineTo(0.044f, 9.099f)
                curveTo(0.06f, 8.982f, 0.084f, 8.865f, 0.115f, 8.751f)
                lineTo(0.561f, 6.969f)
                lineTo(0.568f, 6.94f)
                curveTo(0.603f, 6.8f, 0.644f, 6.623f, 0.738f, 6.456f)
                curveTo(0.832f, 6.29f, 0.964f, 6.163f, 1.064f, 6.062f)
                lineTo(1.068f, 6.058f)
                lineTo(1.086f, 6.04f)
                lineTo(5.882f, 1.244f)
                lineTo(5.898f, 1.228f)
                curveTo(6.101f, 1.025f, 6.299f, 0.826f, 6.484f, 0.685f)
                curveTo(6.689f, 0.529f, 6.955f, 0.382f, 7.297f, 0.382f)
                curveTo(7.597f, 0.382f, 7.838f, 0.496f, 8.03f, 0.628f)
                lineTo(8.109f, 0.685f)
                lineTo(8.251f, 0.801f)
                curveTo(8.394f, 0.926f, 8.542f, 1.076f, 8.695f, 1.228f)
                lineTo(8.711f, 1.244f)
                lineTo(8.825f, 1.358f)
                lineTo(8.841f, 1.374f)
                curveTo(9.044f, 1.577f, 9.242f, 1.774f, 9.383f, 1.959f)
                lineTo(9.441f, 2.039f)
                curveTo(9.574f, 2.232f, 9.687f, 2.473f, 9.687f, 2.772f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(9.021f, 2.772f)
                curveTo(9.021f, 2.635f, 8.965f, 2.51f, 8.853f, 2.364f)
                curveTo(8.745f, 2.223f, 8.584f, 2.06f, 8.37f, 1.845f)
                lineTo(8.353f, 1.83f)
                lineTo(8.223f, 1.7f)
                curveTo(8.009f, 1.486f, 7.847f, 1.324f, 7.706f, 1.216f)
                lineTo(7.599f, 1.143f)
                curveTo(7.496f, 1.08f, 7.4f, 1.049f, 7.297f, 1.048f)
                curveTo(7.159f, 1.048f, 7.034f, 1.104f, 6.889f, 1.215f)
                curveTo(6.747f, 1.323f, 6.584f, 1.485f, 6.37f, 1.7f)
                lineTo(1.554f, 6.515f)
                lineTo(1.532f, 6.537f)
                curveTo(1.419f, 6.65f, 1.359f, 6.713f, 1.319f, 6.784f)
                lineTo(1.318f, 6.785f)
                curveTo(1.277f, 6.858f, 1.255f, 6.942f, 1.215f, 7.101f)
                lineTo(1.207f, 7.131f)
                lineTo(0.758f, 8.924f)
                curveTo(0.736f, 9.009f, 0.717f, 9.096f, 0.704f, 9.183f)
                curveTo(0.702f, 9.214f, 0.703f, 9.242f, 0.708f, 9.267f)
                curveTo(0.713f, 9.29f, 0.723f, 9.31f, 0.741f, 9.328f)
                curveTo(0.76f, 9.347f, 0.779f, 9.356f, 0.801f, 9.361f)
                curveTo(0.826f, 9.367f, 0.854f, 9.367f, 0.885f, 9.364f)
                curveTo(0.978f, 9.351f, 1.069f, 9.332f, 1.159f, 9.307f)
                lineTo(1.172f, 9.303f)
                lineTo(2.938f, 8.862f)
                lineTo(2.947f, 8.86f)
                lineTo(2.967f, 8.855f)
                curveTo(3.125f, 8.815f, 3.211f, 8.792f, 3.284f, 8.751f)
                curveTo(3.357f, 8.709f, 3.422f, 8.648f, 3.536f, 8.534f)
                lineTo(3.557f, 8.511f)
                lineTo(8.353f, 3.715f)
                lineTo(8.37f, 3.7f)
                curveTo(8.584f, 3.485f, 8.745f, 3.322f, 8.853f, 3.181f)
                curveTo(8.965f, 3.034f, 9.021f, 2.91f, 9.021f, 2.772f)
                close()
                moveTo(9.687f, 2.772f)
                curveTo(9.687f, 3.115f, 9.539f, 3.381f, 9.384f, 3.585f)
                lineTo(9.383f, 3.586f)
                curveTo(9.242f, 3.771f, 9.044f, 3.968f, 8.841f, 4.171f)
                lineTo(4.007f, 9.005f)
                curveTo(3.905f, 9.107f, 3.779f, 9.236f, 3.614f, 9.33f)
                curveTo(3.448f, 9.425f, 3.269f, 9.467f, 3.13f, 9.502f)
                lineTo(3.122f, 9.504f)
                lineTo(3.1f, 9.508f)
                lineTo(1.355f, 9.944f)
                lineTo(1.342f, 9.948f)
                curveTo(1.218f, 9.983f, 1.092f, 10.009f, 0.965f, 10.026f)
                lineTo(0.956f, 10.027f)
                curveTo(0.819f, 10.041f, 0.516f, 10.047f, 0.269f, 9.799f)
                curveTo(0.023f, 9.553f, 0.028f, 9.251f, 0.042f, 9.114f)
                lineTo(0.042f, 9.106f)
                lineTo(0.044f, 9.099f)
                curveTo(0.06f, 8.982f, 0.084f, 8.865f, 0.115f, 8.751f)
                lineTo(0.561f, 6.969f)
                lineTo(0.568f, 6.94f)
                curveTo(0.603f, 6.8f, 0.644f, 6.623f, 0.738f, 6.456f)
                curveTo(0.832f, 6.29f, 0.964f, 6.163f, 1.064f, 6.062f)
                lineTo(1.068f, 6.058f)
                lineTo(1.086f, 6.04f)
                lineTo(5.882f, 1.244f)
                lineTo(5.898f, 1.228f)
                curveTo(6.101f, 1.025f, 6.299f, 0.826f, 6.484f, 0.685f)
                curveTo(6.689f, 0.529f, 6.955f, 0.382f, 7.297f, 0.382f)
                curveTo(7.597f, 0.382f, 7.838f, 0.496f, 8.03f, 0.628f)
                lineTo(8.109f, 0.685f)
                lineTo(8.251f, 0.801f)
                curveTo(8.394f, 0.926f, 8.542f, 1.076f, 8.695f, 1.228f)
                lineTo(8.711f, 1.244f)
                lineTo(8.825f, 1.358f)
                lineTo(8.841f, 1.374f)
                curveTo(9.044f, 1.577f, 9.242f, 1.774f, 9.383f, 1.959f)
                lineTo(9.441f, 2.039f)
                curveTo(9.574f, 2.232f, 9.687f, 2.473f, 9.687f, 2.772f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(5.63f, 1.773f)
                lineTo(7.63f, 0.439f)
                lineTo(9.63f, 2.439f)
                lineTo(8.297f, 4.439f)
                lineTo(5.63f, 1.773f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.63f, 1.773f)
                lineTo(7.63f, 0.439f)
                lineTo(9.63f, 2.439f)
                lineTo(8.297f, 4.439f)
                lineTo(5.63f, 1.773f)
                close()
            }
        }
        .build()
        return _penSmall!!
    }

private var _penSmall: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.PenSmall, contentDescription = "")
    }
}
