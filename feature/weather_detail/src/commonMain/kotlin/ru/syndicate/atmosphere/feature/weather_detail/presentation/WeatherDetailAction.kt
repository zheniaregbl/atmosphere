package ru.syndicate.atmosphere.feature.weather_detail.presentation

sealed interface WeatherDetailAction {
    data object OnUpdate : WeatherDetailAction
}