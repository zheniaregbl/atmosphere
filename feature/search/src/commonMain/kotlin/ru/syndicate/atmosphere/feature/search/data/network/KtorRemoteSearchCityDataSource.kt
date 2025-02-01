package ru.syndicate.atmosphere.feature.search.data.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import ru.syndicate.atmosphere.feature.search.data.dto.SearchCityResponseDTO

private const val BASE_URL = "https://geocoding-api.open-meteo.com/v1/search"

internal class KtorRemoteSearchCityDataSource(
    private val httpClient: HttpClient
): RemoteSearchCityDataSource {

    override suspend fun searchCity(
        name: String,
        count: Int,
        language: String
    ): ApiResponse<SearchCityResponseDTO> {
        return httpClient.getApiResponse(BASE_URL) {
            parameter("name", name)
            parameter("count", count)
            parameter("language", language)
            parameter("format", "json")
        }
    }
}