package ru.syndicate.atmosphere.feature.weather_detail.domain.model

internal data class PressureInfo(
    val mean: Double = 700.0,
    val max: Double = 800.0,
    val min: Double = 600.0,
)
