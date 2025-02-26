package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyForecastWeatherResponseDTO(
    @SerialName("daily") val dailyParameters: DailyParametersDTO
)