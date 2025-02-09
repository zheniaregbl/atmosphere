package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.IT)
internal val ItStrings = Strings(
    screenTitle = "Ricerca",
    hintText = "Inserisci una città...",
    cityList = listOf("Mosca", "Londra", "Madrid", "Parigi", "Roma", "Lisbona", "Berlino"),
    errorMessageNotFoundLocation = "Impossibile trovare un luogo con questo nome.",
    errorMessageProblemRequest = "Impossibile trovare la posizione a causa di un problema con la richiesta."
)