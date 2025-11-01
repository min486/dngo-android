package com.min.dnapp.presentation.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.min.dnapp.R
import com.min.dnapp.presentation.mypage.component.ProfileImageDialog
import com.min.dnapp.presentation.ui.component.UserBadge
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Bell
import com.min.dnapp.presentation.ui.icon.appicons.PenSmall
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MypageScreen(
    navController: NavHostController
) {
    var showProfileImageDialog by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MomentoTheme.colors.brownW90,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MomentoTheme.colors.brownW90
                ),
                navigationIcon = {
                    Image(
                        modifier = Modifier
                            .clickable {  }
                            .padding(16.dp),
                        painter = painterResource(R.drawable.logo_momento),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .clickable {  }
                            .padding(16.dp),
                        imageVector = AppIcons.Bell,
                        contentDescription = null,
                        tint = MomentoTheme.colors.grayW60
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(20.dp))

            MypageProfileSection(
                onClick = { showProfileImageDialog = true }
            )

            Spacer(Modifier.height(20.dp))

            HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.brownW60)

            Spacer(Modifier.height(20.dp))

            MypageMenuSection(
                onSettingClick = {
                    navController.navigate("setting")
                }
            )
        }
    }

    // 프로필이미지 수정 모달창
    if (showProfileImageDialog) {
        ProfileImageDialog(
            onDismiss = { showProfileImageDialog = false },
            onCancel = { showProfileImageDialog = false },
            onConfirm = {}
        )
    }
}

@Composable
fun MypageProfileSection(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 프로필 이미지 (수정 가능)
        UserProfileImage(
            onClick = { onClick() }
        )

        Spacer(Modifier.height(12.dp))

        // 뱃지
//        UserBadge()

        Spacer(Modifier.height(16.dp))

        // 닉네임
        Text(
            text = "성민",
            style = MomentoTheme.typography.title01,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(28.dp))

        // 기록/스탬프 개수
        RecordAndStampNum()
    }
}

@Composable
fun UserProfileImage(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .size(120.dp)
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .border(width = 2.dp, color = MomentoTheme.colors.grayW80, shape = RoundedCornerShape(10.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.logo_profile),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 12.dp, y = 12.dp)
                .size(28.dp)
                .background(color = MomentoTheme.colors.grayW90, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = AppIcons.PenSmall,
                contentDescription = null,
                tint = MomentoTheme.colors.grayW60
            )
        }
    }
}

@Composable
fun RecordAndStampNum() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        // 여행 기록 영역
        Box(
            modifier = Modifier
                .weight(1f)
                .background(color = MomentoTheme.colors.pinkW60, shape = RoundedCornerShape(10.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.my_record),
                        contentDescription = null
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "여행 기록",
                        style = MomentoTheme.typography.label,
                        color = MomentoTheme.colors.grayW20
                    )
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "10개",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW20,
                    textAlign = TextAlign.End
                )

                Spacer(Modifier.height(12.dp))
            }
        }

        Spacer(Modifier.width(16.dp))

        // 수집 스탬프 영역
        Box(
            modifier = Modifier
                .weight(1f)
                .background(color = MomentoTheme.colors.pinkW60, shape = RoundedCornerShape(10.dp))
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.my_stamp),
                        contentDescription = null
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "수집 스탬프",
                        style = MomentoTheme.typography.label,
                        color = MomentoTheme.colors.grayW20
                    )
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "0개",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW20,
                    textAlign = TextAlign.End
                )

                Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun MypageMenuSection(
    onSettingClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        MypageMenuItem(
            text = "내 기록 모아보기",
            onClick = {}
        )
        Spacer(Modifier.height(28.dp))
        MypageMenuItem(
            text = "북마크",
            onClick = {}
        )
        Spacer(Modifier.height(28.dp))
        MypageMenuItem(
            text = "설정",
            onClick = { onSettingClick() }
        )
    }
}

@Composable
fun MypageMenuItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            style = MomentoTheme.typography.body01,
            color = MomentoTheme.colors.grayW20
        )
    }
}

@Preview
@Composable
fun MypageScreenPreview() {
    DngoTheme {
//        MypageScreen()
    }
}
