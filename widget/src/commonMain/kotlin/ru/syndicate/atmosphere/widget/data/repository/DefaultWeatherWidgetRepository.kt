package ru.syndicate.atmosphere.widget.data.repository

import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.first
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.syndicate.atmosphere.core.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.widget.domain.model.ShortWeatherWidgetInfo
import ru.syndicate.atmosphere.widget.domain.repository.WeatherWidgetRepository
import kotlin.math.roundToInt

internal class DefaultWeatherWidgetRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val settingsRepository: SettingsRepository
): WeatherWidgetRepository {

    override suspend fun getWidgetWeather(): ShortWeatherWidgetInfo {

        val location = settingsRepository.currentLocation.first()
        val appLanguage = settingsRepository.appLanguage.first()
        val response = remoteWeatherDataSource.getWidgetWeather(location.latitude, location.longitude, location.timeZone)
        val currentDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

        return when (response) {
            is ApiResponse.Failure.Error -> ShortWeatherWidgetInfo(
                lastUpdateDateTime = currentDateTime.toString(),
                appLanguage = appLanguage,
                isError = true
            )
            is ApiResponse.Failure.Exception -> ShortWeatherWidgetInfo(
                lastUpdateDateTime = currentDateTime.toString(),
                appLanguage = appLanguage,
                isError = true
            )
            is ApiResponse.Success -> ShortWeatherWidgetInfo(
                currentTemperature = response.data.currentParameters.temperature.roundToInt(),
                maxTemperature = response.data.dailyParameters.maxTemperature.first().roundToInt(),
                minTemperature = response.data.dailyParameters.minTemperature.first().roundToInt(),
                weatherCode = response.data.currentParameters.weatherCode,
                isDay = response.data.currentParameters.isDay == 1,
                lastUpdateDateTime = currentDateTime.toString(),
                appLanguage = appLanguage
            )
        }
    }
}