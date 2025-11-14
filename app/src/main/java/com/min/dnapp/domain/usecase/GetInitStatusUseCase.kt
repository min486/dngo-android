package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.AppInitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetInitStatusUseCase @Inject constructor(
    private val appInitRepository: AppInitRepository
) {
    operator fun invoke(): Flow<Pair<Boolean, Boolean>> {
        return appInitRepository.getInitStatus()
    }
}
