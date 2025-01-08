package ru.syndicate.atmosphere.feature.home.domain.model

data class CurrentWeatherParameters(
    val temperature: Double = 0.0,
    val humidity: Int = 0,
    val apparentTemperature: Double = 0.0,
    val isDay: Int = 1,
    val weatherCode: Int = -1,
    val pressure: Double = 0.0,
    val windSpeed: Double = 0.0,
    val windDirection: Int = 0
)
