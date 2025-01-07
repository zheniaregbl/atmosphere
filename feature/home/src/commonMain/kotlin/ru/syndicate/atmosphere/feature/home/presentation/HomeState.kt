package ru.syndicate.atmosphere.feature.home.presentation

import ru.syndicate.atmosphere.feature.home.domain.model.CurrentWeatherParameters

data class HomeState(
    val isLoading: Boolean = false,
    val currentWeatherParameters: CurrentWeatherParameters = CurrentWeatherParameters()
)
