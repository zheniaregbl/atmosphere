package ru.syndicate.atmosphere.feature.weather_detail.data.network

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.feature.weather_detail.data.dto.RealDateTimeResponseDTO

internal interface RemoteDateTimeSource {
    suspend fun getDateTimeByTimeZone(
        timeZone: String
    ): ApiResponse<RealDateTimeResponseDTO>
}