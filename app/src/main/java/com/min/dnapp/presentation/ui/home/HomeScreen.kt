package com.min.dnapp.presentation.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val trips by remember { mutableStateOf(homeViewModel.trips) }

    LazyColumn {
        items(trips) { trip ->
            Text(
                text = "id : ${trip.id}, title : ${trip.title}"
            )
        }
    }
}