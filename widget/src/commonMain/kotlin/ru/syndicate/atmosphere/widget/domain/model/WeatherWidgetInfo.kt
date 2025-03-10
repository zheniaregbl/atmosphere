package ru.syndicate.atmosphere.widget.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.syndicate.atmosphere.core.presentation.translation.Locales

data class WeatherWidgetInfo(
    val currentTemperature: Int = -99,
    val maxTemperature: Int = -99,
    val minTemperature: Int = -99,
    val weatherCode: Int = 1,
    val lastUpdateTime: LocalDateTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault()),
    val appLanguage: String = Locales.EN
)
