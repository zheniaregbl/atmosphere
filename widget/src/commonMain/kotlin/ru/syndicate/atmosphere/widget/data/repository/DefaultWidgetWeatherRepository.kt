package ru.syndicate.atmosphere.widget.data.repository

import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import ru.syndicate.atmosphere.core.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.widget.domain.model.WidgetWeatherInfo
import ru.syndicate.atmosphere.widget.domain.repository.WidgetWeatherRepository
import kotlin.math.roundToInt

class DefaultWidgetWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val settingsRepository: SettingsRepository
): WidgetWeatherRepository {

    override suspend fun getWidgetWeather(): WidgetWeatherInfo {

        val location = settingsRepository.currentLocation.first()
        val response = remoteWeatherDataSource.getHourlyWeather(location.latitude, location.longitude, location.timeZone)

        return when (response) {
            is ApiResponse.Failure.Error -> WidgetWeatherInfo()
            is ApiResponse.Failure.Exception -> WidgetWeatherInfo()
            is ApiResponse.Success -> WidgetWeatherInfo(response.data.currentParameters.temperature.roundToInt())
        }
    }
}