package ru.syndicate.atmosphere.feature.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.widget.domain.WidgetManager

internal class SettingsViewModel(
    private val settingsRepository: SettingsRepository,
    private val widgetManager: WidgetManager
): ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {
            settingsRepository.appLanguage
                .collect { language ->
                    _state.update { it.copy(appLanguage = language) }
                    widgetManager.updateWidget()
                }
        }

        viewModelScope.launch {
            settingsRepository.widgetTiming
                .collect { timing ->
                    val timingIndex = when (timing) {
                        30 -> 1
                        60 -> 2
                        else -> 0
                    }
                    _state.update { it.copy(selectedWidgetTimingIndex = timingIndex) }
                }
        }
    }

    fun onAction(action: SettingsAction) {

        when (action) {

            is SettingsAction.OnChangeSearchLanguage -> changeSearchLanguage(action.language)

            is SettingsAction.OnChangeWidgetTiming -> changeWidgetTiming(action.selectedIndex)
        }
    }

    private fun changeSearchLanguage(language: String) = viewModelScope.launch {
        settingsRepository.changeSearchLanguage(language)
    }

    private fun changeWidgetTiming(index: Int) = viewModelScope.launch {
        val timing = when (index) {
            1 -> 30
            2 -> 60
            else -> 15
        }
        settingsRepository.changeWidgetTiming(timing)
        widgetManager.rerunWidget(timing)
    }
}