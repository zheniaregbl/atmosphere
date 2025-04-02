package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.IT)
internal val ItStrings = Strings(
    screenTitle = "Impostazioni",
    langSectionTitle = "Lingua dell'applicazione",
    langSectionDesc = "Questa impostazione specifica la lingua dell'interfaccia dell'applicazione.",
    selectLangDialogTitle = "Seleziona la lingua",
    selectButtonText = "Scegliere",
    widgetTimingTitle = "Frequenza aggiornamento widget",
    widgetTimingDesc = "Questa impostazione determina quanto spesso il widget aggiornerà i dati meteo in background.",
    minutesText = "min",
    hoursText = "ora"
)