package com.min.dnapp.presentation.find

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.GetSharedRecordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindViewModel @Inject constructor(
    private val getSharedRecordUseCase: GetSharedRecordUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<FindUiState>(FindUiState.Loading)
    val uiState: StateFlow<FindUiState> = _uiState.asStateFlow()

    init {
        loaFindData()
    }

    private fun loaFindData() {
        viewModelScope.launch {
            // 로딩 시작
            _uiState.value = FindUiState.Loading

            // 공유된 기록 목록 가져오기
            try {
                val sharedRecords = getSharedRecordUseCase()
                Log.d("record", "loaFindData - sharedRecords: $sharedRecords")
                val successState = FindUiState.Success(
                    records = sharedRecords
                )
                _uiState.value = successState
            } catch (e: Exception) {
                _uiState.value = FindUiState.Success(
                    records = emptyList()
                )
                Log.e("record", "기록 목록 조회 실패", e)
            }
        }
    }
}
