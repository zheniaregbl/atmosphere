package ru.syndicate.atmosphere.feature.weather_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.use_case.GetDailyWeatherCase

internal class WeatherDetailViewModel(
    private val getDailyWeatherCase: GetDailyWeatherCase,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherDetailState())
    val state = _state
        .onStart { getDailyWeather() }
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

        viewModelScope.launch {
            settingsRepository.currentLocation
                .collect { currentLocation ->
                    _state.update { it.copy(currentLocation = currentLocation) }
                }
        }
    }

    fun onAction(action: WeatherDetailAction) {
        when (action) {
            WeatherDetailAction.OnUpdate -> getDailyWeather()
        }
    }

    private fun getDailyWeather() = viewModelScope.launch {

        _state.update { it.copy(
            isLoading = true,
            showErrorContent = false
        ) }

        delay(1000)

        when (val result = getDailyWeatherCase(_state.value.currentLocation)) {
            is CaseResult.Error ->
                _state.update { it.copy(
                    isLoading = false,
                    showErrorContent = true
                ) }
            is CaseResult.Success<WeatherDetail> ->
                _state.update { it.copy(
                    isLoading = false,
                    details = result.data
                ) }
        }
    }
}