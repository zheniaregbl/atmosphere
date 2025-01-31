package ru.syndicate.atmosphere.feature.home.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.feature.home.data.network.KtorRemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.data.repository.DefaultWeatherRepository
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository
import ru.syndicate.atmosphere.core.data.repository.DefaultSettingsRepository
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.feature.home.presentation.HomeViewModel

val featureHomeModule = module {
    singleOf(::KtorRemoteWeatherDataSource).bind<RemoteWeatherDataSource>()
    singleOf(::DefaultWeatherRepository).bind<WeatherRepository>()
    singleOf(::DefaultSettingsRepository).bind<SettingsRepository>()

    viewModelOf(::HomeViewModel)
}