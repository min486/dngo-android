package com.min.dnapp.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.min.dnapp.BuildConfig
import com.min.dnapp.data.remote.LocalSearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NaverApiKey

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://openapi.naver.com/"

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json {
            // API 응답에서 사용하지 않는 필드는 무시하도록 설정
            ignoreUnknownKeys = true
            // 기본값이 있는 필드에 null이 오면 기본값 사용
            coerceInputValues = true
        }
    }

    @NaverApiKey
    @Provides
    fun provideNaverApiKey(): Pair<String, String> {
        val clientId = BuildConfig.NAVER_CLIENT_ID
        val clientSecret = BuildConfig.NAVER_CLIENT_SECRET
        return clientId to clientSecret
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(@NaverApiKey naverApiKey: Pair<String, String>): Interceptor {
        val (clientId, clientSecret) = naverApiKey
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideLocalSearchService(retrofit: Retrofit): LocalSearchService {
        return retrofit.create(LocalSearchService::class.java)
    }
}
