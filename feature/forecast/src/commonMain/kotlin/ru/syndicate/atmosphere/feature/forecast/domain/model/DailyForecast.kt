package ru.syndicate.atmosphere.feature.forecast.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class DailyForecast(
    val date: LocalDate = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date,
    val maxTemperature: Int = 20,
    val minTemperature: Int = 10,
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
    val maxWindSpeed: Int = 2,
    val precipitationProbability: Int = 20,
    val weatherCode: Int = 1
)