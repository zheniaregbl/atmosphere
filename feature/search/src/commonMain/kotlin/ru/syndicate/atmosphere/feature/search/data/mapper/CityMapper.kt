package ru.syndicate.atmosphere.feature.search.data.mapper

import ru.syndicate.atmosphere.feature.search.data.dto.SearchCityDTO
import ru.syndicate.atmosphere.feature.search.domain.model.City

private const val CIRCLE_FLAGS = "https://hatscripts.github.io/circle-flags/flags"

fun SearchCityDTO.toCity() = City(
    title = title,
    country = country ?: "",
    flagUrl = "$CIRCLE_FLAGS/${countryCode.lowercase()}.svg",
    timeZone = timeZone ?: "",
    latitude = latitude,
    longitude = longitude
)