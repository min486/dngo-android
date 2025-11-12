package com.min.dnapp.presentation.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.min.dnapp.R
import com.min.dnapp.presentation.common.EmotionMapper
import com.min.dnapp.presentation.common.WeatherMapper
import com.min.dnapp.presentation.home.YearHeader
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.util.toDateString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRecordScreen(
    navController: NavHostController,
    myRecordViewModel: MyRecordViewModel = hiltViewModel()
) {
    val uiState by myRecordViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "내 기록 모아보기",
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

        when (uiState) {
            is MyRecordUiState.Loading -> {
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
            is MyRecordUiState.Error -> {}
            is MyRecordUiState.Success -> {
                // Success 데이터 추출
                val data = uiState as MyRecordUiState.Success

                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(horizontal = 20.dp)
                        .fillMaxSize()
                ) {
                    itemsIndexed(data.records) { idx, record ->

                        // 현재 항목의 년도
                        val currentYear = record.startDateMillis.toDateString("yyyy")

                        // 직전 항목의 년도와 비교
                        val previousYear = if (idx > 0) {
                            data.records[idx-1].startDateMillis.toDateString("yyyy")
                        } else {
                            null
                        }

                        // 년도별 첫번째 항목 여부 (1번째 항목인 경우 or 년도가 바뀌는 시점)
                        val isYearStart = (idx == 0) || (currentYear != previousYear)

                        // 년도 표시
                        if (isYearStart) {
                            Spacer(Modifier.height(20.dp))
                            YearHeader(year = currentYear)
                            Spacer(Modifier.height(12.dp))
                        }

                        // 날짜, 날씨+감정
                        MyRecordItemHeaderSection(
                            startDateMillis = record.startDateMillis,
                            endDateMillis = if (record.endDateMillis == 0L) null else record.endDateMillis,
                            weatherName = record.weatherKey,
                            emotionName = record.emotionKey,
                        )

                        Spacer(Modifier.height(8.dp))

                        // 내 기록 아이템
                        MyRecordItem(
                            title = record.title,
                            content = record.content,
                            placeName = record.selectedPlace?.title,
                            imageUrl = if (record.imageUrl.isEmpty()) null else record.imageUrl
                        )

                        Spacer(Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun MyRecordItemHeaderSection(
    startDateMillis: Long,
    endDateMillis: Long?,
    weatherName: String,
    emotionName: String,
) {
    val startDate = startDateMillis.toDateString("MM.dd")
    val endDate = endDateMillis?.toDateString("MM.dd")

    // 여행 날짜 텍스트 계산
    val dateText = endDate?.let { "$startDate ~ $it" } ?: startDate

    // 날씨 & 감정 이미지 리소스로 변환
    val weatherImageResId = WeatherMapper.getWeatherImageResId(weatherName)
    val emotionImageResId = EmotionMapper.getEmotionImageResId(emotionName)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 날짜 (08.20 ~ 08.22)
        Text(
            text = dateText,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW20
        )

        // 날씨 & 감정
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "날씨",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(weatherImageResId),
                    contentDescription = null
                )
            }

            Spacer(Modifier.width(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "감정",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(emotionImageResId),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun MyRecordItem(
    title: String,
    content: String,
    placeName: String?,
    imageUrl: String?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MomentoTheme.colors.brownW90)
            .padding(16.dp)
    ) {
        // 여행 제목
        Text(
            text = title,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(8.dp))

        HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.pinkBase)

        Spacer(Modifier.height(8.dp))

        // 여행 장소
        placeName?.let { place ->
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
                    style = MomentoTheme.typography.body03 ,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        // 여행 내용
        Text(
            text = content,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW20
        )

        // 여행 이미지
        imageUrl?.let { image ->
            Spacer(Modifier.height(8.dp))

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    // 가로:세로 비율 1:1
                    .aspectRatio(1f),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
