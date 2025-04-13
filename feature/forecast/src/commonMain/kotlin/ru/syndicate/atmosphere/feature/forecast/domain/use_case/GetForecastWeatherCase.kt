package ru.syndicate.atmosphere.feature.forecast.domain.use_case

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.domain.repository.WeatherRepository

internal class GetForecastWeatherCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(
        currentLocation: CurrentLocation
    ): CaseResult<List<DailyForecast>> {
        return when (
            val response = weatherRepository.getForecastWeather(
                currentLocation.latitude,
                currentLocation.longitude,
                currentLocation.timeZone
            )
        ) {
            is ApiResponse.Success<List<DailyForecast>> -> CaseResult.Success(response.data)
            else -> CaseResult.Error()
        }
    }
}