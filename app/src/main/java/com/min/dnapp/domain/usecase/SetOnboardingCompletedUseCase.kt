package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.AppInitRepository
import javax.inject.Inject

class SetOnboardingCompletedUseCase @Inject constructor(
    private val appInitRepository: AppInitRepository
) {
    suspend operator fun invoke() {
        appInitRepository.setOnboardingCompleted()
    }
}
