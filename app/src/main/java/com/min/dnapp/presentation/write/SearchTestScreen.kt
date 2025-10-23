package com.min.dnapp.presentation.write

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchTestScreen(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchState = searchViewModel.searchState.value

    BasicTextField(
        value = searchState.query,
        onValueChange = { newValue ->
            searchViewModel.searchPlace(newValue)
        },
        singleLine = false
    )
}
