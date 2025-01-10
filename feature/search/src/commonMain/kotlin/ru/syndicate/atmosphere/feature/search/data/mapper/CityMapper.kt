package ru.syndicate.atmosphere.feature.search.data.mapper

import ru.syndicate.atmosphere.feature.search.data.dto.SearchCityDTO
import ru.syndicate.atmosphere.feature.search.domain.model.City

fun SearchCityDTO.toCity() = City(
    title, country ?: "", countryCode, timeZone, latitude, longitude
)