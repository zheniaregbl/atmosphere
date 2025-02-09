package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    screenTitle = "Settings",
    langSectionTitle = "Application language",
    langSectionDesc = "This setting specifies the application interface language.",
    selectLangDialogTitle = "Select language",
    selectButtonText = "Choose"
)