package com.min.dnapp.presentation.init.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun OnboardingButtonSection(
    onboardingNum: Int,
    title: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MomentoTheme.colors.white, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(40.dp))
            Text(
                text = title,
                style = MomentoTheme.typography.body01,
                color = MomentoTheme.colors.black,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    OnboardingIndicator(
                        isActive = onboardingNum == 1
                    )
                    Spacer(Modifier.width(4.dp))
                    OnboardingIndicator(
                        isActive = onboardingNum == 2
                    )
                    Spacer(Modifier.width(4.dp))
                    OnboardingIndicator(
                        isActive = onboardingNum == 3
                    )
                }
                Box(
                    modifier = Modifier
                        .clickable { onClick() }
                        .background(color = MomentoTheme.colors.pinkW80, shape = RoundedCornerShape(10.dp))
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "Next",
                        style = MomentoTheme.typography.label,
                        color = MomentoTheme.colors.black,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Composable
private fun OnboardingIndicator(isActive: Boolean) {
    val indicatorColor = if (isActive) MomentoTheme.colors.pinkBase else MomentoTheme.colors.pinkW40
    val indicatorShape = if (isActive) RoundedCornerShape(20.dp) else CircleShape
    val indicatorWidth = if (isActive) 16.dp else 8.dp
    val indicatorHeight = 8.dp

    Box(
        modifier = Modifier
            .width(indicatorWidth)
            .height(indicatorHeight)
            .background(color = indicatorColor, shape = indicatorShape)
    )
}
