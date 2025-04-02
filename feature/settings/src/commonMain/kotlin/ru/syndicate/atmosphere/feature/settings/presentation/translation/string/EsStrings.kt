package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.ES)
internal val EsStrings = Strings(
    screenTitle = "Ajustes",
    langSectionTitle = "Idioma de la aplicación",
    langSectionDesc = "Esta configuración especifica el idioma de la interfaz de la aplicación.",
    selectLangDialogTitle = "Seleccionar idioma",
    selectButtonText = "Elegir",
    widgetTimingTitle = "Frecuencia de actualización del widget",
    widgetTimingDesc = "Esta configuración determina con qué frecuencia el widget actualizará los datos del clima en segundo plano.",
    minutesText = "min",
    hoursText = "hora"
)
