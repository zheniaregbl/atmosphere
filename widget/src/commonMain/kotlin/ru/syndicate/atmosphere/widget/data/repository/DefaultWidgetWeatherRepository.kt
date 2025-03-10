package ru.syndicate.atmosphere.widget.data.repository

import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.first
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.syndicate.atmosphere.core.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.widget.domain.model.WeatherWidgetInfo
import ru.syndicate.atmosphere.widget.domain.repository.WidgetWeatherRepository
import kotlin.math.roundToInt

class DefaultWidgetWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val settingsRepository: SettingsRepository
): WidgetWeatherRepository {

    override suspend fun getWidgetWeather(): WeatherWidgetInfo {

        val location = settingsRepository.currentLocation.first()
        val appLanguage = settingsRepository.appLanguage.first()
        val response = remoteWeatherDataSource.getWidgetWeather(location.latitude, location.longitude, location.timeZone)
        val currentDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

        return when (response) {
            is ApiResponse.Failure.Error -> WeatherWidgetInfo(
                lastUpdateTime = currentDateTime,
                appLanguage = appLanguage
            )
            is ApiResponse.Failure.Exception -> WeatherWidgetInfo(
                lastUpdateTime = currentDateTime,
                appLanguage = appLanguage
            )
            is ApiResponse.Success -> WeatherWidgetInfo(
                currentTemperature = response.data.currentParameters.temperature.roundToInt(),
                maxTemperature = response.data.dailyParameters.maxTemperature.first().roundToInt(),
                minTemperature = response.data.dailyParameters.minTemperature.first().roundToInt(),
                weatherCode = response.data.currentParameters.weatherCode,
                lastUpdateTime = currentDateTime,
                appLanguage = appLanguage
            )
        }
    }
}