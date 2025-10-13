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

public val AppIcons.RecordComment: ImageVector
    get() {
        if (_recordComment != null) {
            return _recordComment!!
        }
        _recordComment = Builder(name = "RecordComment", defaultWidth = 20.0.dp, defaultHeight =
                20.0.dp, viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.25f, 9.23f)
                curveTo(16.25f, 8.051f, 16.249f, 7.198f, 16.182f, 6.534f)
                curveTo(16.115f, 5.877f, 15.986f, 5.45f, 15.759f, 5.11f)
                curveTo(15.546f, 4.791f, 15.272f, 4.518f, 14.954f, 4.305f)
                curveTo(14.613f, 4.077f, 14.187f, 3.949f, 13.53f, 3.882f)
                curveTo(12.865f, 3.814f, 12.012f, 3.813f, 10.833f, 3.813f)
                horizontalLineTo(9.167f)
                curveTo(7.987f, 3.813f, 7.135f, 3.814f, 6.471f, 3.882f)
                curveTo(5.814f, 3.949f, 5.387f, 4.077f, 5.046f, 4.305f)
                curveTo(4.728f, 4.518f, 4.454f, 4.791f, 4.242f, 5.11f)
                curveTo(4.014f, 5.45f, 3.885f, 5.877f, 3.818f, 6.534f)
                curveTo(3.751f, 7.198f, 3.75f, 8.051f, 3.75f, 9.23f)
                curveTo(3.75f, 10.409f, 3.751f, 11.262f, 3.818f, 11.926f)
                curveTo(3.885f, 12.583f, 4.014f, 13.01f, 4.242f, 13.35f)
                curveTo(4.454f, 13.669f, 4.728f, 13.942f, 5.046f, 14.155f)
                curveTo(5.344f, 14.354f, 5.708f, 14.478f, 6.233f, 14.551f)
                curveTo(6.765f, 14.624f, 7.434f, 14.642f, 8.335f, 14.647f)
                curveTo(8.492f, 14.647f, 8.636f, 14.736f, 8.706f, 14.877f)
                lineTo(9.627f, 16.719f)
                lineTo(9.657f, 16.769f)
                curveTo(9.689f, 16.816f, 9.732f, 16.857f, 9.781f, 16.887f)
                curveTo(9.847f, 16.928f, 9.923f, 16.949f, 10.0f, 16.949f)
                curveTo(10.077f, 16.949f, 10.153f, 16.928f, 10.219f, 16.887f)
                curveTo(10.285f, 16.847f, 10.338f, 16.788f, 10.373f, 16.719f)
                lineTo(11.294f, 14.876f)
                curveTo(11.364f, 14.736f, 11.508f, 14.647f, 11.665f, 14.646f)
                curveTo(12.566f, 14.642f, 13.236f, 14.624f, 13.768f, 14.551f)
                curveTo(14.293f, 14.478f, 14.656f, 14.354f, 14.954f, 14.155f)
                lineTo(15.071f, 14.073f)
                curveTo(15.34f, 13.874f, 15.572f, 13.629f, 15.759f, 13.35f)
                curveTo(15.986f, 13.01f, 16.115f, 12.583f, 16.182f, 11.926f)
                curveTo(16.249f, 11.262f, 16.25f, 10.409f, 16.25f, 9.23f)
                close()
                moveTo(10.0f, 10.48f)
                curveTo(10.23f, 10.48f, 10.417f, 10.667f, 10.417f, 10.897f)
                curveTo(10.417f, 11.127f, 10.23f, 11.313f, 10.0f, 11.313f)
                horizontalLineTo(7.5f)
                curveTo(7.27f, 11.313f, 7.083f, 11.127f, 7.083f, 10.897f)
                curveTo(7.083f, 10.667f, 7.27f, 10.48f, 7.5f, 10.48f)
                horizontalLineTo(10.0f)
                close()
                moveTo(12.5f, 7.147f)
                curveTo(12.73f, 7.147f, 12.917f, 7.333f, 12.917f, 7.563f)
                curveTo(12.917f, 7.793f, 12.73f, 7.98f, 12.5f, 7.98f)
                horizontalLineTo(7.5f)
                curveTo(7.27f, 7.98f, 7.083f, 7.793f, 7.083f, 7.563f)
                curveTo(7.083f, 7.333f, 7.27f, 7.147f, 7.5f, 7.147f)
                horizontalLineTo(12.5f)
                close()
                moveTo(17.083f, 9.23f)
                curveTo(17.083f, 10.392f, 17.084f, 11.295f, 17.011f, 12.011f)
                curveTo(16.937f, 12.734f, 16.786f, 13.313f, 16.452f, 13.813f)
                curveTo(16.178f, 14.223f, 15.826f, 14.575f, 15.417f, 14.849f)
                lineTo(15.416f, 14.848f)
                curveTo(14.979f, 15.14f, 14.483f, 15.293f, 13.882f, 15.376f)
                curveTo(13.346f, 15.45f, 12.705f, 15.469f, 11.925f, 15.476f)
                lineTo(11.117f, 17.092f)
                curveTo(11.014f, 17.299f, 10.854f, 17.474f, 10.657f, 17.596f)
                curveTo(10.46f, 17.718f, 10.232f, 17.782f, 10.0f, 17.782f)
                curveTo(9.768f, 17.782f, 9.541f, 17.718f, 9.343f, 17.596f)
                curveTo(9.146f, 17.474f, 8.987f, 17.299f, 8.883f, 17.092f)
                lineTo(8.075f, 15.477f)
                curveTo(7.295f, 15.47f, 6.655f, 15.45f, 6.118f, 15.376f)
                curveTo(5.517f, 15.292f, 5.02f, 15.14f, 4.583f, 14.849f)
                curveTo(4.174f, 14.575f, 3.822f, 14.223f, 3.548f, 13.813f)
                curveTo(3.214f, 13.313f, 3.063f, 12.734f, 2.989f, 12.011f)
                curveTo(2.916f, 11.295f, 2.917f, 10.392f, 2.917f, 9.23f)
                curveTo(2.917f, 8.068f, 2.916f, 7.165f, 2.989f, 6.449f)
                curveTo(3.063f, 5.726f, 3.214f, 5.147f, 3.548f, 4.647f)
                curveTo(3.822f, 4.237f, 4.174f, 3.885f, 4.583f, 3.611f)
                curveTo(5.084f, 3.277f, 5.663f, 3.126f, 6.386f, 3.052f)
                curveTo(7.102f, 2.98f, 8.005f, 2.98f, 9.167f, 2.98f)
                horizontalLineTo(10.833f)
                curveTo(11.995f, 2.98f, 12.898f, 2.98f, 13.614f, 3.052f)
                curveTo(14.337f, 3.126f, 14.917f, 3.277f, 15.417f, 3.611f)
                curveTo(15.826f, 3.885f, 16.178f, 4.237f, 16.452f, 4.647f)
                curveTo(16.786f, 5.147f, 16.937f, 5.726f, 17.011f, 6.449f)
                curveTo(17.084f, 7.165f, 17.083f, 8.068f, 17.083f, 9.23f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.25f, 9.23f)
                curveTo(16.25f, 8.051f, 16.249f, 7.198f, 16.182f, 6.534f)
                curveTo(16.115f, 5.877f, 15.986f, 5.45f, 15.759f, 5.11f)
                curveTo(15.546f, 4.791f, 15.272f, 4.518f, 14.954f, 4.305f)
                curveTo(14.613f, 4.077f, 14.187f, 3.949f, 13.53f, 3.882f)
                curveTo(12.865f, 3.814f, 12.012f, 3.813f, 10.833f, 3.813f)
                horizontalLineTo(9.167f)
                curveTo(7.987f, 3.813f, 7.135f, 3.814f, 6.471f, 3.882f)
                curveTo(5.814f, 3.949f, 5.387f, 4.077f, 5.046f, 4.305f)
                curveTo(4.728f, 4.518f, 4.454f, 4.791f, 4.242f, 5.11f)
                curveTo(4.014f, 5.45f, 3.885f, 5.877f, 3.818f, 6.534f)
                curveTo(3.751f, 7.198f, 3.75f, 8.051f, 3.75f, 9.23f)
                curveTo(3.75f, 10.409f, 3.751f, 11.262f, 3.818f, 11.926f)
                curveTo(3.885f, 12.583f, 4.014f, 13.01f, 4.242f, 13.35f)
                curveTo(4.454f, 13.669f, 4.728f, 13.942f, 5.046f, 14.155f)
                curveTo(5.344f, 14.354f, 5.708f, 14.478f, 6.233f, 14.551f)
                curveTo(6.765f, 14.624f, 7.434f, 14.642f, 8.335f, 14.647f)
                curveTo(8.492f, 14.647f, 8.636f, 14.736f, 8.706f, 14.877f)
                lineTo(9.627f, 16.719f)
                lineTo(9.657f, 16.769f)
                curveTo(9.689f, 16.816f, 9.732f, 16.857f, 9.781f, 16.887f)
                curveTo(9.847f, 16.928f, 9.923f, 16.949f, 10.0f, 16.949f)
                curveTo(10.077f, 16.949f, 10.153f, 16.928f, 10.219f, 16.887f)
                curveTo(10.285f, 16.847f, 10.338f, 16.788f, 10.373f, 16.719f)
                lineTo(11.294f, 14.876f)
                curveTo(11.364f, 14.736f, 11.508f, 14.647f, 11.665f, 14.646f)
                curveTo(12.566f, 14.642f, 13.236f, 14.624f, 13.768f, 14.551f)
                curveTo(14.293f, 14.478f, 14.656f, 14.354f, 14.954f, 14.155f)
                lineTo(15.071f, 14.073f)
                curveTo(15.34f, 13.874f, 15.572f, 13.629f, 15.759f, 13.35f)
                curveTo(15.986f, 13.01f, 16.115f, 12.583f, 16.182f, 11.926f)
                curveTo(16.249f, 11.262f, 16.25f, 10.409f, 16.25f, 9.23f)
                close()
                moveTo(10.0f, 10.48f)
                curveTo(10.23f, 10.48f, 10.417f, 10.667f, 10.417f, 10.897f)
                curveTo(10.417f, 11.127f, 10.23f, 11.313f, 10.0f, 11.313f)
                horizontalLineTo(7.5f)
                curveTo(7.27f, 11.313f, 7.083f, 11.127f, 7.083f, 10.897f)
                curveTo(7.083f, 10.667f, 7.27f, 10.48f, 7.5f, 10.48f)
                horizontalLineTo(10.0f)
                close()
                moveTo(12.5f, 7.147f)
                curveTo(12.73f, 7.147f, 12.917f, 7.333f, 12.917f, 7.563f)
                curveTo(12.917f, 7.793f, 12.73f, 7.98f, 12.5f, 7.98f)
                horizontalLineTo(7.5f)
                curveTo(7.27f, 7.98f, 7.083f, 7.793f, 7.083f, 7.563f)
                curveTo(7.083f, 7.333f, 7.27f, 7.147f, 7.5f, 7.147f)
                horizontalLineTo(12.5f)
                close()
                moveTo(17.083f, 9.23f)
                curveTo(17.083f, 10.392f, 17.084f, 11.295f, 17.011f, 12.011f)
                curveTo(16.937f, 12.734f, 16.786f, 13.313f, 16.452f, 13.813f)
                curveTo(16.178f, 14.223f, 15.826f, 14.575f, 15.417f, 14.849f)
                lineTo(15.416f, 14.848f)
                curveTo(14.979f, 15.14f, 14.483f, 15.293f, 13.882f, 15.376f)
                curveTo(13.346f, 15.45f, 12.705f, 15.469f, 11.925f, 15.476f)
                lineTo(11.117f, 17.092f)
                curveTo(11.014f, 17.299f, 10.854f, 17.474f, 10.657f, 17.596f)
                curveTo(10.46f, 17.718f, 10.232f, 17.782f, 10.0f, 17.782f)
                curveTo(9.768f, 17.782f, 9.541f, 17.718f, 9.343f, 17.596f)
                curveTo(9.146f, 17.474f, 8.987f, 17.299f, 8.883f, 17.092f)
                lineTo(8.075f, 15.477f)
                curveTo(7.295f, 15.47f, 6.655f, 15.45f, 6.118f, 15.376f)
                curveTo(5.517f, 15.292f, 5.02f, 15.14f, 4.583f, 14.849f)
                curveTo(4.174f, 14.575f, 3.822f, 14.223f, 3.548f, 13.813f)
                curveTo(3.214f, 13.313f, 3.063f, 12.734f, 2.989f, 12.011f)
                curveTo(2.916f, 11.295f, 2.917f, 10.392f, 2.917f, 9.23f)
                curveTo(2.917f, 8.068f, 2.916f, 7.165f, 2.989f, 6.449f)
                curveTo(3.063f, 5.726f, 3.214f, 5.147f, 3.548f, 4.647f)
                curveTo(3.822f, 4.237f, 4.174f, 3.885f, 4.583f, 3.611f)
                curveTo(5.084f, 3.277f, 5.663f, 3.126f, 6.386f, 3.052f)
                curveTo(7.102f, 2.98f, 8.005f, 2.98f, 9.167f, 2.98f)
                horizontalLineTo(10.833f)
                curveTo(11.995f, 2.98f, 12.898f, 2.98f, 13.614f, 3.052f)
                curveTo(14.337f, 3.126f, 14.917f, 3.277f, 15.417f, 3.611f)
                curveTo(15.826f, 3.885f, 16.178f, 4.237f, 16.452f, 4.647f)
                curveTo(16.786f, 5.147f, 16.937f, 5.726f, 17.011f, 6.449f)
                curveTo(17.084f, 7.165f, 17.083f, 8.068f, 17.083f, 9.23f)
                close()
            }
        }
        .build()
        return _recordComment!!
    }

private var _recordComment: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.RecordComment, contentDescription = "")
    }
}
