package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.DE)
internal val DeStrings = Strings(
    screenTitle = "Details",
    tempSectionTitle = "Temperatur",
    maximum = "Maximum",
    minimum = "Minimum",
    precipitationSectionTitle = "Niederschlag",
    precipitationHours = "Niederschlagsstunden",
    sumPrecipitation = "Niederschlagssumme",
    hourUnit = "h",
    sumUnit = "mm",
    timePrefix = "um",
    windSectionTitle = "Wind",
    sunSectionTitle = "Sonne",
    windUnit = "m/s",
    northSide = "Nord",
    eastSide = "Ost",
    southSide = "Süd",
    westSide = "West",
    maximumWindSpeed = "Maximale Windgeschwindigkeit",
    maximumWindGusts = "Maximale Windböen",
    windDirection = "Windrichtung",
    sunriseText = "Sonnenaufgang um",
    sunsetText = "Sonnenuntergang um",
    daylightDuration = "Tageslichtdauer",
    pressureSectionTitle = "Druck",
    meanPressureText = "Durchschnittsdruck",
    maxPressureText = "Maximaldruck",
    minPressureText = "Mindestdruck",
    pressureUnit = "hPa",
    errorContentStrings = ErrorContentStrings(
        title = "Anfragefehler",
        text = "Beim Abrufen der detaillierten Wetterinformationen ist ein Fehler aufgetreten.",
        repeatText = "Wiederholen"
    )
)