package ru.syndicate.atmosphere.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object HomeScreen : SharedScreen()
    data object SearchScreen : SharedScreen()
    data object SettingsScreen : SharedScreen()
    data object WeatherDetail : SharedScreen()
    data object ForecastScreen : SharedScreen()
}