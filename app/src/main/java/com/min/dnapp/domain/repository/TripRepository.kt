package com.min.dnapp.domain.repository

import com.min.dnapp.domain.model.Trip

interface TripRepository {
    fun getTrips(): List<Trip>
}