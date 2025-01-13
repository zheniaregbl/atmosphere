package ru.syndicate.atmosphere.feature.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.onError
import ru.syndicate.atmosphere.core.domain.onSuccess
import ru.syndicate.atmosphere.feature.search.domain.model.City
import ru.syndicate.atmosphere.feature.search.domain.repository.SearchCityRepository

internal class CityListViewModel(
    private val searchCityRepository: SearchCityRepository
): ViewModel() {

    private var searchJob: Job? = null

    private val _state = MutableStateFlow(CityListState())
    val state = _state
        .onStart { observeSearchCity() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: CityListAction) {

        when (action) {

            is CityListAction.OnSearchCityChange -> {
                _state.update { it.copy(
                    searchCityText = action.cityName
                ) }
            }

            is CityListAction.OnCityClick -> selectCity(action.city)

            CityListAction.ClearData -> _state.update { CityListState() }
        }
    }

    private fun observeSearchCity() {
        state
            .map { it.searchCityText }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { text ->

                when {

                    text.isBlank() -> {

                    }

                    text.length >= 2 -> {
                        searchJob?.cancel()
                        searchJob = searchCity(text)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun searchCity(text: String) = viewModelScope.launch {

        _state.update { it.copy(
            isLoading = true
        ) }

        searchCityRepository
            .searchCity(text)
            .onSuccess { searchCityList ->
                _state.update { it.copy(
                    isLoading = false,
                    searchCityList = searchCityList
                ) }
            }
            .onError {
                _state.update { it.copy(
                    searchCityList = emptyList(),
                    isLoading = false
                ) }
            }
    }

    private fun selectCity(city: City) = viewModelScope.launch {
        searchCityRepository.saveSelectedCity(
            CurrentLocation(
                title = city.title,
                timeZone = city.timeZone,
                latitude = city.latitude,
                longitude = city.longitude
            )
        )
        _state.update { it.copy(savedCity = CurrentLocation()) }
    }
}