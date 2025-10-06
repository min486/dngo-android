package com.min.dnapp.presentation.ui.icon.appicons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.icon.AppIcons
import kotlin.Unit

public val AppIcons.Kakao: ImageVector
    get() {
        if (_kakao != null) {
            return _kakao!!
        }
        _kakao = Builder(name = "Kakao", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(10.0f, 0.667f)
                curveTo(4.477f, 0.667f, 0.0f, 4.125f, 0.0f, 8.391f)
                curveTo(0.0f, 11.044f, 1.732f, 13.383f, 4.369f, 14.774f)
                lineTo(3.259f, 18.827f)
                curveTo(3.161f, 19.185f, 3.571f, 19.471f, 3.885f, 19.263f)
                lineTo(8.749f, 16.053f)
                curveTo(9.159f, 16.093f, 9.576f, 16.116f, 10.0f, 16.116f)
                curveTo(15.523f, 16.116f, 20.0f, 12.658f, 20.0f, 8.391f)
                curveTo(20.0f, 4.125f, 15.523f, 0.667f, 10.0f, 0.667f)
                close()
            }
        }
        .build()
        return _kakao!!
    }

private var _kakao: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Kakao, contentDescription = "")
    }
}
