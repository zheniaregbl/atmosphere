package ru.syndicate.atmosphere.feature.weather_detail.domain.model

data class TemperatureInfo(
    val maxTemperature: Int = 30,
    val maxApparentTemperature: Int = 33,
    val minTemperature: Int = 12,
    val minApparentTemperature: Int = 10,
    val temperatures: List<Int> = emptyList()
)
