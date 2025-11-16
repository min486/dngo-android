package com.min.dnapp.presentation.write

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.presentation.write.component.LevelUpDialog
import com.min.dnapp.presentation.write.component.WriteStampDialog

@Composable
fun WriteFinishScreen(
    navController: NavHostController,
    viewModel: CheckBadgeViewModel = hiltViewModel()
) {
    val currentDialogState by viewModel.dialogState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize(),
        color = MomentoTheme.colors.white
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(100.dp))
                Image(
                    painter = painterResource(R.drawable.write_finish),
                    contentDescription = null
                )
                Spacer(Modifier.height(40.dp))
                Text(
                    text = "여행 기록 작성이 완료되었어요.",
                    style = MomentoTheme.typography.title01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            // 버튼 영역
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("home") {
                                // 스택 모두 제거
                                popUpTo(navController.graph.id) { inclusive = true }
                            }
                        }
                        .fillMaxWidth()
                        .background(color = MomentoTheme.colors.brownBase, shape = RoundedCornerShape(10.dp))
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "홈으로",
                        style = MomentoTheme.typography.body01,
                        color = MomentoTheme.colors.white
                    )
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }

    when (currentDialogState) {
        is WriteFinishDialogState.BadgeDialog -> {
            val data = currentDialogState as WriteFinishDialogState.BadgeDialog

            LevelUpDialog(
                badge = data.badge,
                onDismiss = { viewModel.closeDialog() },
                onConfirm = { viewModel.closeDialog() },
            )
        }
        is WriteFinishDialogState.StampDialog -> {
            WriteStampDialog(
                onDismiss = { viewModel.closeDialog() },
                onConfirm = { viewModel.closeDialog() }
            )
        }
        is WriteFinishDialogState.Hidden -> {}
    }
}

@Preview
@Composable
fun WriteFinishScreenPreview() {
    DngoTheme {
//        WriteFinishScreen()
    }
}
