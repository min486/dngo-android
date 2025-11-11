package com.min.dnapp.presentation.write.component

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
fun PlaceWarningDialog(
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
            color = MomentoTheme.colors.white
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(20.dp))

                Text(
                    text = "여행지를 변경하시겠어요?",
                    style = MomentoTheme.typography.title01,
                    color = MomentoTheme.colors.grayW20
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "해외 여행지를 입력하면 \n기존에 저장한 국내 여행지가 삭제됩니다.",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20,
                    textAlign = TextAlign.Center,
                )

                Spacer(Modifier.height(20.dp))

                // 취소/변경 버튼
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .clickable { onCancel() }
                            .weight(1f)
                            .background(color = MomentoTheme.colors.white)
                            .border(width = 1.dp, color = MomentoTheme.colors.grayW80, shape = RoundedCornerShape(5.dp))
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
                                color = MomentoTheme.colors.brownBase,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "변경",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.white
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
fun PlaceWarningDialogPreview() {
    DngoTheme {
//        PlaceWarningDialog()
    }
}
