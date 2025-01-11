package ru.syndicate.atmosphere.feature.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherResponseDTO(
    @SerialName("current") val currentParameters: CurrentParametersDTO,
    @SerialName("hourly") val hourlyParameters: HourlyParametersDTO
)
