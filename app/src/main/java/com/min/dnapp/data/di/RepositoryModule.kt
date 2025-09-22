package com.min.dnapp.data.di

import com.min.dnapp.data.repository.TripRepositoryImpl
import com.min.dnapp.domain.repository.TripRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTripRepository(): TripRepository {
        return TripRepositoryImpl()
    }
}