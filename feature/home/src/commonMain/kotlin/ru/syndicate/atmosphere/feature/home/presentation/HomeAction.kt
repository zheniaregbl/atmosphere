package ru.syndicate.atmosphere.feature.home.presentation

sealed interface HomeAction {
    data object UpdateWeatherInfo : HomeAction
}