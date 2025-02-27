package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.ES)
internal val EsStrings = Strings(
    screenTitle = "Pronóstico",
    temperatureSectionTitle = "Temperatura",
    maximum = "Máximo",
    minimum = "Mínimo",
    precipitationSectionTitle = "Humedad",
    precipitationProbability = "Probabilidad de precipitación",
    windSectionTitle = "Viento",
    windUnit = "m/s",
    speed = "Velocidad",
    sunSectionTitle = "Sol",
    sunrise = "Amanecer",
    sunset = "Atardecer",
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