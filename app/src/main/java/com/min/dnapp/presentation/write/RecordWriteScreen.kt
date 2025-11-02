package com.min.dnapp.presentation.write

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.min.dnapp.R
import com.min.dnapp.domain.model.EmotionType
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.model.WeatherType
import com.min.dnapp.presentation.ui.component.CustomSnackbar
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.Calendar
import com.min.dnapp.presentation.ui.icon.appicons.Gallery
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.presentation.write.component.EmotionBottomSheetContent
import com.min.dnapp.presentation.write.component.PlaceBottomSheetContent
import com.min.dnapp.presentation.write.component.ShareGuide
import com.min.dnapp.presentation.write.component.WeatherBottomSheetContent
import com.min.dnapp.util.toLocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordWriteScreen(
    navController: NavHostController,
    viewModel: RecordWriteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    val snackbarHostState = remember { SnackbarHostState() }

    // 공유 안내 말풍선 표시상태
    var isShareGuideVisible by remember { mutableStateOf(true) }

    // 캘린더 모달 표시상태
    var showDatePicker by remember { mutableStateOf(false) }

    var showEmotionBottomSheet by remember { mutableStateOf(false) }
    var showWeatherBottomSheet by remember { mutableStateOf(false) }

    // 여행지 추가 모달 표시상태
    var showPlaceBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        // halfExpanded 상태 건너뛰기
        skipPartiallyExpanded = true
    )

    // Photo Picker 런처 등록
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        // URI 결과 전달
        viewModel.onPhotoSelected(uri)

        // URI 접근권한 지속적으로 요청
        if (uri != null) {
            val flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            context.contentResolver.takePersistableUriPermission(uri, flags)
        }
    }

    // Photo Picker 실행 요청
    LaunchedEffect(viewModel.imageEvent) {
        viewModel.imageEvent.collect { shouldLaunch ->
            if (shouldLaunch) {
                // Photo Picker 실행
                singlePhotoPickerLauncher.launch(
                    input = PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
                // 이벤트 처리 후 viewModel에 알림
                viewModel.photoPickerEventHandled()
            }
        }
    }

    // 1회성 이벤트 Flow 수집 및 처리
    LaunchedEffect(Unit) {
        // 구독
        viewModel.completeSaveRecordFlow.collect {
            // 기록저장 성공 후 화면 이동
            navController.navigate("write_finish") {
                popUpTo("record_write") {
                    inclusive = true
                }
            }
        }
    }

    // 메시지 발행을 수집하여 스낵바 표시
    LaunchedEffect(Unit) {
        viewModel.snackbarMessage.collect { message ->
            snackbarHostState.showSnackbar(
                message = message.message,
                duration = SnackbarDuration.Short
            )
        }
    }

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
                            .clickable { navController.popBackStack() }
                            .padding(16.dp),
                        imageVector = AppIcons.Back,
                        contentDescription = null
                    )
                },
                actions = {
                    Text(
                        modifier = Modifier
                            .clickable {
                                viewModel.saveRecord()
                            }
                            .padding(16.dp),
                        text = "완료",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                // 공유 안내 말풍선
                if (isShareGuideVisible) {
                    ShareGuide(
                        onClick = { isShareGuideVisible = false }
                    )
                }

                // 이미지 아이콘 & 공유여부 스위치 영역
                ImageAndShareSection(
                    isChecked = uiState.isShareChecked,
                    onCheckedChange = { newChecked ->
                        viewModel.updateShare(newChecked)
                    },
                    onGalleryClick = { viewModel.onGalleryIconClicked() }
                )
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                CustomSnackbar(
                    snackbarData = data
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
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
                    startMillis = uiState.selectedStartDateMillis,
                    endMillis = uiState.selectedEndDateMillis,
                    onClick = { showDatePicker = true }
                )

                Spacer(Modifier.height(20.dp))

                // 감정 & 날씨 영역
                EmotionAndWeatherSection(
                    selectedEmotion = uiState.selectedEmotion,
                    selectedWeather = uiState.selectedWeather,
                    onClickEmotion = { showEmotionBottomSheet = true },
                    onClickWeather = { showWeatherBottomSheet = true }
                )

                Spacer(Modifier.height(20.dp))

                // 제목 영역
                WriteTitleSection(
                    recordTitle = uiState.recordTitle,
                    onValueChange = { newValue ->
                        viewModel.updateTitle(newValue)
                    }
                )

                Spacer(Modifier.height(20.dp))

                // 여행지 영역
                WritePlaceSection(
                    selectedPlace = uiState.selectedPlace,
                    overseasPlace = uiState.overseasPlace,
                    onValueChange = { newValue ->
                        viewModel.updateOverseas(newValue)
                    },
                    onClick = { showPlaceBottomSheet = true }
                )

                Spacer(Modifier.height(40.dp))

                // 내용 영역
                WriteContentSection(
                    selectedImageUri = uiState.selectedImageUri,
                    recordContent = uiState.recordContent,
                    onValueChange = { newValue ->
                        viewModel.updateContent(newValue)
                    }
                )
            }
        }
    }

    // 기록 등록 진행 시 로딩 인디케이터 표시
    if (uiState.isSaving) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MomentoTheme.colors.black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = MomentoTheme.colors.white,
                strokeWidth = 4.dp
            )
        }
    }

    // 캘린더 모달
    if (showDatePicker) {
        val dateRangePickerState = rememberDateRangePickerState(
            initialSelectedStartDateMillis = uiState.selectedStartDateMillis,
            initialSelectedEndDateMillis = uiState.selectedEndDateMillis
        )

        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val startMillis = dateRangePickerState.selectedStartDateMillis
                        val endMillis = dateRangePickerState.selectedEndDateMillis

                        viewModel.updateDateRange(
                            startDateMillis = startMillis,
                            endDateMillis = endMillis
                        )

                        showDatePicker = false
                    }
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

    // 감정 선택 바텀시트
    if (showEmotionBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showEmotionBottomSheet = false },
            dragHandle = null,
            containerColor = MomentoTheme.colors.white,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            EmotionBottomSheetContent(
                onConfirm = { emotionType ->
                    viewModel.updateEmotion(emotionType)
                    showEmotionBottomSheet = false
                }
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
                onConfirm = { weatherType ->
                    viewModel.updateWeather(weatherType)
                    showWeatherBottomSheet = false
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
                value = uiState.searchState.query,
                places = uiState.searchState.places,
                onValueChange = { newValue ->
                    viewModel.updateQuery(newValue)
                },
                onSearch = { viewModel.searchPlace() },
                onClear = { viewModel.clearSearchResult() },
                onConfirm = { place ->
                    viewModel.updatePlace(place)
                    showPlaceBottomSheet = false
                }
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
fun EmotionAndWeatherSection(
    selectedEmotion: EmotionType?,
    selectedWeather: WeatherType?,
    onClickEmotion: () -> Unit,
    onClickWeather: () -> Unit
) {
    Row {
        Row(
            modifier = Modifier.clickable { onClickEmotion() },
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
                    .border(width = 1.dp, color = MomentoTheme.colors.pinkW60, shape = RoundedCornerShape(5.dp)),
                contentAlignment = Alignment.Center
            ) {
                selectedEmotion?.let { emotionType ->
                    Image(
                        painter = painterResource(emotionType.resId),
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(Modifier.width(20.dp))
        Row(
            modifier = Modifier.clickable { onClickWeather() },
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
                selectedWeather?.let { weatherType ->
                    Image(
                        painter = painterResource(weatherType.resId),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun WritePlaceSection(
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
fun WriteTitleSection(
    recordTitle: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(color = MomentoTheme.colors.brownBg, shape = RoundedCornerShape(5.dp))
            .padding(start = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        if (recordTitle.isEmpty()) {
            Text(
                text = "제목",
                style = MomentoTheme.typography.body02,
                color = MomentoTheme.colors.grayW60
            )
        }
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = recordTitle,
            onValueChange = onValueChange,
            textStyle = MomentoTheme.typography.body02,
            singleLine = true
        )
    }
}

@Composable
fun WriteContentSection(
    selectedImageUri: Uri?,
    recordContent: String,
    onValueChange: (String) -> Unit
) {
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
                .height(300.dp)
                .background(color = MomentoTheme.colors.brownBg)
                .padding(16.dp)
        ) {
            if (recordContent.isEmpty()) {
                Text(
                    text = "내용",
                    style = MomentoTheme.typography.body02,
                    color = MomentoTheme.colors.grayW60
                )
            }
            BasicTextField(
                modifier = Modifier.fillMaxSize(),
                value = recordContent,
                onValueChange = onValueChange,
                textStyle = MomentoTheme.typography.body02,
                singleLine = false
            )
        }
        // 선택된 이미지
        selectedImageUri?.let { uri ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MomentoTheme.colors.brownBg)
                    .padding(start = 16.dp, bottom = 16.dp)
            ) {
                AsyncImage(
                    model = uri,
                    contentDescription = null,
                    modifier = Modifier.size(72.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun ImageAndShareSection(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onGalleryClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MomentoTheme.colors.white),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .clickable { onGalleryClick() }
                .padding(horizontal = 20.dp, vertical = 10.dp),
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
                onCheckedChange = onCheckedChange,
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
//        RecordWriteScreen()
    }
}
