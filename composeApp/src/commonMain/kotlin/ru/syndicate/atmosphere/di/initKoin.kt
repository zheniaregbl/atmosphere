package ru.syndicate.atmosphere.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import ru.syndicate.atmosphere.core.di.networkModule
import ru.syndicate.atmosphere.feature.home.di.featureHomeModule
import ru.syndicate.atmosphere.feature.search.di.featureSearchModule
import ru.syndicate.atmosphere.feature.settings.di.featureSettingsModule
import ru.syndicate.atmosphere.feature.weather_detail.di.featureWeatherDetailModule

fun initKoin(
    config: KoinAppDeclaration? = null,
    platformModules: List<Module> = emptyList()
) {
    startKoin {
        config?.invoke(this)
        modules(
            networkModule,
            featureHomeModule,
            featureSearchModule,
            featureSettingsModule,
            featureWeatherDetailModule
        )
        modules(platformModules)
    }
}