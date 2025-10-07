package com.min.dnapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun ProfileSetupScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MomentoTheme.colors.white
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileSelectSection()
            ProfileButtonSection(
                onClick = {}
            )
        }
    }
}

@Composable
fun ProfileSelectSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))

        Text(
            text = "프로필 설정",
            style = MomentoTheme.typography.title01,
            color = MomentoTheme.colors.black
        )

        Spacer(Modifier.height(34.dp))

        // 기본 프로필이미지 목록 (8개)
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_profile),
                    contentDescription = null
                )
                Spacer(Modifier.width(20.dp))
                Image(
                    painter = painterResource(R.drawable.logo_profile2),
                    contentDescription = null
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_profile3),
                    contentDescription = null
                )
                Spacer(Modifier.width(20.dp))
                Image(
                    painter = painterResource(R.drawable.logo_profile4),
                    contentDescription = null
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_profile5),
                    contentDescription = null
                )
                Spacer(Modifier.width(20.dp))
                Image(
                    painter = painterResource(R.drawable.logo_profile6),
                    contentDescription = null
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_profile7),
                    contentDescription = null
                )
                Spacer(Modifier.width(20.dp))
                Image(
                    painter = painterResource(R.drawable.logo_profile8),
                    contentDescription = null
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "프로필을 설정해주세요!",
            style = MomentoTheme.typography.title01,
            color = MomentoTheme.colors.black
        )
    }
}

@Composable
fun ProfileButtonSection(
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxWidth()
                .background(color = MomentoTheme.colors.brownBase, shape = RoundedCornerShape(10.dp))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "선택했어요",
                style = MomentoTheme.typography.body01,
                color = MomentoTheme.colors.white
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun ProfileSetupScreenPreview() {
    DngoTheme {
        ProfileSetupScreen()
    }
}
