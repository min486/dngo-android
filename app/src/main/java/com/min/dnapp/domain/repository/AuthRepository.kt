package com.min.dnapp.domain.repository

import android.content.Context
import com.min.dnapp.domain.model.UserProfile

interface AuthRepository {
    suspend fun signInWithKakao(context: Context): Result<UserProfile>
    suspend fun logout(): Result<Unit>
}
