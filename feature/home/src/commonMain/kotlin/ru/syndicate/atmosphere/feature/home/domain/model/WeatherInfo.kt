package ru.syndicate.atmosphere.feature.home.domain.model

data class WeatherInfo(
    val currentWeatherParameters: CurrentWeatherParameters = CurrentWeatherParameters(),
    val hourlyWeather: HourlyWeather = HourlyWeather()
)
