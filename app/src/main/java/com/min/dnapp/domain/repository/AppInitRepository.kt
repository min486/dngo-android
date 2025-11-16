package com.min.dnapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface AppInitRepository {
    fun getInitStatus(): Flow<Pair<Boolean, Boolean>>
    suspend fun setOnboardingCompleted()
    suspend fun setProfileSetupCompleted()
}
