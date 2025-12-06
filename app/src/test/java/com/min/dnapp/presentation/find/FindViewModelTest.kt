package com.min.dnapp.presentation.find

import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.domain.model.UserData
import com.min.dnapp.domain.usecase.GetSharedRecordUseCase
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class FindViewModelTest : FunSpec({

    lateinit var testDispatcher: TestDispatcher
    lateinit var getSharedUserCase: GetSharedRecordUseCase
    lateinit var viewModel: FindViewModel

    beforeEach {
        testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)

        getSharedUserCase = mockk()
    }

    afterEach {
        Dispatchers.resetMain()
    }

    test("공유된 기록 데이터 로드 성공 시 UiState가 Success 상태가 된다") {
        val fakeSharedRecords = listOf(
            TripRecord(
                userId = "user_1",
                userData = UserData(
                    badgeLv = 1,
                    nickname = "유저_1",
                    profileImageName = "profile_1",
                ),
                title = "제주도 여행",
                content = "제주도에서의 멋진 하루",
                startDateMillis = 1700000000000L,
                endDateMillis = 1700086400000L,
                emotionKey = "happy",
                weatherKey = "cloud",
                selectedPlace = LocalPlace(
                    title = "한라산",
                    category = "산",
                    roadAddress = "제주 서귀포시 토평동 산15-1"
                ),
                overseasPlace = "",
                isShareChecked = true,
                imageUrl = "",
                createdAt = System.currentTimeMillis()
            ),
            TripRecord(
                userId = "user_2",
                userData = UserData(
                    badgeLv = 2,
                    nickname = "유저_2",
                    profileImageName = "profile_2",
                ),
                title = "부산 여행",
                content = "부산에서의 멋진 하루",
                startDateMillis = 1700000000000L,
                endDateMillis = 1700086400000L,
                emotionKey = "happy",
                weatherKey = "cloud",
                selectedPlace = LocalPlace(
                    title = "광안리해수욕장",
                    category = "해수욕장,해변",
                    roadAddress = "부산광역시 수영구 광안해변로 219"
                ),
                overseasPlace = "",
                isShareChecked = true,
                imageUrl = "https://firebasestorage.googleapis.com/v0/b/dngo-2a086.firebasestorage.app/o/images%2FGvwFgO0zx4VkIeCBBaPw0WmGCm62%2F1762159948481_1000000740?alt=media&token=3c510698-7c22-4dbc-a400-f7504c52d888",
                createdAt = System.currentTimeMillis()
            )
        )

        coEvery { getSharedUserCase() } returns fakeSharedRecords

        viewModel = FindViewModel(getSharedUserCase)
        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value

        // Success 상태, 2개의 기록 있는지 확인
        uiState.shouldBeInstanceOf<FindUiState.Success>()
        uiState.records.size shouldBe 2

        uiState.records[0].title shouldBe "제주도 여행"
        uiState.records[0].isShareChecked shouldBe true
        uiState.records[0].userData?.nickname shouldBe "유저_1"
        uiState.records[1].title shouldBe "부산 여행"
        uiState.records[1].selectedPlace?.title shouldBe "광안리해수욕장"
    }

    test("데이터 로드 실패 시 빈 리스트와 함께 Success 상태가 된다") {
        coEvery { getSharedUserCase() } throws Exception("네트워크 연결 오류")

        viewModel = FindViewModel(getSharedUserCase)
        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value

        uiState.shouldBeInstanceOf<FindUiState.Success>()
        uiState.records shouldBe emptyList()
    }

    test("viewModel 초기화 시 Loading 상태로 시작한다") {
        coEvery { getSharedUserCase() } returns emptyList()

        viewModel = FindViewModel(getSharedUserCase)

        val uiState = viewModel.uiState.value

        uiState.shouldBeInstanceOf<FindUiState.Loading>()
    }
})
