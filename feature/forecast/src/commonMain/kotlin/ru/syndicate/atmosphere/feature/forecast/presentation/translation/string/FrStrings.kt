package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.FR)
internal val FrStrings = Strings(
    screenTitle = "Prévision",
    temperatureSectionTitle = "Température",
    maximum = "Maximum",
    minimum = "Minimum",
    precipitationSectionTitle = "Humidité",
    precipitationProbability = "Probabilité de précipitation",
    windSectionTitle = "Vent",
    windUnit = "m/s",
    speed = "Vitesse",
    sunSectionTitle = "Soleil",
    sunrise = "Lever du soleil",
    sunset = "Coucher du soleil",
    monthTitle = MonthTitle(
        january = "janvier",
        february = "février",
        march = "mars",
        april = "avril",
        may = "mai",
        june = "juin",
        july = "juillet",
        august = "août",
        september = "septembre",
        october = "octobre",
        november = "novembre",
        december = "décembre"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Lundi",
        tuesday = "Mardi",
        wednesday = "Mercredi",
        thursday = "Jeudi",
        friday = "Vendredi",
        saturday = "Samedi",
        sunday = "Dimanche"
    )
)