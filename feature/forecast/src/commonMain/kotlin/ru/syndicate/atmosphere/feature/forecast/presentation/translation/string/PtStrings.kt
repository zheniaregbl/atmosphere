package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.PT)
internal val PtStrings = Strings(
    screenTitle = "Previsão",
    monthTitle = MonthTitle(
        january = "janeiro",
        february = "fevereiro",
        march = "março",
        april = "abril",
        may = "maio",
        june = "junho",
        july = "julho",
        august = "agosto",
        september = "setembro",
        october = "outubro",
        november = "novembro",
        december = "dezembro"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Segunda-feira",
        tuesday = "Terça-feira",
        wednesday = "Quarta-feira",
        thursday = "Quinta-feira",
        friday = "Sexta-feira",
        saturday = "Sábado",
        sunday = "Domingo"
    )
)