package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetWeatherDTO(
    @SerialName("current") val currentParameters: CurrentParametersDTO,
    @SerialName("daily") val dailyParameters: DailyParametersDTO,
)
