package ru.syndicate.atmosphere.widget.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.widget.domain.repository.WidgetWeatherRepository
import ru.syndicate.atmosphere.widget.data.repository.DefaultWidgetWeatherRepository

val widgetModule = module {
    singleOf(::DefaultWidgetWeatherRepository).bind<WidgetWeatherRepository>()
}