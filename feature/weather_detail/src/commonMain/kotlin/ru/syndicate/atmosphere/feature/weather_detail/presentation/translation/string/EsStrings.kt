package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.ES)
internal val EsStrings = Strings(
    screenTitle = "Detalles",
    tempSectionTitle = "Temperatura",
    maximum = "Máximo",
    minimum = "Mínimo",
    precipitationSectionTitle = "Precipitación",
    precipitationHours = "Horas de precipitación",
    sumPrecipitation = "Suma de precipitación",
    hourUnit = "h",
    sumUnit = "mm",
    timePrefix = "a las",
    windSectionTitle = "Viento",
    sunSectionTitle = "Sol",
    windUnit = "m/s",
    northSide = "Norte",
    eastSide = "Este",
    southSide = "Sur",
    westSide = "Oeste",
    maximumWindSpeed = "Velocidad máxima del viento",
    maximumWindGusts = "Ráfagas máximas de viento",
    windDirection = "Dirección del viento",
    sunriseText = "Amanece a las",
    sunsetText = "Atardece a las",
    daylightDuration = "Duración del día",
    pressureSectionTitle = "Presión",
    meanPressureText = "Presión media",
    maxPressureText = "Presión máxima",
    minPressureText = "Presión mínima",
    pressureUnit = "hPa",
    errorContentStrings = ErrorContentStrings(
        title = "Error de solicitud",
        text = "Se produjo un error al recuperar la información detallada del clima.",
        repeatText = "Reintentar"
    )
)