package ru.syndicate.atmosphere.feature.onboarding.presentation.translation.util

import androidx.compose.runtime.staticCompositionLocalOf
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.DeStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.EnStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.EsStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.FrStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.PtStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.ItStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string.RuStrings

internal object TranslationUtil {

    val translations = mapOf(
        Locales.EN to EnStrings,
        Locales.RU to RuStrings,
        Locales.DE to DeStrings,
        Locales.FR to FrStrings,
        Locales.ES to EsStrings,
        Locales.IT to ItStrings,
        Locales.PT to PtStrings
    )
}

internal val LocalOnboardingStrings = staticCompositionLocalOf { EnStrings }