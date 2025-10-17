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

public val AppIcons.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 29.0.dp, defaultHeight = 29.0.dp,
                viewportWidth = 29.0f, viewportHeight = 29.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(23.25f, 12.167f)
                curveTo(23.25f, 12.012f, 23.189f, 11.864f, 23.079f, 11.755f)
                curveTo(22.97f, 11.645f, 22.822f, 11.584f, 22.667f, 11.584f)
                curveTo(22.512f, 11.584f, 22.364f, 11.645f, 22.254f, 11.755f)
                curveTo(22.145f, 11.864f, 22.083f, 12.012f, 22.083f, 12.167f)
                horizontalLineTo(23.25f)
                close()
                moveTo(6.917f, 12.167f)
                curveTo(6.917f, 12.012f, 6.855f, 11.864f, 6.746f, 11.755f)
                curveTo(6.636f, 11.645f, 6.488f, 11.584f, 6.333f, 11.584f)
                curveTo(6.179f, 11.584f, 6.03f, 11.645f, 5.921f, 11.755f)
                curveTo(5.812f, 11.864f, 5.75f, 12.012f, 5.75f, 12.167f)
                horizontalLineTo(6.917f)
                close()
                moveTo(24.587f, 14.913f)
                curveTo(24.697f, 15.023f, 24.845f, 15.085f, 25.0f, 15.085f)
                curveTo(25.155f, 15.085f, 25.304f, 15.023f, 25.413f, 14.913f)
                curveTo(25.523f, 14.804f, 25.584f, 14.655f, 25.584f, 14.5f)
                curveTo(25.584f, 14.345f, 25.523f, 14.197f, 25.413f, 14.087f)
                lineTo(24.587f, 14.913f)
                close()
                moveTo(14.5f, 4.0f)
                lineTo(14.913f, 3.587f)
                curveTo(14.859f, 3.533f, 14.795f, 3.49f, 14.724f, 3.461f)
                curveTo(14.653f, 3.431f, 14.577f, 3.416f, 14.5f, 3.416f)
                curveTo(14.423f, 3.416f, 14.347f, 3.431f, 14.276f, 3.461f)
                curveTo(14.206f, 3.49f, 14.141f, 3.533f, 14.087f, 3.587f)
                lineTo(14.5f, 4.0f)
                close()
                moveTo(3.587f, 14.087f)
                curveTo(3.478f, 14.197f, 3.416f, 14.345f, 3.416f, 14.5f)
                curveTo(3.416f, 14.655f, 3.478f, 14.804f, 3.587f, 14.913f)
                curveTo(3.697f, 15.023f, 3.845f, 15.085f, 4.0f, 15.085f)
                curveTo(4.155f, 15.085f, 4.304f, 15.023f, 4.413f, 14.913f)
                lineTo(3.587f, 14.087f)
                close()
                moveTo(8.667f, 25.584f)
                horizontalLineTo(20.333f)
                verticalLineTo(24.417f)
                horizontalLineTo(8.667f)
                verticalLineTo(25.584f)
                close()
                moveTo(23.25f, 22.667f)
                verticalLineTo(12.167f)
                horizontalLineTo(22.083f)
                verticalLineTo(22.667f)
                horizontalLineTo(23.25f)
                close()
                moveTo(6.917f, 22.667f)
                verticalLineTo(12.167f)
                horizontalLineTo(5.75f)
                verticalLineTo(22.667f)
                horizontalLineTo(6.917f)
                close()
                moveTo(25.413f, 14.087f)
                lineTo(14.913f, 3.587f)
                lineTo(14.087f, 4.413f)
                lineTo(24.587f, 14.913f)
                lineTo(25.413f, 14.087f)
                close()
                moveTo(14.087f, 3.587f)
                lineTo(3.587f, 14.087f)
                lineTo(4.413f, 14.913f)
                lineTo(14.913f, 4.413f)
                lineTo(14.087f, 3.587f)
                close()
                moveTo(20.333f, 25.584f)
                curveTo(21.107f, 25.584f, 21.849f, 25.276f, 22.396f, 24.729f)
                curveTo(22.943f, 24.183f, 23.25f, 23.441f, 23.25f, 22.667f)
                horizontalLineTo(22.083f)
                curveTo(22.083f, 23.131f, 21.899f, 23.576f, 21.571f, 23.904f)
                curveTo(21.243f, 24.233f, 20.798f, 24.417f, 20.333f, 24.417f)
                verticalLineTo(25.584f)
                close()
                moveTo(8.667f, 24.417f)
                curveTo(8.203f, 24.417f, 7.758f, 24.233f, 7.429f, 23.904f)
                curveTo(7.101f, 23.576f, 6.917f, 23.131f, 6.917f, 22.667f)
                horizontalLineTo(5.75f)
                curveTo(5.75f, 23.441f, 6.057f, 24.183f, 6.604f, 24.729f)
                curveTo(7.151f, 25.276f, 7.893f, 25.584f, 8.667f, 25.584f)
                verticalLineTo(24.417f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, fillAlpha = 0.6f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(23.25f, 12.167f)
                curveTo(23.25f, 12.012f, 23.189f, 11.864f, 23.079f, 11.755f)
                curveTo(22.97f, 11.645f, 22.822f, 11.584f, 22.667f, 11.584f)
                curveTo(22.512f, 11.584f, 22.364f, 11.645f, 22.254f, 11.755f)
                curveTo(22.145f, 11.864f, 22.083f, 12.012f, 22.083f, 12.167f)
                horizontalLineTo(23.25f)
                close()
                moveTo(6.917f, 12.167f)
                curveTo(6.917f, 12.012f, 6.855f, 11.864f, 6.746f, 11.755f)
                curveTo(6.636f, 11.645f, 6.488f, 11.584f, 6.333f, 11.584f)
                curveTo(6.179f, 11.584f, 6.03f, 11.645f, 5.921f, 11.755f)
                curveTo(5.812f, 11.864f, 5.75f, 12.012f, 5.75f, 12.167f)
                horizontalLineTo(6.917f)
                close()
                moveTo(24.587f, 14.913f)
                curveTo(24.697f, 15.023f, 24.845f, 15.085f, 25.0f, 15.085f)
                curveTo(25.155f, 15.085f, 25.304f, 15.023f, 25.413f, 14.913f)
                curveTo(25.523f, 14.804f, 25.584f, 14.655f, 25.584f, 14.5f)
                curveTo(25.584f, 14.345f, 25.523f, 14.197f, 25.413f, 14.087f)
                lineTo(24.587f, 14.913f)
                close()
                moveTo(14.5f, 4.0f)
                lineTo(14.913f, 3.587f)
                curveTo(14.859f, 3.533f, 14.795f, 3.49f, 14.724f, 3.461f)
                curveTo(14.653f, 3.431f, 14.577f, 3.416f, 14.5f, 3.416f)
                curveTo(14.423f, 3.416f, 14.347f, 3.431f, 14.276f, 3.461f)
                curveTo(14.206f, 3.49f, 14.141f, 3.533f, 14.087f, 3.587f)
                lineTo(14.5f, 4.0f)
                close()
                moveTo(3.587f, 14.087f)
                curveTo(3.478f, 14.197f, 3.416f, 14.345f, 3.416f, 14.5f)
                curveTo(3.416f, 14.655f, 3.478f, 14.804f, 3.587f, 14.913f)
                curveTo(3.697f, 15.023f, 3.845f, 15.085f, 4.0f, 15.085f)
                curveTo(4.155f, 15.085f, 4.304f, 15.023f, 4.413f, 14.913f)
                lineTo(3.587f, 14.087f)
                close()
                moveTo(8.667f, 25.584f)
                horizontalLineTo(20.333f)
                verticalLineTo(24.417f)
                horizontalLineTo(8.667f)
                verticalLineTo(25.584f)
                close()
                moveTo(23.25f, 22.667f)
                verticalLineTo(12.167f)
                horizontalLineTo(22.083f)
                verticalLineTo(22.667f)
                horizontalLineTo(23.25f)
                close()
                moveTo(6.917f, 22.667f)
                verticalLineTo(12.167f)
                horizontalLineTo(5.75f)
                verticalLineTo(22.667f)
                horizontalLineTo(6.917f)
                close()
                moveTo(25.413f, 14.087f)
                lineTo(14.913f, 3.587f)
                lineTo(14.087f, 4.413f)
                lineTo(24.587f, 14.913f)
                lineTo(25.413f, 14.087f)
                close()
                moveTo(14.087f, 3.587f)
                lineTo(3.587f, 14.087f)
                lineTo(4.413f, 14.913f)
                lineTo(14.913f, 4.413f)
                lineTo(14.087f, 3.587f)
                close()
                moveTo(20.333f, 25.584f)
                curveTo(21.107f, 25.584f, 21.849f, 25.276f, 22.396f, 24.729f)
                curveTo(22.943f, 24.183f, 23.25f, 23.441f, 23.25f, 22.667f)
                horizontalLineTo(22.083f)
                curveTo(22.083f, 23.131f, 21.899f, 23.576f, 21.571f, 23.904f)
                curveTo(21.243f, 24.233f, 20.798f, 24.417f, 20.333f, 24.417f)
                verticalLineTo(25.584f)
                close()
                moveTo(8.667f, 24.417f)
                curveTo(8.203f, 24.417f, 7.758f, 24.233f, 7.429f, 23.904f)
                curveTo(7.101f, 23.576f, 6.917f, 23.131f, 6.917f, 22.667f)
                horizontalLineTo(5.75f)
                curveTo(5.75f, 23.441f, 6.057f, 24.183f, 6.604f, 24.729f)
                curveTo(7.151f, 25.276f, 7.893f, 25.584f, 8.667f, 25.584f)
                verticalLineTo(24.417f)
                close()
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = AppIcons.Home, contentDescription = "")
    }
}
