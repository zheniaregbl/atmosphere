package ru.syndicate.atmosphere.feature.forecast.di

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.forecast.presentation.ForecastScreen

val featureForecastScreenModule = screenModule {
    register<SharedScreen.ForecastScreen> { ForecastScreen() }
}