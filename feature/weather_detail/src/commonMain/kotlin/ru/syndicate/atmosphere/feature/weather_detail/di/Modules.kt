package ru.syndicate.atmosphere.feature.weather_detail.di

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailScreen

val featureWeatherDetailScreenModule = screenModule {
    register<SharedScreen.WeatherDetail> { WeatherDetailScreen() }
}