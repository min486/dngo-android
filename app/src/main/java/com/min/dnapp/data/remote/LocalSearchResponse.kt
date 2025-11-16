package com.min.dnapp.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalSearchResponse(
    @SerialName("items") val items: List<SearchItem>
)

@Serializable
data class SearchItem(
    @SerialName("title") val title: String,
    @SerialName("category") val category: String,
    @SerialName("roadAddress") val roadAddress: String
)
