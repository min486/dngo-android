package com.min.dnapp.presentation.mypage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun UserRemoveDialog(
    onDismiss: () -> Unit,
    onCancel: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            color = MomentoTheme.colors.brownBg
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "정말 탈퇴하시겠어요?",
                    style = MomentoTheme.typography.title01,
                    color = MomentoTheme.colors.grayW20
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "회원탈퇴 후 계정 복구가 불가능합니다. \n탈퇴하시겠습니까?",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20,
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.height(20.dp))

                // 버튼 영역
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .clickable { onCancel() }
                            .weight(1f)
                            .background(color = MomentoTheme.colors.white)
                            .border(width = 1.dp, color = MomentoTheme.colors.grayW60, shape = RoundedCornerShape(5.dp))
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "취소",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.grayW20
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    Box(
                        modifier = Modifier
                            .clickable { onConfirm() }
                            .weight(1f)
                            .background(color = MomentoTheme.colors.brownBase, shape = RoundedCornerShape(5.dp))
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "탈퇴",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.white
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UserRemoveDialogPreview() {
    DngoTheme {
//        UserRemoveDialog()
    }
}
