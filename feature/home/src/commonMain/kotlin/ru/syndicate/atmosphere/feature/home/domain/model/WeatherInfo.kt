package ru.syndicate.atmosphere.feature.home.domain.model

internal data class WeatherInfo(
    val currentWeatherParameters: CurrentWeatherParameters = CurrentWeatherParameters(),
    val hourlyWeather: HourlyWeather = HourlyWeather(),
    val sunParameters: SunParameters = SunParameters()
)
