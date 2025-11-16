package com.min.dnapp.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun SelectButton(
    enabled: Boolean,
    onConfirm: () -> Unit
) {
    val buttonColor = if (enabled) {
        MomentoTheme.colors.brownBase
    } else {
        MomentoTheme.colors.grayW80
    }

    Box(
        modifier = Modifier
            .clickable(enabled = enabled, onClick = onConfirm)
            .fillMaxWidth()
            .background(color = buttonColor, shape = RoundedCornerShape(10.dp))
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "선택했어요",
            style = MomentoTheme.typography.body01,
            color = MomentoTheme.colors.white
        )
    }
}
