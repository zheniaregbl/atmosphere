package ru.syndicate.atmosphere.widget.presentation.util

import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.widget.presentation.translation.DeStrings
import ru.syndicate.atmosphere.widget.presentation.translation.EnStrings
import ru.syndicate.atmosphere.widget.presentation.translation.EsStrings
import ru.syndicate.atmosphere.widget.presentation.translation.FrStrings
import ru.syndicate.atmosphere.widget.presentation.translation.ItStrings
import ru.syndicate.atmosphere.widget.presentation.translation.PtStrings
import ru.syndicate.atmosphere.widget.presentation.translation.RuStrings

internal fun getRefreshTextByLanguage(language: String) =
    when (language) {
        Locales.DE -> DeStrings.refreshText
        Locales.EN -> EnStrings.refreshText
        Locales.ES -> EsStrings.refreshText
        Locales.FR -> FrStrings.refreshText
        Locales.IT -> ItStrings.refreshText
        Locales.PT -> PtStrings.refreshText
        Locales.RU -> RuStrings.refreshText
        else -> EnStrings.refreshText
    }