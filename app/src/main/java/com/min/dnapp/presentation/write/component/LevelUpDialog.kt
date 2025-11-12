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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.min.dnapp.domain.model.Badge
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun LevelUpDialog(
    badge: Badge,
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
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = "${badge.name}가 된 것을 축하해요!",
                        style = MomentoTheme.typography.title01,
                        color = MomentoTheme.colors.grayW20
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "여행 기록 ${badge.minStamp}개 달성",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW60
                    )
                    Spacer(Modifier.height(20.dp))
                    Image(
                        modifier = Modifier.size(160.dp),
                        painter = painterResource(badge.resId),
                        contentDescription = null
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = badge.description,
                        style = MomentoTheme.typography.body01,
                        color = MomentoTheme.colors.grayW20
                    )
                    Spacer(Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .clickable { onConfirm() }
                            .fillMaxWidth()
                            .background(
                                color = MomentoTheme.colors.brownBase,
                                shape = RoundedCornerShape(10.dp)
                            )
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

                // Box 영역 전체 덮도록 설정
                LottieFireworksAnimation(
                    modifier = Modifier.matchParentSize()
                )
            }
        }
    }
}

@Composable
fun LottieFireworksAnimation(
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Asset("fireworks.json"))

    // 애니메이션 1번만 재생
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1,
        isPlaying = true,
        restartOnPlay = false
    )

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = progress
    )
}

@Preview
@Composable
fun LevelUpDialogPreview() {
    DngoTheme {
//        LevelUpDialog()
    }
}
