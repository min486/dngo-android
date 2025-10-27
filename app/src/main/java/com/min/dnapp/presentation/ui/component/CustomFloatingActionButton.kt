package com.min.dnapp.presentation.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Pen
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun CustomFloatingActionButton(
    onClick: () -> Unit
) {
    Surface(
        onClick = { onClick() },
        color = MomentoTheme.colors.pinkB20,
        shape = RoundedCornerShape(50.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = AppIcons.Pen,
                contentDescription = null,
                tint = MomentoTheme.colors.white
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = "기록 남기기",
                style = MomentoTheme.typography.label,
                color = MomentoTheme.colors.white
            )
        }
    }
}
