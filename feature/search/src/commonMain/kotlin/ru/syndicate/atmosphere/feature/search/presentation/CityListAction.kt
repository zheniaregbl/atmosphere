package ru.syndicate.atmosphere.feature.search.presentation

import ru.syndicate.atmosphere.feature.search.domain.model.City

internal sealed interface CityListAction {
    data class OnSearchCityChange(val cityName: String) : CityListAction
    data class OnCityClick(val city: City) : CityListAction
    data object ClearData : CityListAction
}