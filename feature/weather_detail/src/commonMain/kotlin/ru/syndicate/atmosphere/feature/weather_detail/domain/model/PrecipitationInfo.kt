package ru.syndicate.atmosphere.feature.weather_detail.domain.model

data class PrecipitationInfo(
    val probability: Int = 45,
    val hours: Int = 2,
    val sum: Double = 100.0
)
