package ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    languageSelectionTitle = "Select app language",
    languageSelectionDesc = "Select the application language to continue.",
    batteryTitle = "Background activity",
    batteryDesc = "Disable background activity control to allow the app to properly update weather data.",
    confirmButtonText = "Confirm",
    continueButtonText = "Continue"
)