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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.min.dnapp.presentation.mypage.NicknameValidationState
import com.min.dnapp.presentation.ui.theme.ErrorRed
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun NicknameUpdateDialog(
    state: NicknameValidationState,
    onValueChange: (String) -> Unit,
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
            ) {
                Text(
                    text = "닉네임",
                    style = MomentoTheme.typography.title02,
                    color = MomentoTheme.colors.grayW20
                )

                Spacer(Modifier.height(12.dp))

                // 닉네임 입력 영역
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .border(width = 1.dp, color = MomentoTheme.colors.grayW90, shape = RoundedCornerShape(5.dp))
                        .background(color = MomentoTheme.colors.white)
                        .padding(start = 12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (state.currentNickname.isEmpty()) {
                        Text(
                            text = "새 닉네임을 입력하세요.",
                            style = MomentoTheme.typography.body02,
                            color = MomentoTheme.colors.grayW60
                        )
                    }
                    BasicTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.currentNickname,
                        onValueChange = { newValue ->
                            onValueChange(newValue)
                        },
                        textStyle = MomentoTheme.typography.body02,
                        singleLine = true
                    )
                }

                // 에러메시지 표시
                if (state.errorMessage != null) {
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = state.errorMessage,
                        style = MomentoTheme.typography.body03,
                        color = ErrorRed
                    )
                }

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
                            .background(
                                color = if (state.isValid) MomentoTheme.colors.pinkBase else MomentoTheme.colors.grayW80,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "저장",
                            style = MomentoTheme.typography.body01,
                            color = if (state.isValid) MomentoTheme.colors.grayW20 else MomentoTheme.colors.white
                        )
                    }
                }
            }
        }
    }
}
