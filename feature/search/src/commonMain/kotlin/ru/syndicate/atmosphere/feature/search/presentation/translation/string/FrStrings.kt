package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.FR)
internal val FrStrings = Strings(
    screenTitle = "Recherche",
    hintText = "Entrez une ville...",
    cityList = listOf("Moscou", "Londres", "Madrid", "Paris", "Rome", "Lisbonne", "Berlin"),
    errorMessageNotFoundLocation = "Impossible de trouver un lieu avec ce nom.",
    errorMessageProblemRequest = "Impossible de trouver l'emplacement en raison d'un problème avec la requête."
)