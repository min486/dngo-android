package com.min.dnapp.presentation.bell

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BellScreen(navController: NavHostController) {
    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "알림",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    MomentoTheme.colors.brownBg
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { navController.popBackStack() }
                            .padding(16.dp),
                        imageVector = AppIcons.Back,
                        contentDescription = null
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
            HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW80)

//            BellCommentItem(
//                image = painterResource(R.drawable.trip),
//                nickname = "안녕하세요안녕하세요"
//            )
//
//            for (i in 0 until 3) {
//                BellCommentItem(
//                    image = painterResource(R.drawable.trip3),
//                    nickname = "박사과"
//                )
//            }
        }
    }
}

@Composable
fun BellCommentItem(
    image: Painter,
    nickname: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.bell_comment),
                contentDescription = null
            )

            Spacer(Modifier.width(8.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "2분 전",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW20
                )

                Text(
                    text = "$nickname 님이",
                    style = MomentoTheme.typography.body02 ,
                    color = MomentoTheme.colors.grayW20
                )
                Text(
                    text = "내 여행기록에 댓글을 달았어요.",
                    style = MomentoTheme.typography.body02 ,
                    color = MomentoTheme.colors.grayW20
                )

                Text(
                    text = "제주도 동쪽 투어!",
                    style = MomentoTheme.typography.caption,
                    color = MomentoTheme.colors.grayW40
                )
            }
        }

        Image(
            modifier = Modifier.size(56.dp),
            painter = image,
            contentDescription = null
        )
    }

    HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW80)
}

@Preview
@Composable
fun BellScreenPreview() {
    DngoTheme {
//        BellScreen()
    }
}
