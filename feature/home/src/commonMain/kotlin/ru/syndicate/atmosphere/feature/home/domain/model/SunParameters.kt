package ru.syndicate.atmosphere.feature.home.domain.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal data class SunParameters(
    val sunrise: LocalDateTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault()),
    val sunset: LocalDateTime = Clock
        .System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
)
