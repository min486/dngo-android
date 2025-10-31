package com.min.dnapp.data.di

import com.min.dnapp.data.repository.AuthRepositoryImpl
import com.min.dnapp.data.repository.LocalSearchRepositoryImpl
import com.min.dnapp.data.repository.RecordRepositoryImpl
import com.min.dnapp.data.repository.UserRepositoryImpl
import com.min.dnapp.domain.repository.AuthRepository
import com.min.dnapp.domain.repository.LocalSearchRepository
import com.min.dnapp.domain.repository.RecordRepository
import com.min.dnapp.domain.repository.UserRepository
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

    @Binds
    @Singleton
    abstract fun bindRecordRepository(
        recordRepositoryImpl: RecordRepositoryImpl
    ): RecordRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}
