package ru.syndicate.atmosphere.widget.domain.repository

import ru.syndicate.atmosphere.widget.domain.model.ShortWeatherWidgetInfo

internal interface WeatherWidgetRepository {
    suspend fun getWidgetWeather(): ShortWeatherWidgetInfo
}