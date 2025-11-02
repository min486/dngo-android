package com.min.dnapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun CustomSnackbar(
    snackbarData: SnackbarData
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color = MomentoTheme.colors.grayW20)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.logo_snackbar),
            contentDescription = null
        )
        Spacer(Modifier.width(10.dp))
        Text(
            text = snackbarData.visuals.message,
//            style = MomentoTheme.typography.label,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.white
        )
    }
}

@Preview
@Composable
fun CustomSnackbarPreview() {
    DngoTheme {
//        CustomSnackbar()
    }
}
