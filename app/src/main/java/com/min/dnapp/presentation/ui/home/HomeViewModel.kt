package com.min.dnapp.presentation.ui.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.min.dnapp.domain.model.Trip
import com.min.dnapp.domain.repository.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tripRepository: TripRepository
) : ViewModel() {

    private val _trips = mutableStateListOf<Trip>()
    val trips: List<Trip> = _trips

    init {
        loadTrips()
    }

    private fun loadTrips() {
        _trips.addAll(tripRepository.getTrips())
    }
}