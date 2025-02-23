package ru.syndicate.atmosphere.feature.weather_detail.domain.model

data class PrecipitationInfo(
    val hours: Int = 2,
    val sum: Double = 100.0,
    val probabilities: List<Int> = emptyList()
)
