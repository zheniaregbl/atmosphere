package ru.syndicate.atmosphere.feature.weather_detail.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RealDateTimeResponseDTO(
    @SerialName("dateTime") val value: String
)
