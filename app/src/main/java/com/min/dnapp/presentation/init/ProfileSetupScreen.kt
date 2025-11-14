package com.min.dnapp.presentation.init

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.min.dnapp.presentation.mypage.ProfileImageType
import com.min.dnapp.presentation.mypage.component.ProfileImageItem
import com.min.dnapp.presentation.ui.component.SelectButton
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSetupScreen(
    viewModel: AppInitViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    val selectedImage by viewModel.selectedImage.collectAsStateWithLifecycle()
    val saveImageState by viewModel.saveImageState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "프로필 설정",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MomentoTheme.colors.brownBg
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 프로필 이미지 목록 (8개)
            val allImages = ProfileImageType.entries.toList()

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                            onClick = { image -> viewModel.selectImage(image) }
                        )
                        ProfileImageItem(
                            profileImageType = allImages[idx+1],
                            isSelected = selectedImage == allImages[idx+1],
                            onClick = { image -> viewModel.selectImage(image) }
                        )
                    }
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    text = "원하는 프로필을 선택해주세요!",
                    style = MomentoTheme.typography.title01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            // 확인 버튼
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                SelectButton(
                    enabled = selectedImage != null,
                    onConfirm = { viewModel.saveProfileImage() }
                )
                Spacer(Modifier.height(20.dp))
            }
        }
    }

    when (saveImageState) {
        is SaveImageState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(40.dp),
                    color = MomentoTheme.colors.brownW20,
                    strokeWidth = 4.dp
                )
            }
        }
        is SaveImageState.Success -> { onFinish() }
        is SaveImageState.Error -> {}
        else -> {
            // Init 또는 Success
        }
    }
}

@Preview
@Composable
fun ProfileSelectScreenPreview() {
    DngoTheme {
//        ProfileSetupScreen()
    }
}
