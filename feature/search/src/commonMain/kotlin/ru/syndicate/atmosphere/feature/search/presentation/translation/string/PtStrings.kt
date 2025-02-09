package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.PT)
internal val PtStrings = Strings(
    screenTitle = "Pesquisa",
    hintText = "Insira uma cidade...",
    cityList = listOf("Moscou", "Londres", "Madrid", "Paris", "Roma", "Lisboa", "Berlim"),
    errorMessageNotFoundLocation = "Não foi possível encontrar um local com esse nome.",
    errorMessageProblemRequest = "Falha ao encontrar a localização devido a um problema com a solicitação."
)