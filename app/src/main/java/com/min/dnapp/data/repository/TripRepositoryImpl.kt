package com.min.dnapp.data.repository

import com.min.dnapp.domain.model.Trip
import com.min.dnapp.domain.repository.TripRepository
import javax.inject.Inject

class TripRepositoryImpl @Inject constructor() : TripRepository {
    override fun getTrips(): List<Trip> {
        return listOf(
            Trip("1", "제주도 여행"),
            Trip("2", "강릉 바다")
        )
    }
}