package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyDetailWeatherResponseDTO(
    @SerialName("daily") val dailyParameters: DailyParametersDTO,
    @SerialName("hourly") val hourlyDayParameters: HourlyDayParametersDTO
)

@Serializable
data class HourlyDayParametersDTO(
    @SerialName("temperature_2m") val temperatures: List<Double>,
    @SerialName("precipitation_probability") val precipitationProbability: List<Double>,
)