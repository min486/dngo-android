package com.min.dnapp.presentation.mypage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun ProfileImageDialog(
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "프로필을 선택해주세요!",
                    style = MomentoTheme.typography.title01,
                    color = MomentoTheme.colors.grayW20
                )

                Spacer(Modifier.height(20.dp))

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
                    Box(
                        modifier = Modifier
                            .border(width = 3.dp, color = MomentoTheme.colors.pinkBase, shape = RoundedCornerShape(10.dp))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logo_profile6),
                            contentDescription = null
                        )
                    }

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

                Spacer(Modifier.height(24.dp))

                // 취소/확인 버튼 영역
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .clickable { onCancel() }
                            .weight(1f)
                            .background(color = MomentoTheme.colors.grayW80, shape = RoundedCornerShape(10.dp))
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "취소",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.white
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .clickable { onConfirm() }
                            .weight(1f)
                            .background(color = MomentoTheme.colors.brownBase, shape = RoundedCornerShape(10.dp))
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "확인",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.white
                        )
                    }
                }
            }
        }
    }
}
