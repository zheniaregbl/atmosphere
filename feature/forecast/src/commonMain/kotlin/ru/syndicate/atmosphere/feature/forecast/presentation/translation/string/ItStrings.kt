package ru.syndicate.atmosphere.feature.forecast.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.IT)
internal val ItStrings = Strings(
    screenTitle = "Previsione",
    temperatureSectionTitle = "Temperatura",
    maximum = "Massimo",
    minimum = "Minimo",
    precipitationSectionTitle = "Umidità",
    precipitationProbability = "Probabilità di precipitazione",
    windSectionTitle = "Vento",
    windUnit = "m/s",
    speed = "Velocità",
    sunSectionTitle = "Sole",
    sunrise = "Alba",
    sunset = "Tramonto",
    monthTitle = MonthTitle(
        january = "gennaio",
        february = "febbraio",
        march = "marzo",
        april = "aprile",
        may = "maggio",
        june = "giugno",
        july = "luglio",
        august = "agosto",
        september = "settembre",
        october = "ottobre",
        november = "novembre",
        december = "dicembre"
    ),
    weekDayTitle = WeekDayTitle(
        monday = "Lunedì",
        tuesday = "Martedì",
        wednesday = "Mercoledì",
        thursday = "Giovedì",
        friday = "Venerdì",
        saturday = "Sabato",
        sunday = "Domenica"
    )
)