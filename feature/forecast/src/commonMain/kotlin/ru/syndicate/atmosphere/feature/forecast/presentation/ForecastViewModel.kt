package ru.syndicate.atmosphere.feature.forecast.presentation

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
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.domain.use_case.GetForecastWeatherCase

internal class ForecastViewModel(
    private val settingsRepository: SettingsRepository,
    private val getForecastWeatherCase: GetForecastWeatherCase
) : ViewModel() {

    private val _state = MutableStateFlow(ForecastState())
    val state = _state
        .onStart { getForecastWeather() }
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

    fun onAction(action: ForecastAction) {
        when (action) {
            ForecastAction.OnUpdate -> getForecastWeather()
        }
    }

    private fun getForecastWeather() = viewModelScope.launch {

        _state.update { it.copy(
            isLoading = true,
            showErrorContent = false
        ) }

        delay(200)

        when (val result = getForecastWeatherCase(_state.value.currentLocation)) {
            is CaseResult.Error ->
                _state.update { it.copy(
                    isLoading = false,
                    showErrorContent = true
                ) }
            is CaseResult.Success<List<DailyForecast>> ->
                _state.update { it.copy(
                    isLoading = false,
                    forecasts = result.data
                ) }
        }
    }
}