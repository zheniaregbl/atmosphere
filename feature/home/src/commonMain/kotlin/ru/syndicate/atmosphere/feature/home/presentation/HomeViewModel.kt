package ru.syndicate.atmosphere.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skydoves.sandwich.ktor.statusCode
import com.skydoves.sandwich.messageOrNull
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository

internal class HomeViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state
        .onStart { getHourlyWeather() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(10_000L),
            _state.value
        )

    init {
        viewModelScope.launch {
            weatherRepository.currentLocation
                .collect { currentLocation ->
                    if (currentLocation.latitude != _state.value.currentLocation.latitude
                        || currentLocation.longitude != _state.value.currentLocation.longitude) {
                        getHourlyWeather()
                    }
                    _state.update { it.copy(currentLocation = currentLocation) }
                }
        }
    }

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.UpdateWeatherInfo -> viewModelScope.launch {
                getHourlyWeather()
            }
        }
    }

    private fun getHourlyWeather() = viewModelScope.launch {

        _state.update { it.copy(isLoading = true) }

        delay(2000)

        weatherRepository.getHourlyWeather(
            _state.value.currentLocation.latitude,
            _state.value.currentLocation.longitude,
            _state.value.currentLocation.timeZone
        )
            .onSuccess {
                _state.update { it.copy(
                    isLoading = false,
                    weatherInfo = data
                ) }
            }
            .onException {
                println("error: $messageOrNull")
                _state.update { it.copy(
                    isLoading = false
                ) }
            }
            .onError {
                println("error: ${statusCode.code}")
                _state.update { it.copy(
                    isLoading = false
                ) }
            }
    }
}