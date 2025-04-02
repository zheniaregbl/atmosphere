package ru.syndicate.atmosphere.feature.forecast.presentation

sealed interface ForecastAction {
    data object OnUpdate : ForecastAction
}