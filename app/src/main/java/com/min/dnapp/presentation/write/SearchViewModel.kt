package com.min.dnapp.presentation.write

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.usecase.LocalSearchUseCase
import com.min.dnapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val localSearchUseCase: LocalSearchUseCase
) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow()

    private val _selectedPlace = MutableStateFlow<LocalPlace?>(null)
    val selectedPlace: StateFlow<LocalPlace?> = _selectedPlace.asStateFlow()

    private val _overseasPlace = MutableStateFlow("")
    val overseasPlace: StateFlow<String> = _overseasPlace.asStateFlow()

    private val _recordTitle = MutableStateFlow("")
    val recordTitle: StateFlow<String> = _recordTitle.asStateFlow()

    private val _recordContent = MutableStateFlow("")
    val recordContent: StateFlow<String> = _recordContent.asStateFlow()

    // 이전 검색 작업을 취소하기 위한 Job
    private var searchJob: Job? = null

//    init {
//        searchPlace("광안리해수욕장")
//    }

    /**
     * textField의 입력 값만 업데이트하고, 검색 API 호출은 생략
     */
    fun updateQuery(newQuery: String) {
        _searchState.value = _searchState.value.copy(query = newQuery)

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
        val currentQuery = _searchState.value.query

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
                        _searchState.value = _searchState.value.copy(
                            isLoading = true,
                            places = result.data ?: emptyList(),
                            error = null
                        )
                        Log.d("naver", "search for $currentQuery : Loading...")
                    }
                    is Resource.Success -> {
                        // 성공
                        _searchState.value = _searchState.value.copy(
                            isLoading = false,
                            places = result.data ?: emptyList(),
                            error = null
                        )
                        Log.d("naver", "search success : ${result.data?.size} 개")
                    }
                    is Resource.Error -> {
                        // 에러
                        _searchState.value = _searchState.value.copy(
                            isLoading = false,
                            places = result.data ?: emptyList(),
                            error = result.message ?: "알 수 없는 에러 발생"
                        )
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
        _searchState.value = _searchState.value.copy(
            isLoading = false,
            places = emptyList(),
            error = null
        )
        Log.d("naver", "result cleared")
    }

    /**
     * 국내 - 선택된 장소 저장
     */
    fun selectPlace(place: LocalPlace) {
        _selectedPlace.value = place
    }

    /**
     * 해외 - textField의 입력 값 업데이트
     */
    fun updateOverseas(newText: String) {
        _overseasPlace.value = newText
        Log.d("write", "updateOverseas - newText : $newText")
    }

    /**
     * 제목 - textField의 입력 값 업데이트
     */
    fun updateTitle(newText: String) {
        _recordTitle.value = newText
        Log.d("write", "updateTitle - newText : $newText")
    }

    /**
     * 내용 - textField의 입력 값 업데이트
     */
    fun updateContent(newText: String) {
        _recordContent.value = newText
        Log.d("write", "updateContent - newText : $newText")
    }
}
