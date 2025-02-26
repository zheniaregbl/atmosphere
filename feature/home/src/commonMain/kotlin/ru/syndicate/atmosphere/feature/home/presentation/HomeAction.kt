package ru.syndicate.atmosphere.feature.home.presentation

internal sealed interface HomeAction {
    data object UpdateWeatherInfo : HomeAction
    data object NavigateToDetail : HomeAction
    data object NavigateToForecast : HomeAction
}