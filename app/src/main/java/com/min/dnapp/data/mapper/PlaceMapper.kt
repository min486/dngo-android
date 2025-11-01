package com.min.dnapp.data.mapper

import com.min.dnapp.data.remote.dto.PlaceEntity
import com.min.dnapp.domain.model.LocalPlace

/**
 * LocalPlace -> PlaceEntity 변환
 */
fun LocalPlace.toEntity(): PlaceEntity {
    return PlaceEntity(
        title = this.title,
        category = this.category,
        roadAddress = this.roadAddress
    )
}

/**
 * PlaceEntity -> LocalPlace 변환
 */
fun PlaceEntity.toDomain(): LocalPlace {
    return LocalPlace(
        title = this.title ?: "",
        category = this.category ?: "",
        roadAddress = this.roadAddress ?: ""
    )
}
