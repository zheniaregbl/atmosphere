package ru.syndicate.atmosphere.feature.search.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchCityResponseDTO(
    @SerialName("results") val cityList: List<SearchCityDTO>? = null,
    @SerialName("generationtime_ms") val generationTime: Double,
)
