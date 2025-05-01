package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.IT)
internal val ItStrings = Strings(
    screenTitle = "Dettagli",
    tempSectionTitle = "Temperatura",
    maximum = "Massimo",
    minimum = "Minimo",
    precipitationSectionTitle = "Precipitazioni",
    precipitationHours = "Ore di precipitazione",
    sumPrecipitation = "Totale precipitazioni",
    hourUnit = "h",
    sumUnit = "mm",
    timePrefix = "alle",
    windSectionTitle = "Vento",
    sunSectionTitle = "Sole",
    windUnit = "m/s",
    northSide = "Nord",
    eastSide = "Est",
    southSide = "Sud",
    westSide = "Ovest",
    maximumWindSpeed = "Velocità massima del vento",
    maximumWindGusts = "Raffiche massime di vento",
    windDirection = "Direzione del vento",
    sunriseText = "Alba alle",
    sunsetText = "Tramonto alle",
    daylightDuration = "Durata del giorno",
    pressureSectionTitle = "Pressione",
    meanPressureText = "Pressione media",
    maxPressureText = "Pressione massima",
    minPressureText = "Pressione minima",
    pressureUnit = "hPa",
    errorContentStrings = ErrorContentStrings(
        title = "Errore di richiesta",
        text = "Si è verificato un errore durante il recupero delle informazioni dettagliate sul meteo.",
        repeatText = "Riprova"
    )
)