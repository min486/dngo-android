package com.min.dnapp.presentation.ui.icon.appicons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
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

public val AppIcons.Gallery: ImageVector
    get() {
        if (_gallery != null) {
            return _gallery!!
        }
        _gallery = Builder(name = "Gallery", defaultWidth = 22.0.dp, defaultHeight = 22.0.dp,
                viewportWidth = 22.0f, viewportHeight = 22.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(11.25f, 0.75f)
                curveTo(13.121f, 0.75f, 14.576f, 0.749f, 15.706f, 0.901f)
                curveTo(16.851f, 1.055f, 17.738f, 1.374f, 18.432f, 2.068f)
                curveTo(19.125f, 2.763f, 19.444f, 3.65f, 19.599f, 4.795f)
                curveTo(19.751f, 5.925f, 19.75f, 7.379f, 19.75f, 9.25f)
                verticalLineTo(11.25f)
                curveTo(19.75f, 11.293f, 19.749f, 11.336f, 19.749f, 11.379f)
                curveTo(19.434f, 11.153f, 19.1f, 10.958f, 18.75f, 10.797f)
                verticalLineTo(9.25f)
                curveTo(18.75f, 7.35f, 18.749f, 5.976f, 18.607f, 4.928f)
                curveTo(18.468f, 3.894f, 18.202f, 3.253f, 17.725f, 2.775f)
                curveTo(17.247f, 2.298f, 16.606f, 2.031f, 15.572f, 1.892f)
                curveTo(14.524f, 1.751f, 13.15f, 1.75f, 11.25f, 1.75f)
                horizontalLineTo(9.25f)
                curveTo(7.35f, 1.75f, 5.976f, 1.751f, 4.928f, 1.893f)
                curveTo(3.894f, 2.032f, 3.253f, 2.298f, 2.775f, 2.775f)
                curveTo(2.298f, 3.252f, 2.031f, 3.894f, 1.892f, 4.928f)
                curveTo(1.751f, 5.976f, 1.75f, 7.35f, 1.75f, 9.25f)
                verticalLineTo(11.25f)
                curveTo(1.75f, 13.15f, 1.751f, 14.524f, 1.893f, 15.572f)
                curveTo(2.032f, 16.606f, 2.298f, 17.247f, 2.775f, 17.725f)
                curveTo(3.252f, 18.202f, 3.894f, 18.469f, 4.928f, 18.608f)
                curveTo(5.976f, 18.749f, 7.35f, 18.75f, 9.25f, 18.75f)
                horizontalLineTo(10.797f)
                curveTo(10.958f, 19.1f, 11.153f, 19.434f, 11.379f, 19.749f)
                curveTo(11.336f, 19.749f, 11.293f, 19.75f, 11.25f, 19.75f)
                horizontalLineTo(9.25f)
                curveTo(7.379f, 19.75f, 5.924f, 19.751f, 4.794f, 19.599f)
                curveTo(3.65f, 19.445f, 2.762f, 19.126f, 2.068f, 18.432f)
                curveTo(1.375f, 17.737f, 1.055f, 16.85f, 0.901f, 15.705f)
                curveTo(0.749f, 14.575f, 0.75f, 13.121f, 0.75f, 11.25f)
                verticalLineTo(9.25f)
                curveTo(0.75f, 7.379f, 0.749f, 5.924f, 0.901f, 4.794f)
                curveTo(1.055f, 3.65f, 1.374f, 2.762f, 2.068f, 2.068f)
                curveTo(2.763f, 1.375f, 3.65f, 1.055f, 4.795f, 0.901f)
                curveTo(5.925f, 0.749f, 7.379f, 0.75f, 9.25f, 0.75f)
                horizontalLineTo(11.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.25f, 0.75f)
                curveTo(13.121f, 0.75f, 14.576f, 0.749f, 15.706f, 0.901f)
                curveTo(16.851f, 1.055f, 17.738f, 1.374f, 18.432f, 2.068f)
                curveTo(19.125f, 2.763f, 19.444f, 3.65f, 19.599f, 4.795f)
                curveTo(19.751f, 5.925f, 19.75f, 7.379f, 19.75f, 9.25f)
                verticalLineTo(11.25f)
                curveTo(19.75f, 11.293f, 19.749f, 11.336f, 19.749f, 11.379f)
                curveTo(19.434f, 11.153f, 19.1f, 10.958f, 18.75f, 10.797f)
                verticalLineTo(9.25f)
                curveTo(18.75f, 7.35f, 18.749f, 5.976f, 18.607f, 4.928f)
                curveTo(18.468f, 3.894f, 18.202f, 3.253f, 17.725f, 2.775f)
                curveTo(17.247f, 2.298f, 16.606f, 2.031f, 15.572f, 1.892f)
                curveTo(14.524f, 1.751f, 13.15f, 1.75f, 11.25f, 1.75f)
                horizontalLineTo(9.25f)
                curveTo(7.35f, 1.75f, 5.976f, 1.751f, 4.928f, 1.893f)
                curveTo(3.894f, 2.032f, 3.253f, 2.298f, 2.775f, 2.775f)
                curveTo(2.298f, 3.252f, 2.031f, 3.894f, 1.892f, 4.928f)
                curveTo(1.751f, 5.976f, 1.75f, 7.35f, 1.75f, 9.25f)
                verticalLineTo(11.25f)
                curveTo(1.75f, 13.15f, 1.751f, 14.524f, 1.893f, 15.572f)
                curveTo(2.032f, 16.606f, 2.298f, 17.247f, 2.775f, 17.725f)
                curveTo(3.252f, 18.202f, 3.894f, 18.469f, 4.928f, 18.608f)
                curveTo(5.976f, 18.749f, 7.35f, 18.75f, 9.25f, 18.75f)
                horizontalLineTo(10.797f)
                curveTo(10.958f, 19.1f, 11.153f, 19.434f, 11.379f, 19.749f)
                curveTo(11.336f, 19.749f, 11.293f, 19.75f, 11.25f, 19.75f)
                horizontalLineTo(9.25f)
                curveTo(7.379f, 19.75f, 5.924f, 19.751f, 4.794f, 19.599f)
                curveTo(3.65f, 19.445f, 2.762f, 19.126f, 2.068f, 18.432f)
                curveTo(1.375f, 17.737f, 1.055f, 16.85f, 0.901f, 15.705f)
                curveTo(0.749f, 14.575f, 0.75f, 13.121f, 0.75f, 11.25f)
                verticalLineTo(9.25f)
                curveTo(0.75f, 7.379f, 0.749f, 5.924f, 0.901f, 4.794f)
                curveTo(1.055f, 3.65f, 1.374f, 2.762f, 2.068f, 2.068f)
                curveTo(2.763f, 1.375f, 3.65f, 1.055f, 4.795f, 0.901f)
                curveTo(5.925f, 0.749f, 7.379f, 0.75f, 9.25f, 0.75f)
                horizontalLineTo(11.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(6.366f, 8.262f)
                curveTo(6.825f, 8.223f, 7.285f, 8.312f, 7.696f, 8.518f)
                curveTo(8.155f, 8.748f, 8.474f, 9.153f, 8.761f, 9.663f)
                curveTo(9.043f, 10.164f, 9.333f, 10.841f, 9.697f, 11.691f)
                lineTo(9.71f, 11.72f)
                lineTo(9.763f, 11.844f)
                curveTo(9.878f, 12.127f, 10.004f, 12.406f, 10.143f, 12.679f)
                curveTo(10.243f, 12.862f, 10.3f, 12.908f, 10.324f, 12.924f)
                curveTo(10.428f, 12.988f, 10.552f, 13.012f, 10.673f, 12.991f)
                curveTo(10.702f, 12.986f, 10.772f, 12.964f, 10.933f, 12.831f)
                curveTo(11.096f, 12.697f, 11.296f, 12.497f, 11.596f, 12.197f)
                lineTo(11.611f, 12.181f)
                curveTo(12.012f, 11.781f, 12.335f, 11.458f, 12.618f, 11.219f)
                curveTo(12.911f, 10.973f, 13.195f, 10.785f, 13.528f, 10.685f)
                curveTo(13.778f, 10.609f, 14.035f, 10.575f, 14.293f, 10.579f)
                curveTo(13.441f, 10.873f, 12.658f, 11.358f, 12.008f, 12.008f)
                curveTo(11.435f, 12.58f, 10.99f, 13.257f, 10.691f, 13.993f)
                curveTo(10.379f, 14.015f, 10.066f, 13.941f, 9.798f, 13.774f)
                curveTo(9.554f, 13.623f, 9.394f, 13.396f, 9.264f, 13.157f)
                curveTo(9.138f, 12.925f, 9.008f, 12.621f, 8.854f, 12.261f)
                lineTo(8.844f, 12.238f)
                lineTo(8.79f, 12.113f)
                curveTo(8.411f, 11.228f, 8.142f, 10.603f, 7.889f, 10.153f)
                curveTo(7.638f, 9.706f, 7.442f, 9.509f, 7.248f, 9.412f)
                curveTo(7.001f, 9.288f, 6.725f, 9.235f, 6.449f, 9.258f)
                curveTo(6.233f, 9.277f, 5.978f, 9.387f, 5.578f, 9.708f)
                curveTo(5.177f, 10.031f, 4.694f, 10.513f, 4.013f, 11.193f)
                lineTo(3.25f, 11.957f)
                verticalLineTo(10.543f)
                lineTo(3.306f, 10.486f)
                lineTo(3.328f, 10.465f)
                curveTo(3.982f, 9.81f, 4.503f, 9.29f, 4.951f, 8.929f)
                curveTo(5.407f, 8.562f, 5.853f, 8.305f, 6.366f, 8.262f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(6.366f, 8.262f)
                curveTo(6.825f, 8.223f, 7.285f, 8.312f, 7.696f, 8.518f)
                curveTo(8.155f, 8.748f, 8.474f, 9.153f, 8.761f, 9.663f)
                curveTo(9.043f, 10.164f, 9.333f, 10.841f, 9.697f, 11.691f)
                lineTo(9.71f, 11.72f)
                lineTo(9.763f, 11.844f)
                curveTo(9.878f, 12.127f, 10.004f, 12.406f, 10.143f, 12.679f)
                curveTo(10.243f, 12.862f, 10.3f, 12.908f, 10.324f, 12.924f)
                curveTo(10.428f, 12.988f, 10.552f, 13.012f, 10.673f, 12.991f)
                curveTo(10.702f, 12.986f, 10.772f, 12.964f, 10.933f, 12.831f)
                curveTo(11.096f, 12.697f, 11.296f, 12.497f, 11.596f, 12.197f)
                lineTo(11.611f, 12.181f)
                curveTo(12.012f, 11.781f, 12.335f, 11.458f, 12.618f, 11.219f)
                curveTo(12.911f, 10.973f, 13.195f, 10.785f, 13.528f, 10.685f)
                curveTo(13.778f, 10.609f, 14.035f, 10.575f, 14.293f, 10.579f)
                curveTo(13.441f, 10.873f, 12.658f, 11.358f, 12.008f, 12.008f)
                curveTo(11.435f, 12.58f, 10.99f, 13.257f, 10.691f, 13.993f)
                curveTo(10.379f, 14.015f, 10.066f, 13.941f, 9.798f, 13.774f)
                curveTo(9.554f, 13.623f, 9.394f, 13.396f, 9.264f, 13.157f)
                curveTo(9.138f, 12.925f, 9.008f, 12.621f, 8.854f, 12.261f)
                lineTo(8.844f, 12.238f)
                lineTo(8.79f, 12.113f)
                curveTo(8.411f, 11.228f, 8.142f, 10.603f, 7.889f, 10.153f)
                curveTo(7.638f, 9.706f, 7.442f, 9.509f, 7.248f, 9.412f)
                curveTo(7.001f, 9.288f, 6.725f, 9.235f, 6.449f, 9.258f)
                curveTo(6.233f, 9.277f, 5.978f, 9.387f, 5.578f, 9.708f)
                curveTo(5.177f, 10.031f, 4.694f, 10.513f, 4.013f, 11.193f)
                lineTo(3.25f, 11.957f)
                verticalLineTo(10.543f)
                lineTo(3.306f, 10.486f)
                lineTo(3.328f, 10.465f)
                curveTo(3.982f, 9.81f, 4.503f, 9.29f, 4.951f, 8.929f)
                curveTo(5.407f, 8.562f, 5.853f, 8.305f, 6.366f, 8.262f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.75f, 4.25f)
                curveTo(15.578f, 4.25f, 16.25f, 4.922f, 16.25f, 5.75f)
                curveTo(16.25f, 6.578f, 15.578f, 7.25f, 14.75f, 7.25f)
                curveTo(13.922f, 7.25f, 13.25f, 6.578f, 13.25f, 5.75f)
                curveTo(13.25f, 4.922f, 13.922f, 4.25f, 14.75f, 4.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.75f, 4.25f)
                curveTo(15.578f, 4.25f, 16.25f, 4.922f, 16.25f, 5.75f)
                curveTo(16.25f, 6.578f, 15.578f, 7.25f, 14.75f, 7.25f)
                curveTo(13.922f, 7.25f, 13.25f, 6.578f, 13.25f, 5.75f)
                curveTo(13.25f, 4.922f, 13.922f, 4.25f, 14.75f, 4.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(16.25f, 21.25f)
                curveTo(17.576f, 21.25f, 18.848f, 20.723f, 19.785f, 19.785f)
                curveTo(20.723f, 18.848f, 21.25f, 17.576f, 21.25f, 16.25f)
                curveTo(21.25f, 14.924f, 20.723f, 13.652f, 19.785f, 12.715f)
                curveTo(18.848f, 11.777f, 17.576f, 11.25f, 16.25f, 11.25f)
                curveTo(14.924f, 11.25f, 13.652f, 11.777f, 12.715f, 12.715f)
                curveTo(11.777f, 13.652f, 11.25f, 14.924f, 11.25f, 16.25f)
                curveTo(11.25f, 17.576f, 11.777f, 18.848f, 12.715f, 19.785f)
                curveTo(13.652f, 20.723f, 14.924f, 21.25f, 16.25f, 21.25f)
                close()
                moveTo(16.25f, 13.075f)
                curveTo(16.371f, 13.075f, 16.486f, 13.122f, 16.571f, 13.208f)
                curveTo(16.657f, 13.293f, 16.705f, 13.408f, 16.705f, 13.529f)
                verticalLineTo(15.795f)
                horizontalLineTo(18.971f)
                curveTo(19.091f, 15.795f, 19.207f, 15.843f, 19.292f, 15.929f)
                curveTo(19.378f, 16.014f, 19.426f, 16.129f, 19.426f, 16.25f)
                curveTo(19.426f, 16.371f, 19.378f, 16.486f, 19.292f, 16.571f)
                curveTo(19.207f, 16.657f, 19.091f, 16.705f, 18.971f, 16.705f)
                horizontalLineTo(16.705f)
                verticalLineTo(18.972f)
                curveTo(16.705f, 19.092f, 16.657f, 19.208f, 16.571f, 19.293f)
                curveTo(16.486f, 19.378f, 16.371f, 19.426f, 16.25f, 19.426f)
                curveTo(16.129f, 19.426f, 16.014f, 19.378f, 15.929f, 19.293f)
                curveTo(15.843f, 19.208f, 15.795f, 19.092f, 15.795f, 18.972f)
                verticalLineTo(16.705f)
                horizontalLineTo(13.529f)
                curveTo(13.408f, 16.705f, 13.293f, 16.657f, 13.208f, 16.571f)
                curveTo(13.122f, 16.486f, 13.075f, 16.371f, 13.075f, 16.25f)
                curveTo(13.075f, 16.129f, 13.122f, 16.014f, 13.208f, 15.929f)
                curveTo(13.293f, 15.843f, 13.408f, 15.795f, 13.529f, 15.795f)
                horizontalLineTo(15.795f)
                verticalLineTo(13.529f)
                curveTo(15.795f, 13.408f, 15.843f, 13.293f, 15.929f, 13.208f)
                curveTo(16.014f, 13.122f, 16.129f, 13.075f, 16.25f, 13.075f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(16.25f, 21.25f)
                curveTo(17.576f, 21.25f, 18.848f, 20.723f, 19.785f, 19.785f)
                curveTo(20.723f, 18.848f, 21.25f, 17.576f, 21.25f, 16.25f)
                curveTo(21.25f, 14.924f, 20.723f, 13.652f, 19.785f, 12.715f)
                curveTo(18.848f, 11.777f, 17.576f, 11.25f, 16.25f, 11.25f)
                curveTo(14.924f, 11.25f, 13.652f, 11.777f, 12.715f, 12.715f)
                curveTo(11.777f, 13.652f, 11.25f, 14.924f, 11.25f, 16.25f)
                curveTo(11.25f, 17.576f, 11.777f, 18.848f, 12.715f, 19.785f)
                curveTo(13.652f, 20.723f, 14.924f, 21.25f, 16.25f, 21.25f)
                close()
                moveTo(16.25f, 13.075f)
                curveTo(16.371f, 13.075f, 16.486f, 13.122f, 16.571f, 13.208f)
                curveTo(16.657f, 13.293f, 16.705f, 13.408f, 16.705f, 13.529f)
                verticalLineTo(15.795f)
                horizontalLineTo(18.971f)
                curveTo(19.091f, 15.795f, 19.207f, 15.843f, 19.292f, 15.929f)
                curveTo(19.378f, 16.014f, 19.426f, 16.129f, 19.426f, 16.25f)
                curveTo(19.426f, 16.371f, 19.378f, 16.486f, 19.292f, 16.571f)
                curveTo(19.207f, 16.657f, 19.091f, 16.705f, 18.971f, 16.705f)
                horizontalLineTo(16.705f)
                verticalLineTo(18.972f)
                curveTo(16.705f, 19.092f, 16.657f, 19.208f, 16.571f, 19.293f)
                curveTo(16.486f, 19.378f, 16.371f, 19.426f, 16.25f, 19.426f)
                curveTo(16.129f, 19.426f, 16.014f, 19.378f, 15.929f, 19.293f)
                curveTo(15.843f, 19.208f, 15.795f, 19.092f, 15.795f, 18.972f)
                verticalLineTo(16.705f)
                horizontalLineTo(13.529f)
                curveTo(13.408f, 16.705f, 13.293f, 16.657f, 13.208f, 16.571f)
                curveTo(13.122f, 16.486f, 13.075f, 16.371f, 13.075f, 16.25f)
                curveTo(13.075f, 16.129f, 13.122f, 16.014f, 13.208f, 15.929f)
                curveTo(13.293f, 15.843f, 13.408f, 15.795f, 13.529f, 15.795f)
                horizontalLineTo(15.795f)
                verticalLineTo(13.529f)
                curveTo(15.795f, 13.408f, 15.843f, 13.293f, 15.929f, 13.208f)
                curveTo(16.014f, 13.122f, 16.129f, 13.075f, 16.25f, 13.075f)
                close()
            }
        }
        .build()
        return _gallery!!
    }

private var _gallery: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Gallery, contentDescription = "")
    }
}
