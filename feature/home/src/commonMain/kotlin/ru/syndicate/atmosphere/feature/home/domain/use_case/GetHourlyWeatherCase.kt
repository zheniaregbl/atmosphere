package ru.syndicate.atmosphere.feature.home.domain.use_case

import com.skydoves.sandwich.ApiResponse
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.use_case.CaseResult
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository
import ru.syndicate.atmosphere.feature.home.presentation.util.ErrorMessageCode

internal class GetHourlyWeatherCase(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(currentLocation: CurrentLocation): CaseResult<WeatherInfo> {
        return when (
            val response = weatherRepository.getHourlyWeather(
                currentLocation.latitude,
                currentLocation.longitude,
                currentLocation.timeZone
            )
        ) {
            is ApiResponse.Failure.Error -> CaseResult.Error(ErrorMessageCode.REQUEST_ERROR)
            is ApiResponse.Failure.Exception -> CaseResult.Error(ErrorMessageCode.REQUEST_EXCEPTION)
            is ApiResponse.Success<WeatherInfo> -> CaseResult.Success(response.data)
        }
    }
}