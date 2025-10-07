package com.min.dnapp.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.onboarding.component.OnboardingButtonSection
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun OnboardingScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MomentoTheme.colors.brownW90
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Spacer(Modifier.height(144.dp))
                Image(
                    painter = painterResource(R.drawable.logo_onboarding),
                    contentDescription = null
                )
            }

            OnboardingButtonSection(
                title = "모멘토와 함께하는 따뜻하고 진솔한 공간. \n제목, 날짜, 장소, 감정을 \n입력하여 내 기록을 남겨보세요.",
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    DngoTheme {
        OnboardingScreen()
    }
}
