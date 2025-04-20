package ru.syndicate.atmosphere.feature.weather_detail.domain.use_case

import com.skydoves.sandwich.ApiResponse
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.until
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.TimeRepository
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.WeatherRepository

internal class GetDailyWeatherCase(
    private val weatherRepository: WeatherRepository,
    private val timeRepository: TimeRepository
) {
    suspend operator fun invoke(currentLocation: CurrentLocation): CaseResult<WeatherDetail> {

        val weatherResponse = weatherRepository.getDailyWeather(
            currentLocation.latitude,
            currentLocation.longitude,
            currentLocation.timeZone
        )
        val timeResponse = timeRepository.getDateTimeByTimeZone(currentLocation.timeZone)

        return when {

            weatherResponse is ApiResponse.Success<WeatherDetail> &&
                    timeResponse is ApiResponse.Success<LocalDateTime> -> {

                        val timeZone = TimeZone.of(currentLocation.timeZone)

                        val instant1 = weatherResponse.data.sunInfo.sunrise.toInstant(timeZone)
                        val instant2 = weatherResponse.data.sunInfo.nextDaySunrise.toInstant(timeZone)
                        val currentInstant = timeResponse.data.toInstant(timeZone)

                        val difference1 = instant1.until(instant2, DateTimeUnit.MINUTE).toFloat()
                        val difference2 = currentInstant.until(instant2, DateTimeUnit.MINUTE).toFloat()

                        CaseResult.Success(weatherResponse.data.copy(
                            sunInfo = weatherResponse.data.sunInfo.copy(
                                percentage = 1.0f - (difference2 / difference1)
                            )
                        ))
                    }

            else -> CaseResult.Error()
        }
    }
}