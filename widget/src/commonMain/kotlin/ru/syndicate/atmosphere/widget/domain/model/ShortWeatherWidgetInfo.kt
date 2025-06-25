package ru.syndicate.atmosphere.widget.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.syndicate.atmosphere.core.presentation.translation.Locales

internal data class ShortWeatherWidgetInfo(
    val currentTemperature: Int = 20,
    val maxTemperature: Int = 30,
    val minTemperature: Int = 10,
    val weatherCode: Int = 1,
    val isDay: Boolean = true,
    val lastUpdateDateTime: String = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .toString(),
    val appLanguage: String = Locales.EN,
    val isError: Boolean = false
) {

    val lastUpdateTime: String
        get() {
            val localDateTime = LocalDateTime.parse(lastUpdateDateTime)
            val minutes = if (localDateTime.minute < 10) "0${localDateTime.minute}"
            else localDateTime.minute.toString()
            return "${localDateTime.hour}:$minutes"
        }
}