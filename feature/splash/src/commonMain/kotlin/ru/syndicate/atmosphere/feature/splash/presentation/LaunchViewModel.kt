package ru.syndicate.atmosphere.feature.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.core.presentation.util.LaunchAppType
import ru.syndicate.atmosphere.widget.domain.WidgetManager

internal class LaunchViewModel(
    private val settingsRepository: SettingsRepository,
    private val widgetManager: WidgetManager
) : ViewModel() {

    private val _launchAppType = MutableStateFlow(LaunchAppType.FIRST_LAUNCH)
    val launchAppType = _launchAppType.asStateFlow()

    init {

        viewModelScope.launch {

            widgetManager.rerunWidget(settingsRepository.widgetTiming.first())

            settingsRepository.launchAppType
                .collect { type ->
                    _launchAppType.update { type }
                }
        }
    }
}