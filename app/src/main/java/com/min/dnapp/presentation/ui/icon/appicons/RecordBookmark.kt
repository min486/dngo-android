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

public val AppIcons.RecordBookmark: ImageVector
    get() {
        if (_recordBookmark != null) {
            return _recordBookmark!!
        }
        _recordBookmark = Builder(name = "RecordBookmark", defaultWidth = 20.0.dp, defaultHeight =
                20.0.dp, viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.0f, 13.395f)
                curveTo(10.391f, 13.395f, 10.733f, 13.532f, 11.086f, 13.748f)
                curveTo(11.43f, 13.958f, 11.822f, 14.267f, 12.306f, 14.649f)
                lineTo(12.866f, 15.092f)
                lineTo(13.484f, 15.578f)
                curveTo(14.057f, 16.025f, 14.503f, 16.356f, 14.872f, 16.569f)
                curveTo(15.369f, 16.855f, 15.598f, 16.851f, 15.755f, 16.775f)
                lineTo(15.812f, 16.741f)
                curveTo(15.945f, 16.648f, 16.065f, 16.449f, 16.138f, 15.951f)
                curveTo(16.22f, 15.387f, 16.221f, 14.586f, 16.221f, 13.454f)
                verticalLineTo(7.764f)
                curveTo(16.221f, 6.574f, 16.22f, 5.722f, 16.134f, 5.076f)
                curveTo(16.059f, 4.521f, 15.927f, 4.164f, 15.712f, 3.899f)
                lineTo(15.614f, 3.791f)
                curveTo(15.34f, 3.515f, 14.966f, 3.354f, 14.335f, 3.268f)
                curveTo(13.691f, 3.181f, 12.844f, 3.181f, 11.659f, 3.181f)
                horizontalLineTo(8.341f)
                curveTo(7.156f, 3.181f, 6.309f, 3.181f, 5.665f, 3.268f)
                curveTo(5.113f, 3.343f, 4.758f, 3.476f, 4.494f, 3.692f)
                lineTo(4.386f, 3.791f)
                curveTo(4.112f, 4.066f, 3.951f, 4.441f, 3.866f, 5.076f)
                curveTo(3.78f, 5.722f, 3.779f, 6.574f, 3.779f, 7.764f)
                verticalLineTo(13.454f)
                curveTo(3.779f, 14.585f, 3.78f, 15.387f, 3.862f, 15.951f)
                curveTo(3.945f, 16.521f, 4.09f, 16.699f, 4.245f, 16.775f)
                curveTo(4.401f, 16.851f, 4.631f, 16.855f, 5.127f, 16.569f)
                curveTo(5.619f, 16.285f, 6.248f, 15.791f, 7.134f, 15.091f)
                lineTo(7.694f, 14.649f)
                curveTo(8.178f, 14.267f, 8.57f, 13.958f, 8.914f, 13.748f)
                curveTo(9.267f, 13.532f, 9.609f, 13.395f, 10.0f, 13.395f)
                close()
                moveTo(17.051f, 13.454f)
                curveTo(17.051f, 14.558f, 17.052f, 15.433f, 16.959f, 16.072f)
                curveTo(16.867f, 16.706f, 16.662f, 17.258f, 16.118f, 17.525f)
                horizontalLineTo(16.117f)
                curveTo(15.572f, 17.79f, 15.014f, 17.611f, 14.46f, 17.292f)
                curveTo(14.042f, 17.051f, 13.552f, 16.686f, 12.969f, 16.231f)
                lineTo(12.353f, 15.747f)
                lineTo(11.793f, 15.304f)
                curveTo(11.294f, 14.91f, 10.947f, 14.638f, 10.655f, 14.46f)
                curveTo(10.373f, 14.287f, 10.182f, 14.229f, 10.0f, 14.229f)
                curveTo(9.818f, 14.229f, 9.627f, 14.287f, 9.345f, 14.46f)
                curveTo(9.053f, 14.638f, 8.706f, 14.91f, 8.206f, 15.304f)
                verticalLineTo(15.305f)
                lineTo(7.646f, 15.746f)
                curveTo(6.782f, 16.428f, 6.097f, 16.97f, 5.54f, 17.292f)
                curveTo(4.986f, 17.611f, 4.428f, 17.79f, 3.883f, 17.525f)
                curveTo(3.339f, 17.259f, 3.133f, 16.706f, 3.041f, 16.072f)
                curveTo(2.948f, 15.433f, 2.949f, 14.557f, 2.949f, 13.454f)
                verticalLineTo(7.764f)
                curveTo(2.949f, 6.597f, 2.948f, 5.68f, 3.044f, 4.965f)
                curveTo(3.141f, 4.238f, 3.345f, 3.658f, 3.8f, 3.202f)
                lineTo(3.976f, 3.042f)
                curveTo(4.4f, 2.696f, 4.922f, 2.528f, 5.555f, 2.442f)
                curveTo(6.267f, 2.346f, 7.18f, 2.347f, 8.341f, 2.347f)
                horizontalLineTo(11.659f)
                curveTo(12.82f, 2.347f, 13.733f, 2.346f, 14.445f, 2.442f)
                curveTo(15.168f, 2.54f, 15.746f, 2.745f, 16.2f, 3.202f)
                lineTo(16.359f, 3.378f)
                curveTo(16.704f, 3.805f, 16.871f, 4.329f, 16.956f, 4.965f)
                curveTo(17.052f, 5.68f, 17.051f, 6.597f, 17.051f, 7.764f)
                verticalLineTo(13.454f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(10.0f, 13.395f)
                curveTo(10.391f, 13.395f, 10.733f, 13.532f, 11.086f, 13.748f)
                curveTo(11.43f, 13.958f, 11.822f, 14.267f, 12.306f, 14.649f)
                lineTo(12.866f, 15.092f)
                lineTo(13.484f, 15.578f)
                curveTo(14.057f, 16.025f, 14.503f, 16.356f, 14.872f, 16.569f)
                curveTo(15.369f, 16.855f, 15.598f, 16.851f, 15.755f, 16.775f)
                lineTo(15.812f, 16.741f)
                curveTo(15.945f, 16.648f, 16.065f, 16.449f, 16.138f, 15.951f)
                curveTo(16.22f, 15.387f, 16.221f, 14.586f, 16.221f, 13.454f)
                verticalLineTo(7.764f)
                curveTo(16.221f, 6.574f, 16.22f, 5.722f, 16.134f, 5.076f)
                curveTo(16.059f, 4.521f, 15.927f, 4.164f, 15.712f, 3.899f)
                lineTo(15.614f, 3.791f)
                curveTo(15.34f, 3.515f, 14.966f, 3.354f, 14.335f, 3.268f)
                curveTo(13.691f, 3.181f, 12.844f, 3.181f, 11.659f, 3.181f)
                horizontalLineTo(8.341f)
                curveTo(7.156f, 3.181f, 6.309f, 3.181f, 5.665f, 3.268f)
                curveTo(5.113f, 3.343f, 4.758f, 3.476f, 4.494f, 3.692f)
                lineTo(4.386f, 3.791f)
                curveTo(4.112f, 4.066f, 3.951f, 4.441f, 3.866f, 5.076f)
                curveTo(3.78f, 5.722f, 3.779f, 6.574f, 3.779f, 7.764f)
                verticalLineTo(13.454f)
                curveTo(3.779f, 14.585f, 3.78f, 15.387f, 3.862f, 15.951f)
                curveTo(3.945f, 16.521f, 4.09f, 16.699f, 4.245f, 16.775f)
                curveTo(4.401f, 16.851f, 4.631f, 16.855f, 5.127f, 16.569f)
                curveTo(5.619f, 16.285f, 6.248f, 15.791f, 7.134f, 15.091f)
                lineTo(7.694f, 14.649f)
                curveTo(8.178f, 14.267f, 8.57f, 13.958f, 8.914f, 13.748f)
                curveTo(9.267f, 13.532f, 9.609f, 13.395f, 10.0f, 13.395f)
                close()
                moveTo(17.051f, 13.454f)
                curveTo(17.051f, 14.558f, 17.052f, 15.433f, 16.959f, 16.072f)
                curveTo(16.867f, 16.706f, 16.662f, 17.258f, 16.118f, 17.525f)
                horizontalLineTo(16.117f)
                curveTo(15.572f, 17.79f, 15.014f, 17.611f, 14.46f, 17.292f)
                curveTo(14.042f, 17.051f, 13.552f, 16.686f, 12.969f, 16.231f)
                lineTo(12.353f, 15.747f)
                lineTo(11.793f, 15.304f)
                curveTo(11.294f, 14.91f, 10.947f, 14.638f, 10.655f, 14.46f)
                curveTo(10.373f, 14.287f, 10.182f, 14.229f, 10.0f, 14.229f)
                curveTo(9.818f, 14.229f, 9.627f, 14.287f, 9.345f, 14.46f)
                curveTo(9.053f, 14.638f, 8.706f, 14.91f, 8.206f, 15.304f)
                verticalLineTo(15.305f)
                lineTo(7.646f, 15.746f)
                curveTo(6.782f, 16.428f, 6.097f, 16.97f, 5.54f, 17.292f)
                curveTo(4.986f, 17.611f, 4.428f, 17.79f, 3.883f, 17.525f)
                curveTo(3.339f, 17.259f, 3.133f, 16.706f, 3.041f, 16.072f)
                curveTo(2.948f, 15.433f, 2.949f, 14.557f, 2.949f, 13.454f)
                verticalLineTo(7.764f)
                curveTo(2.949f, 6.597f, 2.948f, 5.68f, 3.044f, 4.965f)
                curveTo(3.141f, 4.238f, 3.345f, 3.658f, 3.8f, 3.202f)
                lineTo(3.976f, 3.042f)
                curveTo(4.4f, 2.696f, 4.922f, 2.528f, 5.555f, 2.442f)
                curveTo(6.267f, 2.346f, 7.18f, 2.347f, 8.341f, 2.347f)
                horizontalLineTo(11.659f)
                curveTo(12.82f, 2.347f, 13.733f, 2.346f, 14.445f, 2.442f)
                curveTo(15.168f, 2.54f, 15.746f, 2.745f, 16.2f, 3.202f)
                lineTo(16.359f, 3.378f)
                curveTo(16.704f, 3.805f, 16.871f, 4.329f, 16.956f, 4.965f)
                curveTo(17.052f, 5.68f, 17.051f, 6.597f, 17.051f, 7.764f)
                verticalLineTo(13.454f)
                close()
            }
        }
        .build()
        return _recordBookmark!!
    }

private var _recordBookmark: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.RecordBookmark, contentDescription = "")
    }
}
