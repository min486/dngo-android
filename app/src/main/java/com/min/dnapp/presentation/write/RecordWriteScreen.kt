package com.min.dnapp.presentation.write

import android.util.Log
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.min.dnapp.R
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.Calendar
import com.min.dnapp.presentation.ui.icon.appicons.Gallery
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.presentation.write.component.EmotionBottomSheetContent
import com.min.dnapp.presentation.write.component.PlaceBottomSheetContent
import com.min.dnapp.presentation.write.component.WeatherBottomSheetContent
import com.min.dnapp.util.toLocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordWriteScreen(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchState by searchViewModel.searchState.collectAsStateWithLifecycle()
    val selectedPlace by searchViewModel.selectedPlace.collectAsStateWithLifecycle()
    val overseasPlace by searchViewModel.overseasPlace.collectAsStateWithLifecycle()

    var isChecked by remember { mutableStateOf(true) }
    var showEmotionBottomSheet by remember { mutableStateOf(false) }
    var showWeatherBottomSheet by remember { mutableStateOf(false) }

    // 캘린더
    var showDatePicker by remember { mutableStateOf(false) }
    val dateRangePickerState = rememberDateRangePickerState()

    // 여행지 - 위치 추가
    var showPlaceBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        // halfExpanded 상태 건너뛰기
        skipPartiallyExpanded = true
    )

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

                // 날짜 영역
                WriteDateSection(
                    startMillis = dateRangePickerState.selectedStartDateMillis,
                    endMillis = dateRangePickerState.selectedEndDateMillis,
                    onClick = { showDatePicker = true }
                )

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

                // 여행지 선택 영역
                PlaceSelectSection(
                    selectedPlace = selectedPlace,
                    overseasPlace = overseasPlace,
                    onValueChange = { newValue ->
                        searchViewModel.updateOverseas(newValue)
                    },
                    onClick = { showPlaceBottomSheet = true }
                )

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

    // 캘린더(날짜 선택) 모달
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = { showDatePicker = false }
                ) {
                    Text(
                        text = "확인",
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDatePicker = false }
                ) {
                    Text(
                        text = "취소"
                    )
                }
            },
            colors = DatePickerDefaults.colors(
                containerColor = MomentoTheme.colors.white
            )
        ) {
            DateRangePicker(
                state = dateRangePickerState,
                colors = DatePickerDefaults.colors(
                    containerColor = MomentoTheme.colors.white,
                    // 기간(시작일과 종료일 사이 공간)의 배경색
                    dayInSelectionRangeContainerColor = MomentoTheme.colors.brownW80
                ),
                // 펜 아이콘 숨기기 (캘린더 뷰와 텍스트 입력 뷰 전환 역할)
                showModeToggle = false,
                title = {
                    Box(
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                    ) {
                        Text(
                            text = "여행 날짜 선택",
                            style = MomentoTheme.typography.title02,
                            color = MomentoTheme.colors.grayW20
                        )
                    }
                },
                headline = {
                    Box(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        CustomDateRangeHeadline(
                            startDateMillis = dateRangePickerState.selectedStartDateMillis,
                            endDateMillis = dateRangePickerState.selectedEndDateMillis
                        )
                    }
                }
            )
        }
    }

    // 위치 추가 바텀시트
    if (showPlaceBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showPlaceBottomSheet = false },
            sheetState = sheetState,
            dragHandle = null,
            containerColor = MomentoTheme.colors.white,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            PlaceBottomSheetContent(
                value = searchState.query,
                places = searchState.places,
                onValueChange = { newValue ->
                    Log.e("naver", "newValue : $newValue")
                    searchViewModel.updateQuery(newValue)
                },
                onSearch = { searchViewModel.searchPlace() },
                onClear = { searchViewModel.clearSearchResult() },
                onConfirm = { place ->
                    searchViewModel.selectPlace(place)
                    showPlaceBottomSheet = false
                },
            )
        }
    }
}

@Composable
fun WriteDateSection(
    startMillis: Long?,
    endMillis: Long?,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = AppIcons.Calendar,
            contentDescription = null,
            tint = MomentoTheme.colors.brownBase
        )
        Spacer(Modifier.width(10.dp))

        when {
            // 날짜 선택되지 않은 경우
            startMillis == null -> {
                Text(
                    text = "날짜 선택",
                    style = MomentoTheme.typography.title02,
                    color = MomentoTheme.colors.grayW40
                )
            }

            // 시작일만 선택된 경우 or 시작일과 종료일이 같은 날짜에 선택된 경우
            endMillis == null || startMillis == endMillis -> {
                val startDate = startMillis.toLocalDate()

                Text(
                    text = "${startDate?.year}년 ${startDate?.monthValue}월 ${startDate?.dayOfMonth}일",
                    style = MomentoTheme.typography.title02,
                    color = MomentoTheme.colors.grayW20
                )
            }

            // 시작일과 종료일 모두 선택된 경우 (다른 날짜)
            else -> {
                val startDate = startMillis.toLocalDate()
                val endDate = endMillis.toLocalDate()

                Text(
                    text = "${startDate?.year}년 ${startDate?.monthValue}월 ${startDate?.dayOfMonth}일 ~ ${endDate?.year}년 ${endDate?.monthValue}월 ${endDate?.dayOfMonth}일",
                    style = MomentoTheme.typography.title02,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }
    }
}

@Composable
fun CustomDateRangeHeadline(
    startDateMillis: Long?,
    endDateMillis: Long?
) {
    if (startDateMillis == null) {
        Text(
            text = "날짜를 선택해주세요",
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW40
        )
    } else {
        val startDate = startDateMillis.toLocalDate()

        if (endDateMillis == null || startDateMillis == endDateMillis) {
            // 시작일만 선택된 경우 or 시작일과 종료일이 같은 날짜에 선택된 경우
            Text(
                text = "${startDate?.year}년 ${startDate?.monthValue}월 ${startDate?.dayOfMonth}일",
                style = MomentoTheme.typography.body02,
                color = MomentoTheme.colors.grayW20
            )
        } else {
            // 시작일과 종료일 모두 선택된 경우 (다른 날짜)
            val endDate = endDateMillis.toLocalDate()

            Row {
                Text(
                    text = "${startDate?.year}년 ${startDate?.monthValue}월 ${startDate?.dayOfMonth}일",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20
                )
                Text(
                    text = " ~ ",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20
                )
                Text(
                    text = "${endDate?.year}년 ${endDate?.monthValue}월 ${endDate?.dayOfMonth}일",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }
    }
}

@Composable
fun PlaceSelectSection(
    selectedPlace: LocalPlace?,
    overseasPlace: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
) {
    val radioOptions = listOf("국내", "해외 (직접 입력)")
    var selectedCountry by remember { mutableStateOf("국내") }

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
                        selected = (text == selectedCountry),
                        onClick = { selectedCountry = text },
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

        if (selectedCountry == "국내") {
            Row(
                modifier = Modifier.clickable { onClick() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.write_place),
                    contentDescription = null
                )
                Spacer(Modifier.width(6.dp))
                if (selectedPlace == null) {
                    Text(
                        text = "위치 추가",
                        style = MomentoTheme.typography.body02,
                        color = MomentoTheme.colors.grayW40
                    )
                } else {
                    Text(
                        text = selectedPlace.title,
                        style = MomentoTheme.typography.body02,
                        color = MomentoTheme.colors.grayW20
                    )
                }
            }
        } else {
            // 해외
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(color = MomentoTheme.colors.brownBg, shape = RoundedCornerShape(5.dp))
                    .padding(start = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (overseasPlace.isEmpty()) {
                    Text(
                        text = "예) 도쿄, 발리",
                        style = MomentoTheme.typography.body02,
                        color = MomentoTheme.colors.grayW60
                    )
                }
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = overseasPlace,
                    onValueChange = onValueChange,
                    textStyle = MomentoTheme.typography.body02,
                    singleLine = true
                )
            }
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
