package com.min.dnapp.data.di

import com.min.dnapp.data.repository.AuthRepositoryImpl
import com.min.dnapp.data.repository.LocalSearchRepositoryImpl
import com.min.dnapp.domain.repository.AuthRepository
import com.min.dnapp.domain.repository.LocalSearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindLocalSearchRepository(
        localSearchRepositoryImpl: LocalSearchRepositoryImpl
    ): LocalSearchRepository
}
