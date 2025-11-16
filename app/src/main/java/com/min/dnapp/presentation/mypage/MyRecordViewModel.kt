package com.min.dnapp.presentation.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.GetUserRecordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyRecordViewModel @Inject constructor(
    private val getUserRecordUseCase: GetUserRecordUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MyRecordUiState>(MyRecordUiState.Loading)
    val uiState: StateFlow<MyRecordUiState> = _uiState.asStateFlow()

    init {
        loadMyRecordData()
    }

    private fun loadMyRecordData() {
        viewModelScope.launch {
            // 로딩 시작
            _uiState.value = MyRecordUiState.Loading

            // 내 여행기록 목록 가져오기
            try {
                val myRecords = getUserRecordUseCase()
                Log.d("my", "loadMyRecordData - myRecords: $myRecords")
                val successState = MyRecordUiState.Success(
                    records = myRecords
                )
                _uiState.value = successState
            } catch (e: Exception) {
                _uiState.value = MyRecordUiState.Success(
                    records = emptyList()
                )
                Log.e("my", "내 여행기록 조회 실패", e)
            }
        }
    }
}
