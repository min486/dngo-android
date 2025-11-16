package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.Image
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.domain.model.EmotionType
import com.min.dnapp.presentation.ui.component.SelectButton
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun EmotionBottomSheetContent(
    onConfirm: (EmotionType) -> Unit
) {
    // 선택된 EmotionType 객체 저장
    var selectedEmotion by remember { mutableStateOf<EmotionType?>(null) }
    // emotion 선택 시 버튼 활성화
    val isButtonEnabled = selectedEmotion != null

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))

        Text(
            text = "기분은 어땠나요?",
            style = MomentoTheme.typography.title02,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(20.dp))

        HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW90)

        Spacer(Modifier.height(12.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // happy / love / surprise
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                EmotionItem(
                    emotionType = EmotionType.HAPPY,
                    isSelected = selectedEmotion == EmotionType.HAPPY,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
                EmotionItem(
                    emotionType = EmotionType.LOVE,
                    isSelected = selectedEmotion == EmotionType.LOVE,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
                EmotionItem(
                    emotionType = EmotionType.SURPRISE,
                    isSelected = selectedEmotion == EmotionType.SURPRISE,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
            }

            // angry / feel / sad
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                EmotionItem(
                    emotionType = EmotionType.ANGRY,
                    isSelected = selectedEmotion == EmotionType.ANGRY,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
                EmotionItem(
                    emotionType = EmotionType.FEEL,
                    isSelected = selectedEmotion == EmotionType.FEEL,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
                EmotionItem(
                    emotionType = EmotionType.SAD,
                    isSelected = selectedEmotion == EmotionType.SAD,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
            }

            // shine
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                EmotionItem(
                    emotionType = EmotionType.SHINE,
                    isSelected = selectedEmotion == EmotionType.SHINE,
                    onSelect = { emotionType -> selectedEmotion = emotionType }
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        // 선택 버튼
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            SelectButton(
                enabled = isButtonEnabled,
                onConfirm = {
                    selectedEmotion?.let(onConfirm)
                }
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun EmotionItem(
    emotionType: EmotionType,
    isSelected: Boolean,
    onSelect: (EmotionType) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.clickable {
                onSelect(emotionType)
            },
            painter = painterResource(emotionType.resId),
            contentDescription = null
        )
        if (isSelected) {
            Image(
                modifier = Modifier.size(52.dp),
                painter = painterResource(R.drawable.ew_check),
                contentDescription = null
            )
        }
    }
}
