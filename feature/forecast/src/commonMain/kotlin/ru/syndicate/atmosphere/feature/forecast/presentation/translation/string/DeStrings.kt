package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.DE)
internal val DeStrings = Strings(
    screenTitle = "Vorhersage",
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
    )
)