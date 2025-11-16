package com.min.dnapp.presentation.write

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.model.EmotionType
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.model.WeatherType
import com.min.dnapp.domain.usecase.LocalSearchUseCase
import com.min.dnapp.domain.usecase.SaveRecordUseCase
import com.min.dnapp.presentation.common.SnackbarMessage
import com.min.dnapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordWriteViewModel @Inject constructor(
    private val localSearchUseCase: LocalSearchUseCase,
    private val saveRecordUseCase: SaveRecordUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecordWriteUiState())
    val uiState: StateFlow<RecordWriteUiState> = _uiState.asStateFlow()

    // Photo Picker를 실행하도록 요청하는 이벤트
    private val _imageEvent = MutableStateFlow(false)
    val imageEvent: StateFlow<Boolean> = _imageEvent.asStateFlow()

    private val _completeSaveRecord = Channel<Unit>()
    val completeSaveRecordFlow = _completeSaveRecord.receiveAsFlow()

    private val _snackbarMessage = MutableSharedFlow<SnackbarMessage>()
    val snackbarMessage = _snackbarMessage.asSharedFlow()

    // 이전 검색 작업을 취소하기 위한 Job
    private var searchJob: Job? = null

//    init {
//        searchPlace("광안리해수욕장")
//    }

    /**
     * 제목 - textField의 입력 값 업데이트
     */
    fun updateTitle(newText: String) {
        _uiState.value = _uiState.value.copy(recordTitle = newText)
        Log.d("write", "updateTitle - newText : $newText")
    }

    /**
     * 내용 - textField의 입력 값 업데이트
     */
    fun updateContent(newText: String) {
        _uiState.value = _uiState.value.copy(recordContent = newText)
        Log.d("write", "updateContent - newText : $newText")
    }

    /**
     * 선택된 출발일과 도착일을 동시에 업데이트
     */
    fun updateDateRange(startDateMillis: Long?, endDateMillis: Long?) {
        _uiState.value = _uiState.value.copy(
            selectedStartDateMillis = startDateMillis,
            selectedEndDateMillis = endDateMillis
        )
    }

    /**
     * 선택된 감정 업데이트
     */
    fun updateEmotion(emotionType: EmotionType) {
        _uiState.value = _uiState.value.copy(selectedEmotion = emotionType)
        Log.d("write", "selectEmotion - emotionType : $emotionType")
    }

    /**
     * 선택된 날씨 업데이트
     */
    fun updateWeather(weatherType: WeatherType) {
        _uiState.value = _uiState.value.copy(selectedWeather = weatherType)
        Log.d("write", "selectWeather - weatherType : $weatherType")
    }

    /**
     * textField의 입력 값만 업데이트하고, 검색 API 호출은 생략
     */
    fun updateQuery(newQuery: String) {
        _uiState.value = _uiState.value.copy(searchState = _uiState.value.searchState.copy(query = newQuery))

        // 검색어가 빈 경우 목록 지우기
        if (newQuery.isBlank()) {
            // 진행중인 검색 작업 취소
            searchJob?.cancel()
            Log.d("naver", "updateQuery - newQuery blank")
        }
    }

    /**
     * 검색 버튼 클릭 시, 검색 API 호출
     */
    fun searchPlace() {
        val currentQuery = _uiState.value.searchState.query

        // 검색어가 빈 경우
        if (currentQuery.isBlank()) {
            Log.d("naver", "searchPlace - newQuery blank")
            return
        }

        // 진행중인(이전 검색) 작업이 있으면 취소
        searchJob?.cancel()

        // Flow 수집 및 상태 업데이트 시작
        searchJob = localSearchUseCase(currentQuery)
            .onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        // 로딩 시작
                        _uiState.value = _uiState.value.copy(searchState = _uiState.value.searchState.copy(
                            isLoading = true,
                            places = result.data ?: emptyList(),
                            error = null
                        ))
                        Log.d("naver", "search for $currentQuery : Loading...")
                    }
                    is Resource.Success -> {
                        // 성공
                        _uiState.value = _uiState.value.copy(searchState = _uiState.value.searchState.copy(
                            isLoading = false,
                            places = result.data ?: emptyList(),
                            error = null
                        ))
                        Log.d("naver", "search success : ${result.data?.size} 개")
                    }
                    is Resource.Error -> {
                        // 에러
                        _uiState.value = _uiState.value.copy(searchState = _uiState.value.searchState.copy(
                            isLoading = false,
                            places = result.data ?: emptyList(),
                            error = result.message ?: "알 수 없는 에러 발생"
                        ))
                        Log.e("naver", "search error : ${result.message}")
                    }
                }
            }
            // viewModelScope에서 flow를 실행
            .launchIn(viewModelScope)
    }

    /**
     * 검색 결과 목록 초기화
     * (textField에 포커스가 잡히거나, 새 검색 시작할 때 사용)
     */
    fun clearSearchResult() {
        searchJob?.cancel()

        // query는 그대로 유지, 결과 목록만 초기화
        _uiState.value = _uiState.value.copy(searchState = _uiState.value.searchState.copy(
            isLoading = false,
            places = emptyList(),
            error = null
        ))
        Log.d("naver", "result cleared")
    }

    /**
     * 국내 - 선택된 장소 업데이트
     */
    fun updatePlace(place: LocalPlace) {
        _uiState.value = _uiState.value.copy(selectedPlace = place)
    }

    /**
     * 해외 - textField의 입력 값 업데이트
     */
    fun updateOverseas(newText: String) {
        _uiState.value = _uiState.value.copy(overseasPlace = newText)
        Log.d("write", "updateOverseas - newText : $newText")
    }

    /**
     * 공유여부 설정 상태 업데이트
     */
    fun updateShare(newChecked: Boolean) {
        _uiState.value = _uiState.value.copy(isShareChecked = newChecked)
        Log.d("write", "updateShare - newChecked : $newChecked")
    }

    /**
     * 갤러리 아이콘 클릭 - Photo Picker 실행 요청
     */
    fun onGalleryIconClicked() {
        _imageEvent.value = true
    }

    /**
     * Photo Picker 실행 이벤트가 처리되었음을 알림
     */
    fun photoPickerEventHandled() {
        _imageEvent.value = false
    }

    /**
     * Photo Picker에서 선택된 URI를 받아 상태 업데이트
     */
    fun onPhotoSelected(uri: Uri?) {
        _uiState.value = _uiState.value.copy(selectedImageUri = uri)
        Log.d("write", "onPhotoSelected - uri : $uri")
    }

    /**
     * Firebase에 기록 저장
     */
    fun saveRecord() {
        // 필수 항목 미입력 시, 메시지 발행 후 종료
        getSnackbarMessage(uiState.value)?.let { message ->
            viewModelScope.launch {
                _snackbarMessage.emit(message)
            }
            return
        }

        // 중복 저장 방지
        if (uiState.value.isSaving) return

        val currentUiState = uiState.value
        val imageUrl = currentUiState.selectedImageUri

        _uiState.update { it.copy(isSaving = true) }

        viewModelScope.launch {
            val result = saveRecordUseCase(currentUiState, imageUrl)

            result.onSuccess {
                // 저장 성공
                _completeSaveRecord.send(Unit)
            }.onFailure { exception ->
                // 저장 실패
                Log.e("write", "saveRecord - exception : $exception")
            }

            _uiState.update { it.copy(isSaving = false) }
        }
    }

    private fun getSnackbarMessage(uiState: RecordWriteUiState): SnackbarMessage? {
        if (uiState.recordTitle.isBlank()) {
            return SnackbarMessage(
                message = WriteMessage.TITLE_EMPTY
            )
        }
        if (uiState.recordContent.isBlank()) {
            return SnackbarMessage(
                message = WriteMessage.CONTENT_EMPTY
            )
        }
        if (uiState.selectedStartDateMillis == null) {
            return SnackbarMessage(
                message = WriteMessage.DATE_EMPTY
            )
        }
        if (uiState.selectedEmotion == null) {
            return SnackbarMessage(
                message = WriteMessage.EMOTION_EMPTY
            )
        }
        if (uiState.selectedWeather == null) {
            return SnackbarMessage(
                message = WriteMessage.WEATHER_EMPTY
            )
        }
        if (uiState.selectedPlace == null && uiState.overseasPlace.isBlank()) {
            return SnackbarMessage(
                message = WriteMessage.PLACE_EMPTY
            )
        }

        return null
    }

    /**
     * 저장된 국내 여행지 삭제
     */
    fun clearSelectedPlace() {
        _uiState.update { it.copy(selectedPlace = null) }
    }

    /**
     * 저장된 해외 여행지 삭제
     */
    fun clearOverseasPlace() {
        _uiState.update { it.copy(overseasPlace = "") }
    }

    /**
     * 선택된 이미지 삭제
     */
    fun clearSelectedImageUri() {
        _uiState.update { it.copy(selectedImageUri = null) }
    }
}
