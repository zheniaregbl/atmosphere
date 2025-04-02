package ru.syndicate.atmosphere.feature.settings.presentation

internal data class SettingsState(
    val appLanguage: String = "en",
    val selectedWidgetTimingIndex: Int = 0
)