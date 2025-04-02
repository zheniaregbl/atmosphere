package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.DE)
internal val DeStrings = Strings(
    screenTitle = "Einstellungen",
    langSectionTitle = "Anwendungssprache",
    langSectionDesc = "Diese Einstellung gibt die Sprache der Anwendungsoberfläche an.",
    selectLangDialogTitle = "Sprache auswählen",
    selectButtonText = "Wählen",
    widgetTimingTitle = "Widget-Aktualisierungsfrequenz",
    widgetTimingDesc = "Diese Einstellung legt fest, wie oft das Widget Wetterdaten im Hintergrund aktualisiert.",
    minutesText = "min",
    hoursText = "Std"
)