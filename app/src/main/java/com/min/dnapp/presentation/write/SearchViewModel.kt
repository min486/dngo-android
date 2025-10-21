package com.min.dnapp.presentation.write

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.repository.LocalSearchRepository
import com.min.dnapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: LocalSearchRepository
) : ViewModel() {

    init {
        searchTest("광안리해수욕장")
    }

    fun searchTest(query: String) {
        viewModelScope.launch {
            repository.searchPlaces(query = query).collect { result ->
                when (result ) {
                    is Resource.Loading -> {
                        Log.e("naver", "로딩 중...")
                    }
                    is Resource.Success -> {
                        val data = result.data
                        data?.forEach { place ->
                            Log.e("naver", "place : ${place.title}")
                        }
                    }
                    is Resource.Error -> {
                        Log.e("naver", "search error : ${result.message}")
                    }
                }
            }
        }
    }
}
