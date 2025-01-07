package ru.syndicate.atmosphere.feature.home.presentation

import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather

data class HomeState(
    val isLoading: Boolean = false,
    val currentWeatherParameters: CurrentWeatherParameters = CurrentWeatherParameters(),
    val hourlyWeather: HourlyWeather = HourlyWeather()
)
