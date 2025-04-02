package ru.syndicate.atmosphere.feature.settings.presentation

internal sealed interface SettingsAction {
    data class OnChangeSearchLanguage(val language: String) : SettingsAction
    data class OnChangeWidgetTiming(val selectedIndex: Int) : SettingsAction
}