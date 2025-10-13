package com.min.dnapp.presentation.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun ProfileImageCircle(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(width = 2.dp, color = MomentoTheme.colors.grayW90, shape = CircleShape)
    ) {
        Image(
            painter = painterResource(R.drawable.logo_profile),
            contentDescription = null
        )
    }
}
