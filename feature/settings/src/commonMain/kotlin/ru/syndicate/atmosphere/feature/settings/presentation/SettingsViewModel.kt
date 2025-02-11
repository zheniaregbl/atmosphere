package ru.syndicate.atmosphere.feature.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository

internal class SettingsViewModel(
    private val settingsRepository: SettingsRepository
): ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            settingsRepository.appLanguage
                .collect { language ->
                    _state.update { it.copy(appLanguage = language) }
                }
        }
    }

    fun onAction(action: SettingsAction) {
        when (action) {
            is SettingsAction.OnChangeSearchLanguage -> changeSearchLanguage(action.language)
        }
    }

    private fun changeSearchLanguage(language: String) = viewModelScope.launch {
        settingsRepository.changeSearchLanguage(language)
    }
}