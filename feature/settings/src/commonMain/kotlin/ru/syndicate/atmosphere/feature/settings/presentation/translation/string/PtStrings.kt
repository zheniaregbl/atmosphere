package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.PT)
internal val PtStrings = Strings(
    screenTitle = "Configurações",
    langSectionTitle = "Idioma do aplicativo",
    langSectionDesc = "Esta configuração especifica o idioma da interface do aplicativo.",
    selectLangDialogTitle = "Selecione o idioma",
    selectButtonText = "Escolher",
    widgetTimingTitle = "Frequência de atualização do widget",
    widgetTimingDesc = "Esta configuração determina com que frequência o widget atualizará os dados climáticos em segundo plano.",
    minutesText = "min",
    hoursText = "hora"
)