package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.PT)
internal val PtStrings = Strings(
    screenTitle = "Detalhes",
    tempSectionTitle = "Temperatura",
    maximum = "Máximo",
    minimum = "Mínimo",
    precipitationSectionTitle = "Precipitação",
    precipitationHours = "Horas de precipitação",
    sumPrecipitation = "Soma da precipitação",
    hourUnit = "h",
    sumUnit = "mm",
    timePrefix = "às",
    windSectionTitle = "Vento",
    sunSectionTitle = "Sol",
    windUnit = "m/s",
    northSide = "Norte",
    eastSide = "Leste",
    southSide = "Sul",
    westSide = "Oeste",
    maximumWindSpeed = "Velocidade máxima do vento",
    maximumWindGusts = "Rajadas máximas de vento",
    windDirection = "Direção do vento",
    sunriseText = "Nascer do sol às",
    sunsetText = "Pôr do sol às",
    daylightDuration = "Duração do dia",
    pressureSectionTitle = "Pressão",
    meanPressureText = "Pressão média",
    maxPressureText = "Pressão máxima",
    minPressureText = "Pressão mínima",
    pressureUnit = "hPa",
    errorContentStrings = ErrorContentStrings(
        title = "Erro na solicitação",
        text = "Ocorreu um erro ao recuperar as informações detalhadas sobre o clima.",
        repeatText = "Repetir"
    )
)