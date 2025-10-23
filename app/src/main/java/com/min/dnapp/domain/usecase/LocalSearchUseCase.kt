package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.repository.LocalSearchRepository
import com.min.dnapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalSearchUseCase @Inject constructor(
    private val repository: LocalSearchRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<LocalPlace>>> {
        return repository.searchPlaces(query)
    }
}
