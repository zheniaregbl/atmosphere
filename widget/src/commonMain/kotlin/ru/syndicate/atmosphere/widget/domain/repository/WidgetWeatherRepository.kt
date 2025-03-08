package ru.syndicate.atmosphere.widget.domain.repository

import ru.syndicate.atmosphere.widget.domain.model.WidgetWeatherInfo

interface WidgetWeatherRepository {
    suspend fun getWidgetWeather(): WidgetWeatherInfo
}