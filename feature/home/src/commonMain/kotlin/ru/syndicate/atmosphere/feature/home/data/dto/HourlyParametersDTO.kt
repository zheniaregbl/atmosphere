package ru.syndicate.atmosphere.feature.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class HourlyParametersDTO(
    @SerialName("time") val times: List<String>,
    @SerialName("temperature_2m") val temperatures: List<Double>,
    @SerialName("weather_code") val weatherCodes: List<Int>
)
