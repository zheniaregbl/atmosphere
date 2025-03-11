package ru.syndicate.atmosphere.widget.presentation.util

import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.widget.presentation.translation.DeStrings
import ru.syndicate.atmosphere.widget.presentation.translation.EnStrings
import ru.syndicate.atmosphere.widget.presentation.translation.EsStrings
import ru.syndicate.atmosphere.widget.presentation.translation.FrStrings
import ru.syndicate.atmosphere.widget.presentation.translation.ItStrings
import ru.syndicate.atmosphere.widget.presentation.translation.PtStrings
import ru.syndicate.atmosphere.widget.presentation.translation.RuStrings

internal fun getErrorMessage(language: String) =
    when (language) {
        Locales.DE -> DeStrings.errorMessage
        Locales.EN -> EnStrings.errorMessage
        Locales.ES -> EsStrings.errorMessage
        Locales.FR -> FrStrings.errorMessage
        Locales.IT -> ItStrings.errorMessage
        Locales.PT -> PtStrings.errorMessage
        Locales.RU -> RuStrings.errorMessage
        else -> EnStrings.errorMessage
    }