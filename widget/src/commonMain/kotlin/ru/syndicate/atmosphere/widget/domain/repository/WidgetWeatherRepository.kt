package ru.syndicate.atmosphere.widget.domain.repository

import ru.syndicate.atmosphere.widget.domain.model.WeatherWidgetInfo

internal interface WidgetWeatherRepository {
    suspend fun getWidgetWeather(): WeatherWidgetInfo
}