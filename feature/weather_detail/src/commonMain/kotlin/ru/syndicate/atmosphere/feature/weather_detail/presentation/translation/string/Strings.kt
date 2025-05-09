package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

internal data class Strings(
    val screenTitle: String,
    val tempSectionTitle: String,
    val maximum: String,
    val minimum: String,
    val precipitationSectionTitle: String,
    val precipitationHours: String,
    val sumPrecipitation: String,
    val hourUnit: String,
    val sumUnit: String,
    val timePrefix: String,
    val windSectionTitle: String,
    val sunSectionTitle: String,
    val pressureSectionTitle: String,
    val windUnit: String,
    val northSide: String,
    val eastSide: String,
    val southSide: String,
    val westSide: String,
    val maximumWindSpeed: String,
    val maximumWindGusts: String,
    val windDirection: String,
    val sunriseText: String,
    val sunsetText: String,
    val daylightDuration: String,
    val meanPressureText: String,
    val maxPressureText: String,
    val minPressureText: String,
    val pressureUnit: String,
    val errorContentStrings: ErrorContentStrings
)

internal data class ErrorContentStrings(
    val title: String,
    val text: String,
    val repeatText: String
)