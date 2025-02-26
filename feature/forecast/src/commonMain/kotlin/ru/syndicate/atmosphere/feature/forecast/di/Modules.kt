package ru.syndicate.atmosphere.feature.forecast.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.forecast.presentation.ForecastScreen
import ru.syndicate.atmosphere.feature.forecast.presentation.ForecastViewModel
import ru.syndicate.atmosphere.feature.forecast.data.repository.DefaultWeatherRepository
import ru.syndicate.atmosphere.feature.forecast.domain.repository.WeatherRepository

val featureForecastModule = module {
    singleOf(::DefaultWeatherRepository).bind<WeatherRepository>()
    viewModelOf(::ForecastViewModel)
}

val featureForecastScreenModule = screenModule {
    register<SharedScreen.ForecastScreen> { ForecastScreen() }
}