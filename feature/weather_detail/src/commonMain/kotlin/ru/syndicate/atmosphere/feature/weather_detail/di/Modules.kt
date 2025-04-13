package ru.syndicate.atmosphere.feature.weather_detail.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailScreen
import ru.syndicate.atmosphere.feature.weather_detail.presentation.WeatherDetailViewModel
import ru.syndicate.atmosphere.feature.weather_detail.data.repository.DefaultWeatherRepository
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.WeatherRepository
import ru.syndicate.atmosphere.feature.weather_detail.domain.use_case.GetDailyWeatherCase

val featureWeatherDetailModule = module {
    singleOf(::DefaultWeatherRepository).bind<WeatherRepository>()
    singleOf(::GetDailyWeatherCase)
    viewModelOf(::WeatherDetailViewModel)
}

val featureWeatherDetailScreenModule = screenModule {
    register<SharedScreen.WeatherDetail> { WeatherDetailScreen() }
}