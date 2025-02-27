package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

internal data class Strings(
    val screenTitle: String,
    val temperatureSectionTitle: String,
    val maximum: String,
    val minimum: String,
    val precipitationSectionTitle: String,
    val precipitationProbability: String,
    val windSectionTitle: String,
    val speed: String,
    val sunSectionTitle: String,
    val sunrise: String,
    val sunset: String,
    val windUnit: String,
    val monthTitle: MonthTitle,
    val weekDayTitle: WeekDayTitle
)

internal data class MonthTitle(
    val january: String,
    val february: String,
    val march: String,
    val april: String,
    val may: String,
    val june: String,
    val july: String,
    val august: String,
    val september: String,
    val october: String,
    val november: String,
    val december: String
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