package ru.syndicate.atmosphere.feature.search.data.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapFailure
import com.skydoves.sandwich.mapSuccess
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
    ): ApiResponse<List<City>> {
        return remoteSearchCityDataSource
            .searchCity(
                name = text,
                language = language
            )
            .mapSuccess { this.cityList!!.map { it.toCity() } }
    }
}