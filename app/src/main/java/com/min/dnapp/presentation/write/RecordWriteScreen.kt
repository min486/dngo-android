package com.min.dnapp.presentation.write

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.Calendar
import com.min.dnapp.presentation.ui.icon.appicons.Gallery
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.presentation.write.component.EmotionBottomSheetContent
import com.min.dnapp.presentation.write.component.WeatherBottomSheetContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordWriteScreen() {
    val radioOptions = listOf("국내", "해외 (직접 입력)")
    var selectedPlace by remember { mutableStateOf("국내") }
    var isChecked by remember { mutableStateOf(true) }
    var showEmotionBottomSheet by remember { mutableStateOf(false) }
    var showWeatherBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MomentoTheme.colors.brownW90,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "기록 작성하기",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MomentoTheme.colors.brownW90
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable {  }
                            .padding(16.dp),
                        imageVector = AppIcons.Back,
                        contentDescription = null
                    )
                },
                actions = {
                    Text(
                        modifier = Modifier
                            .clickable {  }
                            .padding(16.dp),
                        text = "완료",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Spacer(Modifier.height(20.dp))

                // 날짜
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = AppIcons.Calendar,
                        contentDescription = null,
                        tint = MomentoTheme.colors.brownBase
                    )
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = "2025년 12월 12일 ~ 2025년 12월 13일",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                }

                Spacer(Modifier.height(20.dp))

                // 감정 & 날씨
                Row {
                    Row(
                        modifier = Modifier.clickable { showEmotionBottomSheet = true },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "감정 태그",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.grayW20
                        )
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(color = MomentoTheme.colors.white, shape = RoundedCornerShape(5.dp))
                                .border(width = 1.dp, color = MomentoTheme.colors.pinkW60, shape = RoundedCornerShape(5.dp))
                                .padding(6.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.emotion_love),
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(Modifier.width(20.dp))
                    Row(
                        modifier = Modifier.clickable { showWeatherBottomSheet = true },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "날씨",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.grayW20
                        )
                        Spacer(Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(color = MomentoTheme.colors.white, shape = RoundedCornerShape(5.dp))
                                .border(width = 1.dp, color = MomentoTheme.colors.pinkW60, shape = RoundedCornerShape(5.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.weather_cloud),
                                contentDescription = null
                            )
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))

                // 제목
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(color = MomentoTheme.colors.brownBg, shape = RoundedCornerShape(5.dp))
                )

                Spacer(Modifier.height(20.dp))

                // 여행지
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "어디로 다녀오셨나요?",
                            style = MomentoTheme.typography.body01,
                            color = MomentoTheme.colors.grayW20
                        )

                        // 라디오 버튼
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            radioOptions.forEachIndexed { idx, text ->
                                RadioButton(
                                    modifier = Modifier.size(24.dp),
                                    selected = (text == selectedPlace),
                                    onClick = { selectedPlace = text },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = MomentoTheme.colors.greenW20,
                                        unselectedColor = MomentoTheme.colors.grayW80,
                                        disabledSelectedColor = MomentoTheme.colors.white
                                    )
                                )
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = text,
                                    style = MomentoTheme.typography.body03,
                                    color = MomentoTheme.colors.grayW20
                                )
                                if (idx == 0) {
                                    Spacer(Modifier.width(12.dp))
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.write_place),
                            contentDescription = null
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = "위치 추가",
                            style = MomentoTheme.typography.body02,
                            color = MomentoTheme.colors.grayW40
                        )
                    }
                }

                Spacer(Modifier.height(40.dp))

                // 내용
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "이번 여행에 대해 소개해주세요.",
                        style = MomentoTheme.typography.body01,
                        color = MomentoTheme.colors.grayW20
                    )
                    Spacer(Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(310.dp)
                            .background(color = MomentoTheme.colors.brownBg)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MomentoTheme.colors.white),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .clickable {  }
                        .padding(20.dp),
                    imageVector = AppIcons.Gallery,
                    contentDescription = null,
                    tint = MomentoTheme.colors.grayW60
                )

                Row(
                    modifier = Modifier.padding(end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "공유 여부",
                        style = MomentoTheme.typography.body01,
                        color = MomentoTheme.colors.grayW20
                    )
                    Spacer(Modifier.width(8.dp))
                    Switch(
                        // 기본 크기의 80%로 축소
                        modifier = Modifier.scale(0.8f),
                        checked = isChecked,
                        onCheckedChange = { newChecked ->
                            isChecked = newChecked
                        },
                        thumbContent = { FixedSizeThumbBox() },
                        colors = SwitchDefaults.colors(
                            // on - switch 배경 색
                            checkedTrackColor = MomentoTheme.colors.greenW20,
                            // off - switch 배경 색
                            uncheckedTrackColor = MomentoTheme.colors.grayW80,
                            // off - switch 테두리 색
                            uncheckedBorderColor = Color.Transparent,
                            // off - thumb 테두리 색
                            uncheckedThumbColor = MomentoTheme.colors.white
                        )
                    )
                }
            }
        }
    }

    // 감정 선택 바텀시트
    if (showEmotionBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showEmotionBottomSheet = false },
            dragHandle = null,
            containerColor = MomentoTheme.colors.white,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            EmotionBottomSheetContent(
                onConfirm = { showEmotionBottomSheet = false }
            )
        }
    }

    // 날씨 선택 바텀시트
    if (showWeatherBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showWeatherBottomSheet = false },
            dragHandle = null,
            containerColor = MomentoTheme.colors.white,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            WeatherBottomSheetContent (
                onConfirm = { showWeatherBottomSheet = false }
            )
        }
    }
}

@Composable
fun FixedSizeThumbBox() {
    Box(
        modifier = Modifier
            .size(SwitchDefaults.IconSize)
            .background(color = MomentoTheme.colors.white, shape = CircleShape)
    )
}

@Preview
@Composable
fun RecordWriteScreenPreview() {
    DngoTheme {
        RecordWriteScreen()
    }
}
