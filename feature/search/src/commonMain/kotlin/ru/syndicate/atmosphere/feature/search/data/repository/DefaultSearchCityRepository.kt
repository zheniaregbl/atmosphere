package ru.syndicate.atmosphere.feature.search.data.repository

import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.core.domain.map
import ru.syndicate.atmosphere.feature.search.data.mapper.toCity
import ru.syndicate.atmosphere.feature.search.data.network.RemoteSearchCityDataSource
import ru.syndicate.atmosphere.feature.search.domain.model.City
import ru.syndicate.atmosphere.feature.search.domain.repository.SearchCityRepository

internal class DefaultSearchCityRepository(
    private val remoteSearchCityDataSource: RemoteSearchCityDataSource,
): SearchCityRepository {

    override suspend fun searchCity(
        text: String,
        language: String
    ): Result<List<City>, DataError.Remote> {
        return remoteSearchCityDataSource
            .searchCity(
                name = text,
                language = language
            )
            .map { dto ->
                dto.cityList?.map { it.toCity() } ?: emptyList()
            }
    }
}