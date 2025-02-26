package ru.syndicate.atmosphere.feature.home.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.feature.home.data.repository.DefaultWeatherRepository
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.home.presentation.HomeScreen
import ru.syndicate.atmosphere.feature.home.presentation.HomeViewModel

val featureHomeModule = module {
    singleOf(::DefaultWeatherRepository).bind<WeatherRepository>()
    viewModelOf(::HomeViewModel)
}

val featureHomeScreenModule = screenModule {
    register<SharedScreen.HomeScreen> { HomeScreen() }
}