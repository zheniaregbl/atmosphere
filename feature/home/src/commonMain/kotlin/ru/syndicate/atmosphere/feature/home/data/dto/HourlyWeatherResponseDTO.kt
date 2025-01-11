package ru.syndicate.atmosphere.feature.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class HourlyWeatherResponseDTO(
    @SerialName("current") val currentParameters: CurrentParametersDTO,
    @SerialName("hourly") val hourlyParameters: HourlyParametersDTO
)
