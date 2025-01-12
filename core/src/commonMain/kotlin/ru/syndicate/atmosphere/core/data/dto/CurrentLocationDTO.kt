package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentLocationDTO(
    @SerialName("title") val title: String,
    @SerialName("time_zone") val timeZone: String,
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double
)
