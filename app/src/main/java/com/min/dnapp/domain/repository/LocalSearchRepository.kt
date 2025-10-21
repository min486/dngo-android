package com.min.dnapp.domain.repository

import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface LocalSearchRepository {
    fun searchPlaces(query: String): Flow<Resource<List<LocalPlace>>>
}
