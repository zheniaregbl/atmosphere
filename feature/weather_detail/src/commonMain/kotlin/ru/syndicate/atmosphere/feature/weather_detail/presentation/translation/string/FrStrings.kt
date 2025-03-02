package ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.FR)
internal val FrStrings = Strings(
    screenTitle = "Détails",
    tempSectionTitle = "Température",
    maximum = "Maximum",
    minimum = "Minimum",
    precipitationSectionTitle = "Précipitation",
    precipitationHours = "Heures de précipitation",
    sumPrecipitation = "Somme des précipitations",
    hourUnit = "h",
    sumUnit = "mm",
    timePrefix = "à",
    windSectionTitle = "Vent",
    sunSectionTitle = "Soleil",
    windUnit = "m/s",
    northSide = "Nord",
    eastSide = "Est",
    southSide = "Sud",
    westSide = "Ouest",
    maximumWindSpeed = "Vitesse maximale du vent",
    maximumWindGusts = "Rafales maximales de vent",
    windDirection = "Direction du vent",
    sunriseText = "Lever du soleil à",
    sunsetText = "Coucher du soleil à",
    daylightDuration = "Durée du jour",
    errorContentStrings = ErrorContentStrings(
        title = "Erreur de requête",
        text = "Une erreur s'est produite lors de la récupération des informations détaillées sur la météo.",
        repeatText = "Réessayer"
    )
)