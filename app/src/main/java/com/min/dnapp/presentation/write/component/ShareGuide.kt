package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.DeleteLine
import com.min.dnapp.presentation.ui.icon.appicons.ShareTriangle
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun ShareGuide(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.padding(end = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier
                    .background(color = MomentoTheme.colors.greenW60, shape = RoundedCornerShape(5.dp))
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "발견 탭에 나의 여행 기록을 공유합니다",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW20
                )
                Icon(
                    modifier = Modifier
                        .clickable { onClick() }
                        .padding(12.dp),
                    imageVector = AppIcons.DeleteLine,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW20
                )
            }

            Row {
                Icon(
                    imageVector = AppIcons.ShareTriangle,
                    contentDescription = null,
                    tint = MomentoTheme.colors.greenW60
                )
                Spacer(Modifier.width(16.dp))
            }
        }
    }
}
