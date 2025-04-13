package ru.syndicate.atmosphere.feature.weather_detail.domain.use_case

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail
import ru.syndicate.atmosphere.feature.weather_detail.domain.repository.WeatherRepository

internal class GetDailyWeatherCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(currentLocation: CurrentLocation): CaseResult<WeatherDetail> {
        return when (
            val response = weatherRepository.getDailyWeather(
                currentLocation.latitude,
                currentLocation.longitude,
                currentLocation.timeZone
            )
        ) {
            is ApiResponse.Failure.Error -> CaseResult.Error()
            is ApiResponse.Failure.Exception -> CaseResult.Error()
            is ApiResponse.Success<WeatherDetail> -> CaseResult.Success(response.data)
        }
    }
}