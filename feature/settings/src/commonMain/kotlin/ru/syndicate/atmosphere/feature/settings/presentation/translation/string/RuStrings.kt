package ru.syndicate.atmosphere.feature.settings.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.RU)
internal val RuStrings = Strings(
    screenTitle = "Настройки",
    langSectionTitle = "Язык приложения",
    langSectionDesc = "Этот параметр задает язык интерфейса приложения.",
    selectLangDialogTitle = "Выберите язык",
    selectButtonText = "Выбрать",
    widgetTimingTitle = "Частота обновления виджета",
    widgetTimingDesc = "Этот параметр определяет как часто виджет будет обновлять данные погоды в фоновом режиме.",
    minutesText = "мин",
    hoursText = "час"
)