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
import ru.syndicate.atmosphere.core.domain.onError
import ru.syndicate.atmosphere.core.domain.onSuccess
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository

internal class HomeViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())

    val state = _state
        .onStart { getHourlyWeather() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.UpdateWeatherInfo -> getHourlyWeather()
        }
    }

    private fun getHourlyWeather() = viewModelScope.launch {

        _state.update { it.copy(isLoading = true) }

        delay(2000)

        weatherRepository.getHourlyWeather()
            .onSuccess { weatherInfo ->
                _state.update { it.copy(
                    isLoading = false,
                    weatherInfo = weatherInfo
                ) }
            }
            .onError {
                println("error: ${it.name}")
                _state.update { it.copy(
                    isLoading = false
                ) }
            }
    }
}