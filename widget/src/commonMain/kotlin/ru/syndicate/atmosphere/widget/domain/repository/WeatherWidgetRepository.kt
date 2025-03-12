package ru.syndicate.atmosphere.widget.domain.repository

import ru.syndicate.atmosphere.widget.domain.model.WeatherWidgetInfo

internal interface WeatherWidgetRepository {
    suspend fun getWidgetWeather(): WeatherWidgetInfo
}