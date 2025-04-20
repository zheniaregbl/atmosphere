package ru.syndicate.atmosphere.feature.weather_detail.data.repository

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.mapSuccess
import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.feature.weather_detail.data.network.RemoteDateTimeSource
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.TimeRepository

internal class DefaultTimeRepository(
    private val remoteDateTimeSource: RemoteDateTimeSource
): TimeRepository {
    override suspend fun getDateTimeByTimeZone(timeZone: String): ApiResponse<LocalDateTime> {
        return remoteDateTimeSource
            .getDateTimeByTimeZone(timeZone)
            .mapSuccess { LocalDateTime.parse(value) }
    }
}