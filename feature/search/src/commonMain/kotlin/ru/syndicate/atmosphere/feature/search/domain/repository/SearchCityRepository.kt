package ru.syndicate.atmosphere.feature.search.domain.repository

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.search.domain.model.City

internal interface SearchCityRepository {
    suspend fun searchCity(
        text: String,
        language: String
    ): ApiResponse<List<City>>
}