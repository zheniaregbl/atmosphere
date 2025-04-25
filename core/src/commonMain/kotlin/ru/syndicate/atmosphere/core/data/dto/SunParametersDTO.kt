package ru.syndicate.atmosphere.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SunParametersDTO(
    @SerialName("sunrise") val sunriseTime: List<String>,
    @SerialName("sunset") val sunsetTime: List<String>,
)
