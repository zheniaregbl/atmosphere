package ru.syndicate.atmosphere.feature.weather_detail.domain.repository

import com.skydoves.sandwich.ApiResponse
import kotlinx.datetime.LocalDateTime

internal interface TimeRepository {
    suspend fun getDateTimeByTimeZone(timeZone: String): ApiResponse<LocalDateTime>
}