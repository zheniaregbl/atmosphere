package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherResponseDTO(
    @SerialName("daily") val dailyParameters: DailyParametersDTO
)