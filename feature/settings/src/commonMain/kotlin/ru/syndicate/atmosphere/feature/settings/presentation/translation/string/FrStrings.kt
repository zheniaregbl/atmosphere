package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.FR)
internal val FrStrings = Strings(
    screenTitle = "Paramètres",
    langSectionTitle = "Langue de candidature",
    langSectionDesc = "Ce paramètre spécifie la langue de l'interface de l'application.",
    selectLangDialogTitle = "Sélectionnez la langue",
    selectButtonText = "Choisir",
    widgetTimingTitle = "Fréquence de mise à jour du widget",
    widgetTimingDesc = "Ce paramètre détermine la fréquence à laquelle le widget mettra à jour les données météo en arrière-plan.",
    minutesText = "min",
    hoursText = "heure"
)