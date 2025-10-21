package com.min.dnapp.data.repository

import android.net.http.HttpEngine
import android.util.Log
import com.min.dnapp.data.remote.LocalSearchResponse
import com.min.dnapp.data.remote.LocalSearchService
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.domain.repository.LocalSearchRepository
import com.min.dnapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSearchRepositoryImpl @Inject constructor(
    private val api: LocalSearchService
) : LocalSearchRepository {
    override fun searchPlaces(query: String): Flow<Resource<List<LocalPlace>>> = flow {
        emit(Resource.Loading())

        try {
            val response: LocalSearchResponse = api.search(
                query = query
            )

            val places = response.items.map { searchItem ->
                LocalPlace(
                    title = searchItem.title,
                    category = searchItem.category,
                    roadAddress = searchItem.roadAddress
                )
            }

            emit(Resource.Success(places))
        } catch (e: HttpException) {
            emit(Resource.Error("서버 오류 발생"))
        } catch (e: java.io.IOException) {
            emit(Resource.Error("네트워크 연결 문제"))
        } catch (e: Exception) {
            emit(Resource.Error("알 수 없는 오류 발생"))
        }
    }
}
