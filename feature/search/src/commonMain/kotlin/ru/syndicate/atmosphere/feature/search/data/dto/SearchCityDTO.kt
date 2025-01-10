package ru.syndicate.atmosphere.feature.search.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchCityDTO(
    @SerialName("name") val title: String,
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double,
    @SerialName("country_code") val countryCode: String,
    @SerialName("timezone") val timeZone: String,
    @SerialName("country") val country: String? = null
)
