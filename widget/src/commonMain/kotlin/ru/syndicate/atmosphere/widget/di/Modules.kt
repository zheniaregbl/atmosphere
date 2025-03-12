package ru.syndicate.atmosphere.widget.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.widget.domain.repository.WeatherWidgetRepository
import ru.syndicate.atmosphere.widget.data.repository.DefaultWeatherWidgetRepository

val widgetModule = module {
    singleOf(::DefaultWeatherWidgetRepository).bind<WeatherWidgetRepository>()
}