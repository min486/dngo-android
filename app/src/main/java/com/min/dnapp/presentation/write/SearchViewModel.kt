package com.min.dnapp.presentation.write

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.LocalSearchUseCase
import com.min.dnapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val localSearchUseCase: LocalSearchUseCase
) : ViewModel() {

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    // 이전 검색 작업을 취소하기 위한 Job
    private var searchJob: Job? = null

    init {
        searchPlace("광안리해수욕장")
    }

    fun searchPlace(query: String) {
        val currentQuery = _searchState.value.query

        // 검색어 상태 업데이트 (textField 값과 viewModel 상태를 동기화)
        _searchState.value = _searchState.value.copy(query = query)

        // 검색어가 이전과 같으면 API 호출 막음
        if (query == currentQuery) return

        // 검색어가 비어있을 경우 (사용자가 모두 지웠을 경우)
        if (query.isBlank()) {
            searchJob?.cancel()
            _searchState.value = _searchState.value.copy(
                isLoading = false,
                places = emptyList(),
                error = null
            )
            Log.d("naver", "search query blank")
            return
        }

        // 진행중인(이전 검색) 작업이 있으면 취소
        searchJob?.cancel()

        // Flow 수집 및 상태 업데이트 시작
        searchJob = localSearchUseCase(query)
            .onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        // 로딩 시작
                        _searchState.value = _searchState.value.copy(
                            isLoading = true,
                            places = result.data ?: emptyList(),
                            error = null
                        )
                        Log.d("naver", "search for $query : Loading...")

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
}
