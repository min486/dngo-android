package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.repository.AppInitRepository
import javax.inject.Inject

class SetProfileSetupCompletedUseCase @Inject constructor(
    private val appInitRepository: AppInitRepository
){
    suspend operator fun invoke() {
        appInitRepository.setProfileSetupCompleted()
    }
}
