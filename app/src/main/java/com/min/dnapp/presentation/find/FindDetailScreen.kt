package com.min.dnapp.presentation.find

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.min.dnapp.R
import com.min.dnapp.presentation.find.component.SharedRecordContentSection
import com.min.dnapp.presentation.find.component.SharedRecordTimeSection
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.More
import com.min.dnapp.presentation.ui.icon.appicons.RecordBest
import com.min.dnapp.presentation.ui.icon.appicons.RecordBookmark
import com.min.dnapp.presentation.ui.icon.appicons.RecordComment
import com.min.dnapp.presentation.ui.icon.appicons.RecordLike
import com.min.dnapp.presentation.ui.icon.appicons.RecordSurprise
import com.min.dnapp.presentation.ui.profile.ProfileImageCircle
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindDetailScreen(navController: NavHostController) {
    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "상세 보기",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MomentoTheme.colors.brownBg
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { navController.popBackStack() }
                            .padding(16.dp),
                        imageVector = AppIcons.Back,
                        contentDescription = null,
                        tint = MomentoTheme.colors.grayW20
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 기록 내용 영역
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    // 프로필 이미지
                    ProfileImageCircle(modifier = Modifier.size(36.dp))

                    Spacer(Modifier.width(8.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        // 공유 경과시간 + 더보기 아이콘 영역
                        SharedRecordMoreSection()

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "시골청년님이 여행 기록을 공유했어요.",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.grayW20
                        )

                        Spacer(Modifier.height(8.dp))

                        // 기록 내용
                        SharedRecordContentSection()
                    }
                }
            }

            // 반응 이모지 영역
            item {
                HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW60)
                FindDetailReactionSection(
                    bestNum = 1,
                    likeNum = 2,
                    surpriseNum = 12,
                    commentNum = 2
                )
                HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW60)
            }

            // 댓글 목록 영역
            items(count = 5) {
                CommentItem()
            }
        }
    }
}

@Composable
fun SharedRecordMoreSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SharedRecordTimeSection()

        Icon(
            modifier = Modifier
                .clickable {  }
                .padding(start = 16.dp),
            imageVector = AppIcons.More,
            contentDescription = null,
            tint = MomentoTheme.colors.grayW20
        )
    }
}

@Composable
fun FindDetailReactionSection(
    bestNum: Int,
    likeNum: Int,
    surpriseNum: Int,
    commentNum: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordComment,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = commentNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.width(20.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordBest,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = bestNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.width(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordLike,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = likeNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }

            Spacer(Modifier.width(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = AppIcons.RecordSurprise,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = surpriseNum.toString(),
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }

        Icon(
            modifier = Modifier
                .clickable {  }
                .padding(16.dp),
            imageVector = AppIcons.RecordBookmark,
            contentDescription = null,
            tint = MomentoTheme.colors.grayW60
        )
    }
}

@Composable
fun CommentItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        // 프로필 이미지
        ProfileImageCircle(modifier = Modifier.size(24.dp))

        Spacer(Modifier.width(8.dp))

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "성민",
                    style = MomentoTheme.typography.body03,
                    color = MomentoTheme.colors.grayW20
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.badge_bronze),
                    contentDescription = null
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = "너무 예쁜데요??",
                style = MomentoTheme.typography.body02,
                color = MomentoTheme.colors.grayW20
            )

            Spacer(Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1시간 전",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "・",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW60
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "신고",
                    style = MomentoTheme.typography.label,
                    color = MomentoTheme.colors.grayW60
                )
            }
        }
    }
}

@Preview
@Composable
fun FindDetailScreenPreview() {
    DngoTheme {
//        FindDetailScreen()
    }
}
