package ru.syndicate.atmosphere.widget.presentation.translation

internal data class Strings(
    val refreshText: String,
    val errorMessage: String,
    val weekDayTitle: WeekDayTitle
)

internal data class WeekDayTitle(
    val monday: String,
    val tuesday: String,
    val wednesday: String,
    val thursday: String,
    val friday: String,
    val saturday: String,
    val sunday: String
)