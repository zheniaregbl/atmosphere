package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    screenTitle = "Forecast",
    temperatureSectionTitle = "Temperature",
    maximum = "Maximum",
    minimum = "Minimum",
    precipitationSectionTitle = "Humidity",
    precipitationProbability = "Chance of precipitation",
    windSectionTitle = "Wind",
    windUnit = "m/s",
    speed = "Speed",
    sunSectionTitle = "Sun",
    sunrise = "Sunrise",
    sunset = "Sunset",
    monthTitle = MonthTitle(
        january = "january",
        february = "february",
        march = "march",
        april = "april",
        may = "may",
        june = "june",
        july = "july",
        august = "august",
        september = "september",
        october = "october",
        november = "november",
        december = "december"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Monday",
        tuesday = "Tuesday",
        wednesday = "Wednesday",
        thursday = "Thursday",
        friday = "Friday",
        saturday = "Saturday",
        sunday = "Sunday"
    )
)