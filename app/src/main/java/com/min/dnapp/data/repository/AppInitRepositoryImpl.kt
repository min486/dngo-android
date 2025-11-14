package com.min.dnapp.data.repository

import com.min.dnapp.data.datasource.AppPreferencesDataStore
import com.min.dnapp.domain.repository.AppInitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInitRepositoryImpl @Inject constructor(
    private val preferencesDataStore: AppPreferencesDataStore
) : AppInitRepository {

    override fun getInitStatus(): Flow<Pair<Boolean, Boolean>> {
        return preferencesDataStore.initStatusFlow
    }

    override suspend fun setOnboardingCompleted() {
        preferencesDataStore.setOnboardingCompleted(true)
    }

    override suspend fun setProfileSetupCompleted() {
        preferencesDataStore.setProfileSetupCompleted(true)
    }
}
