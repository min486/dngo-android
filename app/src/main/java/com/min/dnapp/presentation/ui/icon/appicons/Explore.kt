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

public val AppIcons.Explore: ImageVector
    get() {
        if (_explore != null) {
            return _explore!!
        }
        _explore = Builder(name = "Explore", defaultWidth = 28.0.dp, defaultHeight = 29.0.dp,
                viewportWidth = 28.0f, viewportHeight = 29.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.941f, 9.833f)
                curveTo(16.941f, 8.222f, 15.635f, 6.917f, 14.024f, 6.917f)
                curveTo(12.413f, 6.917f, 11.107f, 8.222f, 11.107f, 9.833f)
                curveTo(11.107f, 11.444f, 12.413f, 12.75f, 14.024f, 12.75f)
                curveTo(15.635f, 12.75f, 16.941f, 11.444f, 16.941f, 9.833f)
                close()
                moveTo(18.107f, 9.833f)
                curveTo(18.107f, 12.089f, 16.279f, 13.917f, 14.024f, 13.917f)
                curveTo(11.769f, 13.917f, 9.941f, 12.089f, 9.941f, 9.833f)
                curveTo(9.941f, 7.578f, 11.769f, 5.75f, 14.024f, 5.75f)
                curveTo(16.279f, 5.75f, 18.107f, 7.578f, 18.107f, 9.833f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.941f, 9.833f)
                curveTo(16.941f, 8.222f, 15.635f, 6.917f, 14.024f, 6.917f)
                curveTo(12.413f, 6.917f, 11.107f, 8.222f, 11.107f, 9.833f)
                curveTo(11.107f, 11.444f, 12.413f, 12.75f, 14.024f, 12.75f)
                curveTo(15.635f, 12.75f, 16.941f, 11.444f, 16.941f, 9.833f)
                close()
                moveTo(18.107f, 9.833f)
                curveTo(18.107f, 12.089f, 16.279f, 13.917f, 14.024f, 13.917f)
                curveTo(11.769f, 13.917f, 9.941f, 12.089f, 9.941f, 9.833f)
                curveTo(9.941f, 7.578f, 11.769f, 5.75f, 14.024f, 5.75f)
                curveTo(16.279f, 5.75f, 18.107f, 7.578f, 18.107f, 9.833f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.573f, 8.094f)
                curveTo(8.955f, 8.143f, 9.322f, 8.268f, 9.656f, 8.461f)
                curveTo(9.989f, 8.653f, 10.281f, 8.909f, 10.514f, 9.215f)
                curveTo(10.748f, 9.52f, 10.919f, 9.87f, 11.017f, 10.241f)
                curveTo(11.115f, 10.613f, 11.139f, 11.001f, 11.087f, 11.382f)
                curveTo(11.034f, 11.763f, 10.907f, 12.13f, 10.713f, 12.462f)
                curveTo(10.323f, 13.126f, 9.687f, 13.609f, 8.942f, 13.806f)
                curveTo(8.198f, 14.003f, 7.406f, 13.897f, 6.739f, 13.512f)
                curveTo(6.072f, 13.127f, 5.584f, 12.494f, 5.382f, 11.751f)
                curveTo(5.18f, 11.008f, 5.282f, 10.215f, 5.662f, 9.545f)
                curveTo(5.852f, 9.211f, 6.107f, 8.917f, 6.411f, 8.682f)
                curveTo(6.715f, 8.446f, 7.062f, 8.272f, 7.433f, 8.171f)
                curveTo(7.804f, 8.07f, 8.192f, 8.044f, 8.573f, 8.094f)
                close()
                moveTo(20.24f, 8.094f)
                curveTo(20.621f, 8.143f, 20.989f, 8.268f, 21.322f, 8.461f)
                curveTo(21.655f, 8.653f, 21.948f, 8.909f, 22.181f, 9.215f)
                curveTo(22.415f, 9.52f, 22.585f, 9.87f, 22.684f, 10.241f)
                curveTo(22.782f, 10.613f, 22.805f, 11.001f, 22.753f, 11.382f)
                curveTo(22.701f, 11.763f, 22.574f, 12.13f, 22.379f, 12.462f)
                curveTo(21.99f, 13.126f, 21.353f, 13.609f, 20.609f, 13.806f)
                curveTo(19.865f, 14.003f, 19.072f, 13.897f, 18.406f, 13.512f)
                curveTo(17.739f, 13.127f, 17.25f, 12.494f, 17.049f, 11.751f)
                curveTo(16.847f, 11.008f, 16.948f, 10.215f, 17.329f, 9.545f)
                curveTo(17.519f, 9.211f, 17.773f, 8.917f, 18.077f, 8.682f)
                curveTo(18.381f, 8.446f, 18.728f, 8.272f, 19.099f, 8.171f)
                curveTo(19.471f, 8.07f, 19.858f, 8.044f, 20.24f, 8.094f)
                close()
                moveTo(8.423f, 9.251f)
                curveTo(8.194f, 9.222f, 7.962f, 9.238f, 7.739f, 9.298f)
                curveTo(7.516f, 9.358f, 7.307f, 9.462f, 7.125f, 9.603f)
                curveTo(6.943f, 9.745f, 6.79f, 9.921f, 6.676f, 10.122f)
                curveTo(6.448f, 10.523f, 6.388f, 10.999f, 6.509f, 11.444f)
                curveTo(6.63f, 11.89f, 6.922f, 12.271f, 7.322f, 12.502f)
                curveTo(7.722f, 12.733f, 8.198f, 12.796f, 8.645f, 12.678f)
                curveTo(9.091f, 12.56f, 9.473f, 12.27f, 9.707f, 11.872f)
                curveTo(9.823f, 11.673f, 9.9f, 11.452f, 9.931f, 11.223f)
                curveTo(9.962f, 10.995f, 9.948f, 10.762f, 9.889f, 10.539f)
                curveTo(9.83f, 10.316f, 9.727f, 10.107f, 9.587f, 9.923f)
                curveTo(9.447f, 9.74f, 9.272f, 9.587f, 9.072f, 9.471f)
                curveTo(8.872f, 9.356f, 8.652f, 9.281f, 8.423f, 9.251f)
                close()
                moveTo(20.089f, 9.251f)
                curveTo(19.861f, 9.222f, 19.628f, 9.238f, 19.406f, 9.298f)
                curveTo(19.183f, 9.358f, 18.974f, 9.462f, 18.792f, 9.603f)
                curveTo(18.609f, 9.745f, 18.457f, 9.921f, 18.343f, 10.122f)
                curveTo(18.115f, 10.523f, 18.054f, 10.999f, 18.175f, 11.444f)
                curveTo(18.296f, 11.89f, 18.589f, 12.271f, 18.989f, 12.502f)
                curveTo(19.389f, 12.733f, 19.865f, 12.796f, 20.312f, 12.678f)
                curveTo(20.758f, 12.56f, 21.14f, 12.27f, 21.373f, 11.872f)
                curveTo(21.49f, 11.673f, 21.567f, 11.452f, 21.598f, 11.223f)
                curveTo(21.629f, 10.995f, 21.615f, 10.762f, 21.556f, 10.539f)
                curveTo(21.497f, 10.316f, 21.394f, 10.107f, 21.254f, 9.923f)
                curveTo(21.114f, 9.74f, 20.939f, 9.587f, 20.739f, 9.471f)
                curveTo(20.539f, 9.356f, 20.318f, 9.281f, 20.089f, 9.251f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.573f, 8.094f)
                curveTo(8.955f, 8.143f, 9.322f, 8.268f, 9.656f, 8.461f)
                curveTo(9.989f, 8.653f, 10.281f, 8.909f, 10.514f, 9.215f)
                curveTo(10.748f, 9.52f, 10.919f, 9.87f, 11.017f, 10.241f)
                curveTo(11.115f, 10.613f, 11.139f, 11.001f, 11.087f, 11.382f)
                curveTo(11.034f, 11.763f, 10.907f, 12.13f, 10.713f, 12.462f)
                curveTo(10.323f, 13.126f, 9.687f, 13.609f, 8.942f, 13.806f)
                curveTo(8.198f, 14.003f, 7.406f, 13.897f, 6.739f, 13.512f)
                curveTo(6.072f, 13.127f, 5.584f, 12.494f, 5.382f, 11.751f)
                curveTo(5.18f, 11.008f, 5.282f, 10.215f, 5.662f, 9.545f)
                curveTo(5.852f, 9.211f, 6.107f, 8.917f, 6.411f, 8.682f)
                curveTo(6.715f, 8.446f, 7.062f, 8.272f, 7.433f, 8.171f)
                curveTo(7.804f, 8.07f, 8.192f, 8.044f, 8.573f, 8.094f)
                close()
                moveTo(20.24f, 8.094f)
                curveTo(20.621f, 8.143f, 20.989f, 8.268f, 21.322f, 8.461f)
                curveTo(21.655f, 8.653f, 21.948f, 8.909f, 22.181f, 9.215f)
                curveTo(22.415f, 9.52f, 22.585f, 9.87f, 22.684f, 10.241f)
                curveTo(22.782f, 10.613f, 22.805f, 11.001f, 22.753f, 11.382f)
                curveTo(22.701f, 11.763f, 22.574f, 12.13f, 22.379f, 12.462f)
                curveTo(21.99f, 13.126f, 21.353f, 13.609f, 20.609f, 13.806f)
                curveTo(19.865f, 14.003f, 19.072f, 13.897f, 18.406f, 13.512f)
                curveTo(17.739f, 13.127f, 17.25f, 12.494f, 17.049f, 11.751f)
                curveTo(16.847f, 11.008f, 16.948f, 10.215f, 17.329f, 9.545f)
                curveTo(17.519f, 9.211f, 17.773f, 8.917f, 18.077f, 8.682f)
                curveTo(18.381f, 8.446f, 18.728f, 8.272f, 19.099f, 8.171f)
                curveTo(19.471f, 8.07f, 19.858f, 8.044f, 20.24f, 8.094f)
                close()
                moveTo(8.423f, 9.251f)
                curveTo(8.194f, 9.222f, 7.962f, 9.238f, 7.739f, 9.298f)
                curveTo(7.516f, 9.358f, 7.307f, 9.462f, 7.125f, 9.603f)
                curveTo(6.943f, 9.745f, 6.79f, 9.921f, 6.676f, 10.122f)
                curveTo(6.448f, 10.523f, 6.388f, 10.999f, 6.509f, 11.444f)
                curveTo(6.63f, 11.89f, 6.922f, 12.271f, 7.322f, 12.502f)
                curveTo(7.722f, 12.733f, 8.198f, 12.796f, 8.645f, 12.678f)
                curveTo(9.091f, 12.56f, 9.473f, 12.27f, 9.707f, 11.872f)
                curveTo(9.823f, 11.673f, 9.9f, 11.452f, 9.931f, 11.223f)
                curveTo(9.962f, 10.995f, 9.948f, 10.762f, 9.889f, 10.539f)
                curveTo(9.83f, 10.316f, 9.727f, 10.107f, 9.587f, 9.923f)
                curveTo(9.447f, 9.74f, 9.272f, 9.587f, 9.072f, 9.471f)
                curveTo(8.872f, 9.356f, 8.652f, 9.281f, 8.423f, 9.251f)
                close()
                moveTo(20.089f, 9.251f)
                curveTo(19.861f, 9.222f, 19.628f, 9.238f, 19.406f, 9.298f)
                curveTo(19.183f, 9.358f, 18.974f, 9.462f, 18.792f, 9.603f)
                curveTo(18.609f, 9.745f, 18.457f, 9.921f, 18.343f, 10.122f)
                curveTo(18.115f, 10.523f, 18.054f, 10.999f, 18.175f, 11.444f)
                curveTo(18.296f, 11.89f, 18.589f, 12.271f, 18.989f, 12.502f)
                curveTo(19.389f, 12.733f, 19.865f, 12.796f, 20.312f, 12.678f)
                curveTo(20.758f, 12.56f, 21.14f, 12.27f, 21.373f, 11.872f)
                curveTo(21.49f, 11.673f, 21.567f, 11.452f, 21.598f, 11.223f)
                curveTo(21.629f, 10.995f, 21.615f, 10.762f, 21.556f, 10.539f)
                curveTo(21.497f, 10.316f, 21.394f, 10.107f, 21.254f, 9.923f)
                curveTo(21.114f, 9.74f, 20.939f, 9.587f, 20.739f, 9.471f)
                curveTo(20.539f, 9.356f, 20.318f, 9.281f, 20.089f, 9.251f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.024f, 16.25f)
                curveTo(16.265f, 16.25f, 17.765f, 17.058f, 18.742f, 18.144f)
                curveTo(19.7f, 19.208f, 20.113f, 20.492f, 20.293f, 21.396f)
                horizontalLineTo(20.292f)
                curveTo(20.505f, 22.455f, 19.633f, 23.25f, 18.69f, 23.25f)
                horizontalLineTo(9.357f)
                curveTo(8.416f, 23.25f, 7.542f, 22.454f, 7.755f, 21.395f)
                curveTo(7.936f, 20.49f, 8.349f, 19.208f, 9.307f, 18.144f)
                curveTo(10.283f, 17.059f, 11.783f, 16.25f, 14.024f, 16.25f)
                close()
                moveTo(14.024f, 17.417f)
                curveTo(12.098f, 17.417f, 10.919f, 18.096f, 10.174f, 18.924f)
                curveTo(9.41f, 19.772f, 9.058f, 20.827f, 8.899f, 21.624f)
                verticalLineTo(21.625f)
                curveTo(8.874f, 21.748f, 8.909f, 21.85f, 8.983f, 21.931f)
                curveTo(9.062f, 22.017f, 9.193f, 22.083f, 9.357f, 22.083f)
                horizontalLineTo(18.69f)
                curveTo(18.855f, 22.083f, 18.986f, 22.016f, 19.065f, 21.931f)
                curveTo(19.139f, 21.85f, 19.174f, 21.748f, 19.149f, 21.625f)
                lineTo(19.148f, 21.624f)
                curveTo(18.989f, 20.828f, 18.638f, 19.772f, 17.875f, 18.924f)
                curveTo(17.129f, 18.096f, 15.95f, 17.417f, 14.024f, 17.417f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.024f, 16.25f)
                curveTo(16.265f, 16.25f, 17.765f, 17.058f, 18.742f, 18.144f)
                curveTo(19.7f, 19.208f, 20.113f, 20.492f, 20.293f, 21.396f)
                horizontalLineTo(20.292f)
                curveTo(20.505f, 22.455f, 19.633f, 23.25f, 18.69f, 23.25f)
                horizontalLineTo(9.357f)
                curveTo(8.416f, 23.25f, 7.542f, 22.454f, 7.755f, 21.395f)
                curveTo(7.936f, 20.49f, 8.349f, 19.208f, 9.307f, 18.144f)
                curveTo(10.283f, 17.059f, 11.783f, 16.25f, 14.024f, 16.25f)
                close()
                moveTo(14.024f, 17.417f)
                curveTo(12.098f, 17.417f, 10.919f, 18.096f, 10.174f, 18.924f)
                curveTo(9.41f, 19.772f, 9.058f, 20.827f, 8.899f, 21.624f)
                verticalLineTo(21.625f)
                curveTo(8.874f, 21.748f, 8.909f, 21.85f, 8.983f, 21.931f)
                curveTo(9.062f, 22.017f, 9.193f, 22.083f, 9.357f, 22.083f)
                horizontalLineTo(18.69f)
                curveTo(18.855f, 22.083f, 18.986f, 22.016f, 19.065f, 21.931f)
                curveTo(19.139f, 21.85f, 19.174f, 21.748f, 19.149f, 21.625f)
                lineTo(19.148f, 21.624f)
                curveTo(18.989f, 20.828f, 18.638f, 19.772f, 17.875f, 18.924f)
                curveTo(17.129f, 18.096f, 15.95f, 17.417f, 14.024f, 17.417f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.166f, 15.551f)
                curveTo(9.224f, 15.538f, 10.249f, 15.925f, 11.034f, 16.634f)
                lineTo(11.597f, 17.144f)
                lineTo(10.96f, 17.556f)
                curveTo(9.382f, 18.579f, 8.524f, 20.406f, 8.067f, 22.117f)
                lineTo(7.952f, 22.55f)
                horizontalLineTo(4.789f)
                curveTo(3.772f, 22.55f, 2.9f, 21.649f, 3.17f, 20.562f)
                lineTo(3.172f, 20.56f)
                curveTo(3.395f, 19.67f, 3.812f, 18.441f, 4.576f, 17.424f)
                curveTo(5.351f, 16.392f, 6.506f, 15.554f, 8.158f, 15.551f)
                curveTo(8.16f, 15.551f, 8.162f, 15.551f, 8.164f, 15.551f)
                lineTo(8.166f, 15.55f)
                verticalLineTo(15.551f)
                close()
                moveTo(19.833f, 15.55f)
                curveTo(21.49f, 15.55f, 22.648f, 16.39f, 23.424f, 17.424f)
                curveTo(24.093f, 18.314f, 24.496f, 19.367f, 24.736f, 20.212f)
                lineTo(24.829f, 20.56f)
                verticalLineTo(20.562f)
                curveTo(25.1f, 21.649f, 24.228f, 22.55f, 23.211f, 22.55f)
                horizontalLineTo(20.049f)
                lineTo(19.933f, 22.117f)
                curveTo(19.477f, 20.407f, 18.619f, 18.579f, 17.041f, 17.556f)
                lineTo(16.397f, 17.139f)
                lineTo(16.971f, 16.63f)
                curveTo(17.7f, 15.985f, 18.644f, 15.55f, 19.833f, 15.55f)
                close()
                moveTo(8.166f, 16.716f)
                curveTo(6.967f, 16.717f, 6.125f, 17.303f, 5.508f, 18.125f)
                curveTo(4.879f, 18.963f, 4.51f, 20.019f, 4.303f, 20.844f)
                curveTo(4.241f, 21.096f, 4.426f, 21.383f, 4.789f, 21.383f)
                horizontalLineTo(7.065f)
                curveTo(7.513f, 19.898f, 8.29f, 18.249f, 9.652f, 17.081f)
                curveTo(9.201f, 16.839f, 8.694f, 16.709f, 8.174f, 16.716f)
                horizontalLineTo(8.166f)
                close()
                moveTo(19.833f, 16.716f)
                curveTo(19.256f, 16.716f, 18.767f, 16.854f, 18.347f, 17.081f)
                curveTo(19.71f, 18.249f, 20.488f, 19.897f, 20.937f, 21.383f)
                horizontalLineTo(23.211f)
                curveTo(23.575f, 21.383f, 23.76f, 21.096f, 23.698f, 20.844f)
                lineTo(23.612f, 20.525f)
                curveTo(23.394f, 19.759f, 23.042f, 18.858f, 22.491f, 18.125f)
                curveTo(21.874f, 17.303f, 21.032f, 16.716f, 19.833f, 16.716f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(8.166f, 15.551f)
                curveTo(9.224f, 15.538f, 10.249f, 15.925f, 11.034f, 16.634f)
                lineTo(11.597f, 17.144f)
                lineTo(10.96f, 17.556f)
                curveTo(9.382f, 18.579f, 8.524f, 20.406f, 8.067f, 22.117f)
                lineTo(7.952f, 22.55f)
                horizontalLineTo(4.789f)
                curveTo(3.772f, 22.55f, 2.9f, 21.649f, 3.17f, 20.562f)
                lineTo(3.172f, 20.56f)
                curveTo(3.395f, 19.67f, 3.812f, 18.441f, 4.576f, 17.424f)
                curveTo(5.351f, 16.392f, 6.506f, 15.554f, 8.158f, 15.551f)
                curveTo(8.16f, 15.551f, 8.162f, 15.551f, 8.164f, 15.551f)
                lineTo(8.166f, 15.55f)
                verticalLineTo(15.551f)
                close()
                moveTo(19.833f, 15.55f)
                curveTo(21.49f, 15.55f, 22.648f, 16.39f, 23.424f, 17.424f)
                curveTo(24.093f, 18.314f, 24.496f, 19.367f, 24.736f, 20.212f)
                lineTo(24.829f, 20.56f)
                verticalLineTo(20.562f)
                curveTo(25.1f, 21.649f, 24.228f, 22.55f, 23.211f, 22.55f)
                horizontalLineTo(20.049f)
                lineTo(19.933f, 22.117f)
                curveTo(19.477f, 20.407f, 18.619f, 18.579f, 17.041f, 17.556f)
                lineTo(16.397f, 17.139f)
                lineTo(16.971f, 16.63f)
                curveTo(17.7f, 15.985f, 18.644f, 15.55f, 19.833f, 15.55f)
                close()
                moveTo(8.166f, 16.716f)
                curveTo(6.967f, 16.717f, 6.125f, 17.303f, 5.508f, 18.125f)
                curveTo(4.879f, 18.963f, 4.51f, 20.019f, 4.303f, 20.844f)
                curveTo(4.241f, 21.096f, 4.426f, 21.383f, 4.789f, 21.383f)
                horizontalLineTo(7.065f)
                curveTo(7.513f, 19.898f, 8.29f, 18.249f, 9.652f, 17.081f)
                curveTo(9.201f, 16.839f, 8.694f, 16.709f, 8.174f, 16.716f)
                horizontalLineTo(8.166f)
                close()
                moveTo(19.833f, 16.716f)
                curveTo(19.256f, 16.716f, 18.767f, 16.854f, 18.347f, 17.081f)
                curveTo(19.71f, 18.249f, 20.488f, 19.897f, 20.937f, 21.383f)
                horizontalLineTo(23.211f)
                curveTo(23.575f, 21.383f, 23.76f, 21.096f, 23.698f, 20.844f)
                lineTo(23.612f, 20.525f)
                curveTo(23.394f, 19.759f, 23.042f, 18.858f, 22.491f, 18.125f)
                curveTo(21.874f, 17.303f, 21.032f, 16.716f, 19.833f, 16.716f)
                close()
            }
        }
        .build()
        return _explore!!
    }

private var _explore: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Explore, contentDescription = "")
    }
}
