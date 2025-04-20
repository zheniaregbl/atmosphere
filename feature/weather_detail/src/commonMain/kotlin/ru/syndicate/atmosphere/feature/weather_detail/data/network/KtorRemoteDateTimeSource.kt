package ru.syndicate.atmosphere.feature.weather_detail.data.network

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import ru.syndicate.atmosphere.feature.weather_detail.data.dto.RealDateTimeResponseDTO

private const val BASE_URL = "https://timeapi.io/api/time/current/zone"

internal class KtorRemoteDateTimeSource(
    private val httpClient: HttpClient
): RemoteDateTimeSource {
    override suspend fun getDateTimeByTimeZone(
        timeZone: String
    ): ApiResponse<RealDateTimeResponseDTO> {
        return httpClient.getApiResponse(BASE_URL) {
            parameter("timeZone", timeZone)
        }
    }
}