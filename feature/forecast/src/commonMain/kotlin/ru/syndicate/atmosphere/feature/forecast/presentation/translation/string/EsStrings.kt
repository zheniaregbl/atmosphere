package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.ES)
internal val EsStrings = Strings(
    screenTitle = "Pronóstico",
    monthTitle = MonthTitle(
        january = "enero",
        february = "febrero",
        march = "marzo",
        april = "abril",
        may = "mayo",
        june = "junio",
        july = "julio",
        august = "agosto",
        september = "septiembre",
        october = "octubre",
        november = "noviembre",
        december = "diciembre"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Lunes",
        tuesday = "Martes",
        wednesday = "Miércoles",
        thursday = "Jueves",
        friday = "Viernes",
        saturday = "Sábado",
        sunday = "Domingo"
    )
)