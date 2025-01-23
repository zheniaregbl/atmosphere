package ru.syndicate.atmosphere.feature.search.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchCityDTO(
    @SerialName("name") val title: String,
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double,
    @SerialName("country_code") val countryCode: String,
    @SerialName("timezone") val timeZone: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("admin1") val mainAdminArea: String? = null
)
