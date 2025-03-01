package ru.syndicate.atmosphere.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object OnboardingScreen : SharedScreen()
    data object HomeScreen : SharedScreen()
    data class SearchScreen(val isInitSelect: Boolean) : SharedScreen()
    data object SettingsScreen : SharedScreen()
    data object WeatherDetail : SharedScreen()
    data object ForecastScreen : SharedScreen()
}