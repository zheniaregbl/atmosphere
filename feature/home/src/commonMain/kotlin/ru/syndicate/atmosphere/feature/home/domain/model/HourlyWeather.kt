package ru.syndicate.atmosphere.feature.home.domain.model

data class HourlyWeather(
    val temperatures: List<Double> = emptyList(),
    val weatherCodes: List<Int> = emptyList()
)
