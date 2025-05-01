package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    screenTitle = "Details",
    tempSectionTitle = "Temperature",
    maximum = "Maximum",
    minimum = "Minimum",
    precipitationSectionTitle = "Precipitation",
    precipitationHours = "Precipitation hours",
    sumPrecipitation = "Sum precipitation",
    hourUnit = "h",
    sumUnit = "mm",
    timePrefix = "at",
    windSectionTitle = "Wind",
    sunSectionTitle = "Sun",
    windUnit = "m/s",
    northSide = "North",
    eastSide = "East",
    southSide = "South",
    westSide = "West",
    maximumWindSpeed = "Maximum wind speed",
    maximumWindGusts = "Maximum wind gusts",
    windDirection = "Wind direction",
    sunriseText = "Sunrise at",
    sunsetText = "Sunset at",
    daylightDuration = "Daylight duration",
    pressureSectionTitle = "Pressure",
    meanPressureText = "Mean pressure",
    maxPressureText = "Maximum pressure",
    minPressureText = "Minimum pressure",
    pressureUnit = "hPa",
    errorContentStrings = ErrorContentStrings(
        title = "Request Error",
        text = "An error occurred while retrieving detailed weather information.",
        repeatText = "Repeat"
    )
)