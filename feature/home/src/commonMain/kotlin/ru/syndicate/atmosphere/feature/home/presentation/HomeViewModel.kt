package ru.syndicate.atmosphere.feature.home.presentation

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
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository
import ru.syndicate.atmosphere.feature.home.domain.use_case.GetHourlyWeatherCase
import ru.syndicate.atmosphere.widget.domain.WidgetManager

internal class HomeViewModel(
    private val weatherRepository: WeatherRepository,
    private val getHourlyWeatherCase: GetHourlyWeatherCase,
    private val settingsRepository: SettingsRepository,
    private val widgetManager: WidgetManager
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .onStart { getHourlyWeather() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(30_000L),
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
                    if (currentLocation.latitude != _state.value.currentLocation.latitude
                        || currentLocation.longitude != _state.value.currentLocation.longitude) {
                        widgetManager.updateWidget()
                        getHourlyWeather()
                    }
                    _state.update { it.copy(currentLocation = currentLocation) }
                }
        }
    }

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.UpdateWeatherInfo -> viewModelScope.launch { getHourlyWeather() }
            HomeAction.OnCloseErrorDialog -> _state.update { it.copy(showErrorDialog = false) }
            else -> Unit
        }
    }

    private fun getHourlyWeather() = viewModelScope.launch {

        _state.update { it.copy(isLoading = true) }

        delay(2000)

        when (val result = getHourlyWeatherCase(_state.value.currentLocation)) {
            is CaseResult.Error ->
                _state.update { it.copy(
                    isLoading = false,
                    errorMessageCode = result.errorMessageCode,
                    showErrorDialog = true
                ) }
            is CaseResult.Success<WeatherInfo> ->
                _state.update { it.copy(
                    isLoading = false,
                    weatherInfo = result.data
                ) }
        }
    }
}