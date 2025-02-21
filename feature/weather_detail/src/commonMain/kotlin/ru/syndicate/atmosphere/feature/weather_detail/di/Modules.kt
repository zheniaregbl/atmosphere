package ru.syndicate.atmosphere.feature.weather_detail.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailScreen
import ru.syndicate.atmosphere.core.data.repository.DefaultSettingsRepository
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailViewModel

val featureWeatherDetailModule = module {
    singleOf(::DefaultSettingsRepository).bind<SettingsRepository>()
    viewModelOf(::WeatherDetailViewModel)
}

val featureWeatherDetailScreenModule = screenModule {
    register<SharedScreen.WeatherDetail> { WeatherDetailScreen() }
}