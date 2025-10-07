package com.min.dnapp.presentation.onboarding.component

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
import androidx.compose.foundation.layout.size
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
//                text = "모멘토와 함께하는 따뜻하고 진솔한 공간. \n제목, 날짜, 장소, 감정을 \n입력하여 내 기록을 남겨보세요.",
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
                    Box(
                        modifier = Modifier
                            .width(16.dp)
                            .height(8.dp)
                            .background(color = MomentoTheme.colors.pinkBase, shape = RoundedCornerShape(20.dp))
                    )
                    Spacer(Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(color = MomentoTheme.colors.pinkW40, shape = CircleShape)
                    )
                    Spacer(Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(color = MomentoTheme.colors.pinkW40, shape = CircleShape)
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