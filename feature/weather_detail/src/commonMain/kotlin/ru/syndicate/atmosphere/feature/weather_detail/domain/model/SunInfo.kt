package ru.syndicate.atmosphere.feature.weather_detail.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal data class SunInfo(
    val sunrise: LocalDateTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault()),
    val nextDaySunrise: LocalDateTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault()),
    val sunset: LocalDateTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault()),
    val daylightDuration: Int = 10,
    val percentage: Float = 0.5f
)
