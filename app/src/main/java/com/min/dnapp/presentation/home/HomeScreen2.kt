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
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.min.dnapp.R
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.presentation.ui.component.CustomFloatingActionButton
import com.min.dnapp.presentation.ui.component.UserBadge
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.ArrowRight
import com.min.dnapp.presentation.ui.icon.appicons.Bell
import com.min.dnapp.presentation.ui.icon.appicons.Year
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.util.toDateString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen2(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
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
//                            .clickable {  }
//                            .padding(16.dp),
                            .padding(start = 16.dp),
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
                        badgeLv = data.badgeLv,
                        badgeName = data.badgeName,
                        recordCnt = data.recordCnt,
                        stampCnt = data.stampCnt
                    )

                    Spacer(Modifier.height(20.dp))

                    // 여행 기록 영역 (카드형 + 타임라인형)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
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
                                modifier = Modifier.clickable {
                                    navController.navigate("my_record")
                                },
                                imageVector = AppIcons.ArrowRight,
                                contentDescription = null,
                                tint = MomentoTheme.colors.grayW20
                            )
                        }

                        Spacer(Modifier.height(12.dp))

                        if (data.records.isEmpty()) {
                            // 기록 없는 경우
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(Modifier.height(20.dp))
                                Image(
                                    painter = painterResource(R.drawable.record_empty),
                                    contentDescription = null
                                )
                                Spacer(Modifier.height(12.dp))
                                Text(
                                    text = "아직 기록이 없네요. \n첫 여행을 기록해보세요!",
                                    style = MomentoTheme.typography.title01,
                                    color = MomentoTheme.colors.grayW20,
                                    textAlign = TextAlign.Center
                                )
                            }
                        } else {
                            // 카드형 영역
                            HomeCardSection(records = data.records)

                            Spacer(Modifier.height(20.dp))

                            // 타임라인형 영역
                            TimelineSection(records = data.records)
                        }
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
    badgeLv: Int,
    badgeName: String,
//    badgeImageResId: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal =  20.dp)
    ) {
        UserBadge(
            badgeLv = badgeLv,
            badgeName = badgeName,
//            badgeImageResId = badgeImageResId
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
fun HomeCardSection(
    records: List<TripRecord>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(records) { record ->
            if (record.imageUrl.isEmpty()) {
                HomeCardNoImage(record = record)
            } else {
                HomeCardImage(record = record)
            }
        }
    }
}

@Composable
fun HomeCardNoImage(
    record: TripRecord
) {
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
        record.selectedPlace?.let { selectedPlace ->
            Text(
                text = selectedPlace.title,
                style = MomentoTheme.typography.label,
                color = MomentoTheme.colors.grayW20,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun HomeCardImage(
    record: TripRecord
) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.size(100.dp),
            model = record.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        // 이미지 어둡게 처리
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(color = Color.Black.copy(alpha = 0.3f))
        )

        record.selectedPlace?.let { selectedPlace ->
            Text(
                modifier = Modifier
                    .width(88.dp)
                    .padding(start = 12.dp),
                text = selectedPlace.title,
                style = MomentoTheme.typography.label,
                color = MomentoTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun TimelineSection(
    records: List<TripRecord>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
    ) {
        itemsIndexed(records) { idx, record ->
            // 현재 항목의 년도
            val currentYear = record.startDateMillis.toDateString("yyyy")
            Log.d("home", "toDateString - currentYear: $currentYear")

            // 직전 항목의 년도와 비교
            val previousYear = if (idx > 0) {
                records[idx-1].startDateMillis.toDateString("yyyy")
            } else {
                null
            }

            // 년도별 첫번째 항목 여부
            val isYearStart = (idx == 0) || (currentYear != previousYear)

            // 1번째 항목인 경우 or 년도가 바뀌는 시점에 년도 표시
            if (idx == 0 || currentYear != previousYear) {
                if (idx != 0) {
                    Spacer(Modifier.height(20.dp))
                }
                YearHeader(year = currentYear)
                Spacer(Modifier.height(12.dp))
            }

            TimelineItem(
                isYearStart = isYearStart,
                startDateMillis = record.startDateMillis,
                endDateMillis = if (record.endDateMillis == 0L) null else record.endDateMillis,
                imageUrl = if (record.imageUrl.isEmpty()) null else record.imageUrl,
                title = record.title,
                placeName = record.selectedPlace?.title
            )
        }

        item {
            Spacer(Modifier.height(20.dp))
        }
    }
}

@Composable
fun YearHeader(
    year: String
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
}

@Composable
fun TimelineItem(
    isYearStart: Boolean,
    startDateMillis: Long,
    endDateMillis: Long?,
    title: String,
    placeName: String?,
    imageUrl: String?
) {
    // 월.일 추출 (예: 07.25)
    val startDate = startDateMillis.toDateString("MM.dd")
    val endDate = endDateMillis?.toDateString("MM.dd")

    // 여행 날짜 텍스트 계산
    val dateText = endDate?.let { "$startDate ~ $endDate" } ?: startDate

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            HomeGrayLine(isYearStart = isYearStart)

            Spacer(Modifier.width(12.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Spacer(Modifier.height(4.dp))
                Text(
                    text = dateText,
                    style = MomentoTheme.typography.body03,
                    color = MomentoTheme.colors.grayW20
                )
                Text(
                    text = title,
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.write_place),
                        contentDescription = null
                    )
                    Spacer(Modifier.width(6.dp))
                    placeName?.let { place ->
                        Text(
                            text = place,
                            style = MomentoTheme.typography.body03,
                            color = MomentoTheme.colors.grayW20
                        )
                    }
                }
            }
        }

        imageUrl?.let { image ->
            AsyncImage(
                modifier = Modifier.size(90.dp),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun HomeGrayLine(
    isYearStart: Boolean
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isYearStart) {
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
