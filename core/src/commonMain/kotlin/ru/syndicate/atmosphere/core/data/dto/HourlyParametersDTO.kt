package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyParametersDTO(
    @SerialName("time") val times: List<String>,
    @SerialName("temperature_2m") val temperatures: List<Double>,
    @SerialName("weather_code") val weatherCodes: List<Int>
)
