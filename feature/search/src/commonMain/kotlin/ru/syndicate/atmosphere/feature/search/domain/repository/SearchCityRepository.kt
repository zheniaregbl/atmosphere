package ru.syndicate.atmosphere.feature.search.domain.repository

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.feature.search.domain.model.City

internal interface SearchCityRepository {
    suspend fun searchCity(
        text: String,
        language: String
    ): Result<List<City>, DataError.Remote>
}