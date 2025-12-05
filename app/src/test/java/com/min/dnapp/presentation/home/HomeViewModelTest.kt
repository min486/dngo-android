package com.min.dnapp.presentation.home

import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.domain.model.User
import com.min.dnapp.domain.usecase.GetCurrentUserIdUseCase
import com.min.dnapp.domain.usecase.GetUserDataUseCase
import com.min.dnapp.domain.usecase.GetUserRecordUseCase
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
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
class HomeViewModelTest : FunSpec({

    lateinit var testDispatcher: TestDispatcher
    lateinit var getCurrentUserIdUseCase: GetCurrentUserIdUseCase
    lateinit var getUserDataUseCase: GetUserDataUseCase
    lateinit var getUserRecordUseCase: GetUserRecordUseCase
    lateinit var viewModel: HomeViewModel

    beforeEach {
        // 각 테스트마다 새로운 인스턴스 생성
        testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)

        getCurrentUserIdUseCase = mockk()
        getUserDataUseCase = mockk()
        getUserRecordUseCase = mockk()
    }

    afterEach {
        Dispatchers.resetMain()
    }

    test("홈 데이터 로드 성공 시 UiState가 Success 상태가 된다") {
        val fakeUid = "uid_123"
        val fakeUser = User(
            userId = fakeUid,
            nickname = "user_123",
            profileImageName = "profile_123",
            badgeLv = 1,
            badgeName = "새내기",
            recordCnt = 3,
            stampCnt = 5,
            createdAt = System.currentTimeMillis()
        )
        val fakeRecords = emptyList<TripRecord>()

        coEvery { getCurrentUserIdUseCase() } returns fakeUid
        coEvery { getUserDataUseCase(fakeUid) } returns fakeUser
        coEvery { getUserRecordUseCase() } returns fakeRecords

        viewModel = HomeViewModel(
            getUserDataUseCase,
            getCurrentUserIdUseCase,
            getUserRecordUseCase
        )

        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value

        uiState.shouldBeInstanceOf<HomeUiState.Success>()

        uiState.nickname shouldBe "user_123"
        uiState.recordCnt shouldBe 3
        uiState.records shouldBe fakeRecords
    }

    test("유저 ID가 없을 경우 UiState가 Error 상태가 된다") {
        coEvery { getCurrentUserIdUseCase() } returns null

        viewModel = HomeViewModel(
            getUserDataUseCase,
            getCurrentUserIdUseCase,
            getUserRecordUseCase
        )

        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value

        uiState.shouldBeInstanceOf<HomeUiState.Error>()

        uiState.message shouldBe "인증 정보 로드 실패: 사용자 인증 정보 없음"
    }

    test("유저 데이터 로드 실패 시 UiState가 Error 상태가 된다") {
        val fakeUid = "uid_123"
        coEvery { getCurrentUserIdUseCase() } returns fakeUid
        coEvery { getUserDataUseCase(fakeUid) } throws Exception("DB 연결 오류")

        viewModel = HomeViewModel(
            getUserDataUseCase,
            getCurrentUserIdUseCase,
            getUserRecordUseCase
        )

        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.uiState.value

        uiState.shouldBeInstanceOf<HomeUiState.Error>()

        uiState.message shouldContain "DB 연결 오류"
    }
})
