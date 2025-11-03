package com.min.dnapp.presentation.mypage.component

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.min.dnapp.presentation.mypage.ProfileImageType
import com.min.dnapp.presentation.ui.component.SelectButton
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun ProfileImageDialog(
    selectedImage: ProfileImageType?,
    onImageClick: (ProfileImageType) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    // 프로필 이미지 목록 (8개)
    val allImages = ProfileImageType.entries.toList()

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

                for (idx in 0 until allImages.size step 2) {

                    // 처음 Row가 아니면, Row 위에 간격 추가
                    if (idx > 0) {
                        Spacer(Modifier.height(16.dp))
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        ProfileImageItem(
                            profileImageType = allImages[idx],
                            isSelected = selectedImage == allImages[idx],
                            onClick = onImageClick
                        )
                        ProfileImageItem(
                            profileImageType = allImages[idx+1],
                            isSelected = selectedImage == allImages[idx+1],
                            onClick = onImageClick
                        )
                    }
                }

                Spacer(Modifier.height(24.dp))

                // 확인 버튼
                SelectButton(
                    enabled = selectedImage != null,
                    onConfirm = onConfirm
                )
            }
        }
    }
}

@Composable
fun ProfileImageItem(
    profileImageType: ProfileImageType,
    isSelected: Boolean,
    onClick: (ProfileImageType) -> Unit
) {
    val borderColor = if (isSelected) MomentoTheme.colors.pinkBase else Color.Transparent

    Box(
        modifier = Modifier
            .clickable { onClick(profileImageType) }
            .border(width = 3.dp, color = borderColor, shape = RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(profileImageType.resId),
            contentDescription = null
        )
    }
}
