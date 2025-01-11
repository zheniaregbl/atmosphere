package ru.syndicate.atmosphere.feature.home.domain.model

internal data class HourlyWeather(
    val temperatures: List<Double> = emptyList(),
    val weatherCodes: List<Int> = emptyList()
)
