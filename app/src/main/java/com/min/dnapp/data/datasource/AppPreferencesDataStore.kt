package com.min.dnapp.data.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_init_prefs")

class AppPreferencesDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object PreferencesKey {
        // 온보딩 완료 여부
        val IS_ONBOARDING_COMPLETED = booleanPreferencesKey("is_onboarding_completed")
        // 프로필 설정 완료 여부
        val IS_PROFILE_SETUP_COMPLETED = booleanPreferencesKey("is_profile_setup_completed")
    }

    // 온보딩 완료 저장
    suspend fun setOnboardingCompleted(isCompleted: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKey.IS_ONBOARDING_COMPLETED] = isCompleted
        }
    }

    // 프로필 설정 완료 저장
    suspend fun setProfileSetupCompleted(isCompleted: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKey.IS_PROFILE_SETUP_COMPLETED] = isCompleted
        }
    }

    // 읽기 Flow
    val initStatusFlow: Flow<Pair<Boolean, Boolean>> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val onboarding = preferences[PreferencesKey.IS_ONBOARDING_COMPLETED] ?: false
            val profile = preferences[PreferencesKey.IS_PROFILE_SETUP_COMPLETED] ?: false
            // 온보딩 완료 상태, 프로필 설정 완료 상태 반환
            Pair(onboarding, profile)
        }
}
