package ru.syndicate.atmosphere.feature.search.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ru.syndicate.atmosphere.core.data.safeCall
import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.feature.search.data.dto.SearchCityResponseDTO

private const val BASE_URL = "https://geocoding-api.open-meteo.com/v1/search"

class KtorRemoteSearchCityDataSource(
    private val httpClient: HttpClient
): RemoteSearchCityDataSource {

    override suspend fun searchCity(
        name: String,
        count: Int,
        language: String
    ): Result<SearchCityResponseDTO, DataError.Remote> {
        return safeCall<SearchCityResponseDTO> {
            httpClient.get(urlString = BASE_URL) {
                parameter("name", name)
                parameter("count", count)
                parameter("language", language)
                parameter("format", "json")
            }
        }
    }
}