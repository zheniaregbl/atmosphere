package ru.syndicate.atmosphere.feature.weather_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository

internal class WeatherDetailViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherDetailState())
    val state = _state
        .onStart {  }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(10_000L),
            _state.value
        )

    init {
        viewModelScope.launch {
            settingsRepository.appLanguage
                .collect { language ->
                    _state.update { it.copy(appLanguage = language) }
                }
        }
    }
}