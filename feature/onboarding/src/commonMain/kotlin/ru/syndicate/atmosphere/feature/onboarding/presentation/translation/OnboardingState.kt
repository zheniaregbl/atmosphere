package ru.syndicate.atmosphere.feature.onboarding.presentation.translation

import ru.syndicate.atmosphere.core.presentation.translation.Locales

internal data class OnboardingState(
    val isLanguageSelected: Boolean = false,
    val appLanguage: String = Locales.EN,
    val isBackgroundPermissionGranted: Boolean? = null
)
