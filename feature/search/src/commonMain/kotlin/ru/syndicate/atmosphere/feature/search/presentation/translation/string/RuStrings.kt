package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.RU)
internal val RuStrings = Strings(
    screenTitle = "Поиск",
    hintText = "Введите город...",
    cityList = listOf("Москва", "Лондон", "Мадрид", "Париж", "Рим", "Лиссабон", "Берлин"),
    errorMessageNotFoundLocation = "Не удалось найти место с таким названием.",
    errorMessageProblemRequest = "Местоположение не удалось найти из-за проблем с запросом."
)