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
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.core.presentation.util.LaunchAppType
import ru.syndicate.atmosphere.feature.search.domain.model.City
import ru.syndicate.atmosphere.feature.search.domain.use_case.GetSearchCityCase

internal class CityListViewModel(
    private val getSearchCityCase: GetSearchCityCase,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private var searchJob: Job? = null

    private val _state = MutableStateFlow(CityListState())
    val state = _state
        .onStart { observeSearchCity() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private val _launchAppType = MutableStateFlow(LaunchAppType.FIRST_LAUNCH)

    init {

        viewModelScope.launch {
            settingsRepository.appLanguage
                .collect { language ->
                    _state.update { it.copy(appLanguage = language) }
                }
        }

        viewModelScope.launch {
            settingsRepository.launchAppType
                .collect { type -> _launchAppType.update { type } }
        }
    }

    fun onAction(action: CityListAction) {

        when (action) {

            is CityListAction.OnSearchCityChange -> {
                _state.update {
                    it.copy(
                        searchCityText = action.cityName
                    )
                }
            }

            is CityListAction.OnCityClick -> selectCity(action.city)
        }
    }

    private fun observeSearchCity() {
        state
            .map { it.searchCityText }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { text ->
                if (text.length >= 2) {
                    searchJob?.cancel()
                    searchJob = searchCity(text)
                }
            }
            .launchIn(viewModelScope)
    }

    private fun searchCity(text: String) = viewModelScope.launch {

        _state.update {
            it.copy(
                isLoading = true
            )
        }

        when (val result = getSearchCityCase(text, _state.value.appLanguage)) {
            is CaseResult.Error ->
                _state.update { it.copy(
                    isLoading = false,
                    searchCityList = emptyList(),
                    errorMessageCode = result.errorMessageCode
                ) }
            is CaseResult.Success<List<City>> ->
                _state.update { it.copy(
                    isLoading = false,
                    searchCityList = result.data
                ) }
        }
    }

    private fun selectCity(city: City) = viewModelScope.launch {

        if (_launchAppType.value == LaunchAppType.INIT_LOCATION) {
            settingsRepository.changeAppLaunchAppType(LaunchAppType.READY)
        }

        settingsRepository.saveSelectedCity(
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