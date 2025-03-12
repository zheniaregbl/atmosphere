package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherWidgetDTO(
    @SerialName("current") val currentParameters: CurrentParametersDTO,
    @SerialName("daily") val dailyParameters: DailyParametersDTO,
)
