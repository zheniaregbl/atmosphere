package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.DE)
internal val DeStrings = Strings(
    screenTitle = "Vorhersage",
    temperatureSectionTitle = "Temperatur",
    maximum = "Maximum",
    minimum = "Minimum",
    precipitationSectionTitle = "Luftfeuchtigkeit",
    precipitationProbability = "Niederschlagswahrscheinlichkeit",
    windSectionTitle = "Wind",
    windUnit = "m/s",
    speed = "Geschwindigkeit",
    sunSectionTitle = "Sonne",
    sunrise = "Sonnenaufgang",
    sunset = "Sonnenuntergang",
    monthTitle = MonthTitle(
        january = "Januar",
        february = "Februar",
        march = "März",
        april = "April",
        may = "Mai",
        june = "Juni",
        july = "Juli",
        august = "August",
        september = "September",
        october = "Oktober",
        november = "November",
        december = "Dezember"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Montag",
        tuesday = "Dienstag",
        wednesday = "Mittwoch",
        thursday = "Donnerstag",
        friday = "Freitag",
        saturday = "Samstag",
        sunday = "Sonntag"
    ),
    errorContentStrings = ErrorContentStrings(
        title = "Anfragefehler",
        text = "Beim Abrufen der Wettervorhersage ist ein Fehler aufgetreten.",
        repeatText = "Wiederholen"
    )
)