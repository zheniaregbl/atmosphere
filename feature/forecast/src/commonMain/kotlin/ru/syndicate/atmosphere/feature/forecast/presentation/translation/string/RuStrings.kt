package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.RU)
internal val RuStrings = Strings(
    screenTitle = "Прогноз",
    monthTitle = MonthTitle(
        january = "январь",
        february = "февраль",
        march = "март",
        april = "апрель",
        may = "май",
        june = "июнь",
        july = "июль",
        august = "август",
        september = "сентябрь",
        october = "октябрь",
        november = "ноябрь",
        december = "декабрь"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Понедельник",
        tuesday = "Вторник",
        wednesday = "Среда",
        thursday = "Четверг",
        friday = "Пятница",
        saturday = "Суббота",
        sunday = "Воскресенье"
    )
)