package ru.syndicate.atmosphere.feature.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.core.presentation.PlatformBatterySettings
import ru.syndicate.atmosphere.core.presentation.util.LaunchAppType
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.OnboardingState

internal class OnboardingViewModel(
    private val settingsRepository: SettingsRepository,
    private val platformBatterySettings: PlatformBatterySettings
) : ViewModel() {

    private val _state = MutableStateFlow(OnboardingState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            settingsRepository.appLanguage
                .collect { language ->
                    _state.update { it.copy(appLanguage = language) }
                }
        }
    }

    fun onAction(action: OnboardingAction) {
        when (action) {
            is OnboardingAction.OnChangeSearchLanguage -> changeSearchLanguage(action.language)
            OnboardingAction.NavigateToSearch -> changeLaunchAppType()
            OnboardingAction.CheckBackgroundPermission -> checkBackgroundPermission()
            OnboardingAction.OnRequestBackgroundPermission -> requestBackgroundPermission()
        }
    }

    private fun changeSearchLanguage(language: String) = viewModelScope.launch {
        settingsRepository.changeSearchLanguage(language)
        _state.update { it.copy(isLanguageSelected = true) }
    }

    private fun checkBackgroundPermission() = viewModelScope.launch {
        _state.update { it.copy(isBackgroundPermissionGranted = null) }
        delay(10)
        _state.update { it.copy(
            isBackgroundPermissionGranted = platformBatterySettings
                .isBackgroundPermissionGranted()
        ) }
    }

    private fun requestBackgroundPermission() {
        platformBatterySettings.requestBackgroundPermission()
    }

    private fun changeLaunchAppType() = viewModelScope.launch {
        settingsRepository.changeAppLaunchAppType(LaunchAppType.INIT_LOCATION)
    }
}