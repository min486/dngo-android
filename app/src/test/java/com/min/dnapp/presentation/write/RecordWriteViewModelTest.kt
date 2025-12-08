package com.min.dnapp.presentation.write

import com.min.dnapp.domain.model.EmotionType
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.model.WeatherType
import com.min.dnapp.domain.usecase.LocalSearchUseCase
import com.min.dnapp.domain.usecase.SaveRecordUseCase
import com.min.dnapp.util.Resource
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class RecordWriteViewModelTest : FunSpec({

    lateinit var testDispatcher: TestDispatcher
    lateinit var localSearchUseCase: LocalSearchUseCase
    lateinit var saveRecordUseCase: SaveRecordUseCase
    lateinit var viewModel: RecordWriteViewModel

    beforeEach {
        testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)

        localSearchUseCase = mockk()
        saveRecordUseCase = mockk()
    }

    afterEach {
        Dispatchers.resetMain()
    }

    /**
     * 테스트 1: 제목 입력 테스트
     * 시나리오:
     * - 유저가 제목 입력
     * - UiState의 recordTitle이 업데이트되는지 확인
     */
    test("제목 입력 시 UiState의 recordTitle이 업데이트된다") {
        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        val testTitle = "제주도 여행"
        viewModel.updateTitle(testTitle)

        viewModel.uiState.value.recordTitle shouldBe testTitle
    }

    /**
     * 테스트 2: 날짜 범위 선택 테스트
     * 시나리오:
     * - 유저가 DatePicker에서 시작일과 종료일 선택
     * - 날짜가 UiState에 올바르게 저장되는지 확인
     */
    test("날짜 범위 선택 시 날짜가 UiState에 저장된다") {
        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        val startDateMillis = 1700000000000L
        val endDateMillis = 1700086400000L
        viewModel.updateDateRange(startDateMillis, endDateMillis)

        viewModel.uiState.value.selectedStartDateMillis shouldBe startDateMillis
        viewModel.uiState.value.selectedEndDateMillis shouldBe endDateMillis
    }

    /**
     * 테스트 3: 감정 선택 테스트
     * 시나리오:
     * - 유저가 감정 바텀시트에서 감정 선택
     * - 선택된 감정이 UiState에 저장되는지 확인
     */
    test("감정 선택 시 감정이 UiState에 저장된다") {
        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        val selectedEmotion = EmotionType.HAPPY
        viewModel.updateEmotion(selectedEmotion)

        viewModel.uiState.value.selectedEmotion shouldBe EmotionType.HAPPY
    }

    /**
     * 테스트 4: 날씨 선택 테스트
     * 시나리오:
     * - 유저가 날씨 바텀시트에서 날씨 선택
     * - 선택된 날씨가 UiState에 저장되는지 확인
     */
    test("날씨 선택 시 날씨가 UiState에 저장된다") {
        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        val selectedWeather = WeatherType.SUN
        viewModel.updateWeather(selectedWeather)

        viewModel.uiState.value.selectedWeather shouldBe WeatherType.SUN
    }

    /**
     * 테스트 5: 장소 검색 성공 테스트
     * 시나리오:
     * - 유저가 검색어 입력 후 검색 버튼 클릭
     * - LocalSearchUseCase가 검색 결과 반환
     * - UiState의 searchState에 결과가 저장되는지 확인
     */
    test("장소 검색 성공 시 검색 결과가 UiState에 저장된다") {
        val searchQuery = "광안리"
        val fakePlaces = listOf(
            LocalPlace(
                title = "광안리해수욕장",
                category = "해수욕장,해변",
                roadAddress = "부산광역시 수영구 광안해변로 219"
            ),
            LocalPlace(
                title = "광안리카페거리",
                category = "거리,골목",
                roadAddress = "부산 수영구 민락동 178-21"
            )
        )

        // Flow로 Resource를 순차적으로 발행 (Loading -> Success)
        val searchFlow = flowOf(
            Resource.Loading,
            Resource.Success(fakePlaces)
        )

        every { localSearchUseCase(searchQuery) } returns searchFlow

        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        // 검색어 입력 후 검색 실행
        viewModel.updateQuery(searchQuery)
        viewModel.searchPlace()

        // Flow의 모든 값이 수집될때까지 대기
        testDispatcher.scheduler.advanceUntilIdle()

        val searchState = viewModel.uiState.value.searchState

        searchState.isLoading shouldBe false
        searchState.places.size shouldBe 2
        searchState.places[0].title shouldBe "광안리해수욕장"
        searchState.error shouldBe null
    }

    /**
     * 테스트 6: 장소 검색 실패 테스트
     * 시나리오:
     * - 유저가 검색 실행
     * - 검색 실패
     * - 에러 메시지가 UiState에 저장되는지 확인
     */
    test("장소 검색 실패 시 에러 메시지가 저장된다") {
        val searchQuery = "없는장소"
        val errorMessage = "검색 결과가 없습니다"

        val searchFlow = flowOf(
            Resource.Loading,
            Resource.Error(errorMessage)
        )

        every { localSearchUseCase(searchQuery) } returns searchFlow

        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        viewModel.updateQuery(searchQuery)
        viewModel.searchPlace()
        testDispatcher.scheduler.advanceUntilIdle()

        val searchState = viewModel.uiState.value.searchState

        searchState.isLoading shouldBe false
        searchState.error shouldBe errorMessage
        searchState.places shouldBe emptyList()
    }

    /**
     * 테스트 7: 검색 결과에서 장소 선택 테스트
     * 시나리요:
     * - 검색 결과가 표시됨
     * - 유저가 특정 장소를 선택
     * - 선택된 장소가 UiState에 저장되는지 확인
     */
    test("검색 결과에서 장소 선택 시 UiState에 저장된다") {
        viewModel = RecordWriteViewModel(localSearchUseCase, saveRecordUseCase)

        val seletedPlace = LocalPlace(
            title = "광안리해수욕장",
            category = "해수욕장,해변",
            roadAddress = "부산광역시 수영구 광안해변로 219"
        )
        viewModel.updatePlace(seletedPlace)

        viewModel.uiState.value.selectedPlace shouldBe seletedPlace
        viewModel.uiState.value.selectedPlace?.title shouldBe "광안리해수욕장"
    }
})
