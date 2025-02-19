package ru.syndicate.atmosphere.feature.weather_detail.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal data class SunInfo(
    val sunrise: LocalTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .time,
    val sunset: LocalTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .time,
    val daylightDuration: Int = 10
)
