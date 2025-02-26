package ru.syndicate.atmosphere.feature.forecast.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
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
    val weatherCode: Int = 1
)