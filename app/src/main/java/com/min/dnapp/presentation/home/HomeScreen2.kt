package com.min.dnapp.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.component.CustomFloatingActionButton
import com.min.dnapp.presentation.ui.component.UserBadge
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.ArrowRight
import com.min.dnapp.presentation.ui.icon.appicons.Bell
import com.min.dnapp.presentation.ui.icon.appicons.Year
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen2(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MomentoTheme.colors.brownW90,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    MomentoTheme.colors.brownW90
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
                            .clickable { navController.navigate("bell") }
                            .padding(16.dp),
                        imageVector = AppIcons.Bell,
                        contentDescription = null,
                        tint = MomentoTheme.colors.grayW60
                    )
                }
            )
        },
        floatingActionButton = {
            CustomFloatingActionButton(
                onClick = {
                    navController.navigate("record_write")
                }
            )
        }
    ) { paddingValues ->

        when (uiState) {
            is HomeUiState.Loading -> {
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
            is HomeUiState.Error -> {
                Log.e("home", "home 데이터 로드 실패")
            }
            is HomeUiState.Success -> {
                // Success 데이터 추출
                val data = uiState as HomeUiState.Success

                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    Spacer(Modifier.height(20.dp))

                    HomeHeaderSection(
                        nickname = data.nickname,
                        recordCnt = data.recordCnt,
                        stampCnt = data.stampCnt,
                        badgeName = data.badgeName,
                        badgeImageResId = data.badgeImageResId
                    )

                    Spacer(Modifier.height(20.dp))

                    // 여행 기록 영역
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MomentoTheme.colors.brownBg, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                            .padding(horizontal = 20.dp)
                    ) {
                        Spacer(Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "내 여행 기록",
                                style = MomentoTheme.typography.title02,
                                color = MomentoTheme.colors.grayW20
                            )
                            Icon(
                                modifier = Modifier.clickable {  },
                                imageVector = AppIcons.ArrowRight,
                                contentDescription = null,
                                tint = MomentoTheme.colors.grayW20
                            )
                        }

                        Spacer(Modifier.height(12.dp))

                        // 카드형 영역
                        HomeCardSection()

                        Spacer(Modifier.height(20.dp))

                        // 타임라인형 영역
                        TimelineSection()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeHeaderSection(
    nickname: String,
    recordCnt: Int,
    stampCnt: Int,
    badgeName: String,
    badgeImageResId: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal =  20.dp)
    ) {
        UserBadge(
            badgeName = badgeName,
            badgeImageResId = badgeImageResId
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = "$nickname 님,",
            style = MomentoTheme.typography.title02,
            color = MomentoTheme.colors.grayW20
        )
        Spacer(Modifier.height(4.dp))
        Text(
//            text = "이번 달엔 총0번 여행을 다녀왔어요!",
            text = "지금까지 총 ${recordCnt}번 여행을 다녀왔어요!",
            style = MomentoTheme.typography.body01,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(12.dp))

        // 스탬프 영역
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.my_stamp),
                contentDescription = null
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = "모은 스탬프 ${stampCnt}개",
                style = MomentoTheme.typography.label,
                color = MomentoTheme.colors.grayW20
            )
        }
    }
}

@Composable
fun HomeCardSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HomeCardImage(
            image = painterResource(R.drawable.trip),
            text = "제주특별자치도"
        )
        HomeCardNoImage()
        HomeCardImage(
            image = painterResource(R.drawable.trip2),
            text = "일본 도쿄"
        )
    }
}

@Composable
fun HomeCardImage(
    image: Painter,
    text: String
) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = image,
            contentDescription = null
        )
        // 이미지 어둡게 처리
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(color = Color.Black.copy(alpha = 0.3f))
        )
        Text(
            modifier = Modifier
                .width(88.dp)
                .padding(start = 12.dp),
            text = text,
            style = MomentoTheme.typography.label,
            color = MomentoTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun HomeCardNoImage() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = MomentoTheme.colors.greenW80)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.image_basic),
            contentDescription = null
        )
        Text(
            text = "제주특별자치도",
            style = MomentoTheme.typography.label,
            color = MomentoTheme.colors.grayW20,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun TimelineSection() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            TimelineYear(year = 2024)
        }
        item {
            TimelineYear(year = 2023)
        }
    }
}

@Composable
fun TimelineYear(
    year: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Icon(
                imageVector = AppIcons.Year,
                contentDescription = null,
                tint = MomentoTheme.colors.brownBase
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "${year}년",
                style = MomentoTheme.typography.title02,
                color = MomentoTheme.colors.grayW20
            )
        }

        Spacer(Modifier.height(12.dp))

        // 타임라인형 아이템
        TimelineItem(
            idx = 0,
            image = painterResource(R.drawable.trip),
            startDate = "07.25",
            endDate = "07.28",
            title = "제주도 동쪽 투어!",
            place = "제주특별자치도"
        )
        TimelineItem(
            idx = 1,
            image = painterResource(R.drawable.trip3),
            startDate = "03.05",
            endDate = "03.08",
            title = "너와 함께 한 시간 속",
            place = "부산광역시 수영구"
        )
        TimelineItem(
            idx = 2,
            image = painterResource(R.drawable.trip3),
            startDate = "01.05",
            endDate = "01.07",
            title = "신년맞이",
            place = "부산광역시 수영구"
        )
    }
}

@Composable
fun TimelineItem(
    idx: Int,
    image: Painter,
    startDate: String,
    endDate: String,
    title: String,
    place: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            HomeGrayLine(idx = idx)

            Spacer(Modifier.width(12.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "${startDate} ~ ${endDate}",
                    style = MomentoTheme.typography.body03,
                    color = MomentoTheme.colors.grayW20
                )
                Text(
                    text = title,
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.write_place),
                        contentDescription = null
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = place,
                        style = MomentoTheme.typography.body03,
                        color = MomentoTheme.colors.grayW20
                    )
                }
            }
        }

        Image(
            modifier = Modifier.size(90.dp),
            painter = image,
            contentDescription = null
        )
    }
}

@Composable
fun HomeGrayLine(
    idx: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (idx == 0) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(color = MomentoTheme.colors.grayW60, shape = CircleShape)
            )
        }
        VerticalDivider(modifier = Modifier.height(100.dp), thickness = 1.dp, color = MomentoTheme.colors.grayW60)
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(color = MomentoTheme.colors.grayW60, shape = CircleShape)
        )
    }
}

@Preview
@Composable
fun HomeScreen2Preview() {
    DngoTheme {
        HomeScreen2(
            navController = rememberNavController()
        )
    }
}
