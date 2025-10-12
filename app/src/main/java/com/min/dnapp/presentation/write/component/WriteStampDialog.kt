package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun WriteStampDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            color = MomentoTheme.colors.white
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.write_stamp),
                    contentDescription = null
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "스탬프 1개가 지급되었어요!",
                    style = MomentoTheme.typography.title01,
                    color = MomentoTheme.colors.grayW20
                )
                Spacer(Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .clickable { onConfirm() }
                        .fillMaxWidth()
                        .background(color = MomentoTheme.colors.brownBase, shape = RoundedCornerShape(10.dp))
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "확인했어요",
                        style = MomentoTheme.typography.body01,
                        color = MomentoTheme.colors.white
                    )
                }
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}
