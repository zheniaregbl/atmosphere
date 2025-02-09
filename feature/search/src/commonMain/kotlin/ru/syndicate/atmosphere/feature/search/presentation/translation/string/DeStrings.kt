package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.DE)
internal val DeStrings = Strings(
    screenTitle = "Suche",
    hintText = "Stadt eingeben...",
    cityList = listOf("Moskau", "London", "Madrid", "Paris", "Rom", "Lissabon", "Berlin"),
    errorMessageNotFoundLocation = "Es konnte kein Ort mit diesem Namen gefunden werden.",
    errorMessageProblemRequest = "Der Standort konnte aufgrund eines Problems mit der Anfrage nicht gefunden werden."
)