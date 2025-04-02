package ru.syndicate.atmosphere.feature.onboarding.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.RU)
internal val RuStrings = Strings(
    languageSelectionTitle = "Выберите язык приложения",
    languageSelectionDesc = "Выберите язык приложения для продолжения.",
    batteryTitle = "Фоновая активность",
    batteryDesc = "Отключите контроль фоновой активности чтобы приложение могло корректно обновлять данные о погоде.",
    confirmButtonText = "Подтвердить",
    continueButtonText = "Продолжить"
)