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

public val AppIcons.Pen: ImageVector
    get() {
        if (_pen != null) {
            return _pen!!
        }
        _pen = Builder(name = "Pen", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp, viewportWidth
                = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(15.026f, 7.164f)
                curveTo(15.026f, 6.992f, 14.956f, 6.835f, 14.817f, 6.653f)
                curveTo(14.682f, 6.476f, 14.48f, 6.273f, 14.212f, 6.005f)
                lineTo(14.192f, 5.985f)
                lineTo(14.029f, 5.822f)
                curveTo(13.762f, 5.555f, 13.559f, 5.353f, 13.382f, 5.218f)
                lineTo(13.249f, 5.127f)
                curveTo(13.12f, 5.048f, 13.0f, 5.009f, 12.871f, 5.009f)
                curveTo(12.699f, 5.009f, 12.543f, 5.078f, 12.361f, 5.217f)
                curveTo(12.184f, 5.352f, 11.98f, 5.555f, 11.712f, 5.822f)
                lineTo(5.693f, 11.842f)
                lineTo(5.665f, 11.869f)
                curveTo(5.524f, 12.011f, 5.45f, 12.089f, 5.399f, 12.178f)
                lineTo(5.398f, 12.179f)
                curveTo(5.346f, 12.271f, 5.318f, 12.376f, 5.269f, 12.575f)
                lineTo(5.259f, 12.611f)
                lineTo(4.698f, 14.852f)
                curveTo(4.67f, 14.959f, 4.647f, 15.068f, 4.631f, 15.177f)
                curveTo(4.627f, 15.215f, 4.629f, 15.251f, 4.636f, 15.282f)
                curveTo(4.642f, 15.311f, 4.654f, 15.335f, 4.677f, 15.359f)
                curveTo(4.7f, 15.382f, 4.724f, 15.393f, 4.751f, 15.399f)
                curveTo(4.782f, 15.406f, 4.818f, 15.406f, 4.857f, 15.403f)
                curveTo(4.972f, 15.387f, 5.087f, 15.363f, 5.199f, 15.332f)
                lineTo(5.216f, 15.327f)
                lineTo(7.423f, 14.775f)
                lineTo(7.434f, 14.773f)
                lineTo(7.459f, 14.767f)
                curveTo(7.657f, 14.717f, 7.764f, 14.688f, 7.855f, 14.637f)
                curveTo(7.947f, 14.584f, 8.027f, 14.507f, 8.17f, 14.365f)
                lineTo(8.197f, 14.337f)
                lineTo(14.192f, 8.342f)
                lineTo(14.212f, 8.322f)
                curveTo(14.48f, 8.055f, 14.682f, 7.851f, 14.817f, 7.674f)
                curveTo(14.956f, 7.491f, 15.026f, 7.335f, 15.026f, 7.164f)
                close()
                moveTo(15.859f, 7.164f)
                curveTo(15.859f, 7.592f, 15.674f, 7.924f, 15.48f, 8.179f)
                lineTo(15.479f, 8.18f)
                curveTo(15.303f, 8.411f, 15.055f, 8.658f, 14.802f, 8.912f)
                lineTo(8.759f, 14.954f)
                curveTo(8.632f, 15.081f, 8.474f, 15.243f, 8.268f, 15.361f)
                curveTo(8.06f, 15.479f, 7.837f, 15.531f, 7.663f, 15.575f)
                lineTo(7.652f, 15.578f)
                lineTo(7.625f, 15.583f)
                lineTo(5.444f, 16.128f)
                lineTo(5.427f, 16.133f)
                curveTo(5.273f, 16.177f, 5.115f, 16.21f, 4.956f, 16.23f)
                lineTo(4.946f, 16.232f)
                curveTo(4.774f, 16.25f, 4.395f, 16.257f, 4.086f, 15.947f)
                curveTo(3.779f, 15.639f, 3.786f, 15.262f, 3.802f, 15.091f)
                lineTo(3.803f, 15.081f)
                lineTo(3.805f, 15.072f)
                curveTo(3.826f, 14.925f, 3.855f, 14.78f, 3.893f, 14.637f)
                lineTo(4.451f, 12.409f)
                lineTo(4.46f, 12.373f)
                curveTo(4.503f, 12.198f, 4.555f, 11.976f, 4.673f, 11.768f)
                curveTo(4.79f, 11.561f, 4.955f, 11.402f, 5.08f, 11.276f)
                lineTo(5.085f, 11.27f)
                lineTo(5.108f, 11.248f)
                lineTo(11.103f, 5.253f)
                lineTo(11.123f, 5.233f)
                curveTo(11.377f, 4.98f, 11.624f, 4.731f, 11.855f, 4.555f)
                curveTo(12.111f, 4.359f, 12.443f, 4.175f, 12.871f, 4.175f)
                curveTo(13.246f, 4.175f, 13.547f, 4.317f, 13.788f, 4.483f)
                lineTo(13.887f, 4.555f)
                lineTo(14.064f, 4.699f)
                curveTo(14.242f, 4.855f, 14.428f, 5.043f, 14.618f, 5.233f)
                lineTo(14.639f, 5.253f)
                lineTo(14.781f, 5.396f)
                lineTo(14.802f, 5.416f)
                curveTo(15.055f, 5.669f, 15.303f, 5.916f, 15.479f, 6.147f)
                lineTo(15.552f, 6.247f)
                curveTo(15.718f, 6.488f, 15.859f, 6.789f, 15.859f, 7.164f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.788f, 5.914f)
                lineTo(13.288f, 4.247f)
                lineTo(15.788f, 6.747f)
                lineTo(14.121f, 9.247f)
                lineTo(10.788f, 5.914f)
                close()
            }
        }
        .build()
        return _pen!!
    }

private var _pen: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Pen, contentDescription = "")
    }
}
