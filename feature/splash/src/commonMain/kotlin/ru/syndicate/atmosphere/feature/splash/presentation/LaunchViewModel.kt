package ru.syndicate.atmosphere.feature.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.core.presentation.util.LaunchAppType

internal class LaunchViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _launchAppType = MutableStateFlow(LaunchAppType.FIRST_LAUNCH)
    val launchAppType = _launchAppType.asStateFlow()

    init {
        viewModelScope.launch {
            settingsRepository.launchAppType
                .collect { type ->
                    _launchAppType.update { type }
                }
        }
    }
}