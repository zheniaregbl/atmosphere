package ru.syndicate.atmosphere.feature.search.data.network

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.search.data.dto.SearchCityResponseDTO

internal interface RemoteSearchCityDataSource {

    suspend fun searchCity(
        name: String,
        count: Int = 50,
        language: String = "en"
    ): ApiResponse<SearchCityResponseDTO>
}