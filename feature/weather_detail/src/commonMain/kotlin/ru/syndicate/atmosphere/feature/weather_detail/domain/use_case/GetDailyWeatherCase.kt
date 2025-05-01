package ru.syndicate.atmosphere.feature.weather_detail.domain.use_case

import com.skydoves.sandwich.ApiResponse
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.until
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.WeatherRepository

internal class GetDailyWeatherCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(currentLocation: CurrentLocation): CaseResult<WeatherDetail> {

        return when (
            val response = weatherRepository
                .getDailyWeather(
                    currentLocation.latitude,
                    currentLocation.longitude,
                    currentLocation.timeZone
                )
        ) {

            is ApiResponse.Success<WeatherDetail> -> {

                val timeZone = TimeZone.of(currentLocation.timeZone)
                val now = Clock.System.now().toLocalDateTime(timeZone)
                val sunInfo = response.data.sunInfo

                val (start, end, offset) = when {
                    now.time >= sunInfo.sunrise.time && now.time <= sunInfo.sunset.time ->
                        Triple(sunInfo.sunrise, sunInfo.sunset, 0f)
                    now.time > sunInfo.sunset.time ->
                        Triple(sunInfo.sunset, sunInfo.nextDaySunrise, 0.5f)
                    else ->
                        Triple(sunInfo.previousDaySunset, sunInfo.sunrise, 0.5f)
                }

                val startInstant = start.toInstant(timeZone)
                val endInstant = end.toInstant(timeZone)
                val nowInstant = now.toInstant(timeZone)

                val totalMinutes = startInstant.until(endInstant, DateTimeUnit.MINUTE)
                val remainingMinutes = nowInstant.until(endInstant, DateTimeUnit.MINUTE)
                val percentage = 0.5f * ((totalMinutes.toFloat() - remainingMinutes.toFloat()) / totalMinutes.toFloat()) + offset

                CaseResult.Success(response.data.copy(
                    sunInfo = response.data.sunInfo.copy(percentage = percentage)
                ))
            }

            else -> CaseResult.Error()
        }
    }
}