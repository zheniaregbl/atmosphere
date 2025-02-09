package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    screenTitle = "Search",
    hintText = "Enter city...",
    cityList = listOf("Moscow", "London", "Madrid", "Paris", "Rome", "Lisbon", "Berlin"),
    errorMessageNotFoundLocation = "Could not find a location with that name.",
    errorMessageProblemRequest = "Failed to find location due to a problem with the request."
)