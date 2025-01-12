package ru.syndicate.atmosphere.feature.home.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import ru.syndicate.atmosphere.core.data.dto.CurrentLocationDTO
import ru.syndicate.atmosphere.core.data.mapper.toModel
import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.core.domain.map
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.feature.home.data.mapper.toCurrentWeatherParameters
import ru.syndicate.atmosphere.feature.home.data.mapper.toHourlyWeather
import ru.syndicate.atmosphere.feature.home.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository

internal class DefaultWeatherRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val dataStore: DataStore<Preferences>
): WeatherRepository {

    private object PreferenceKeys {
        val locationKey = stringPreferencesKey("selected_location")
    }

    override val currentLocation: Flow<CurrentLocation> = dataStore
        .data
        .map {
            if (it[PreferenceKeys.locationKey].isNullOrBlank()) {
                CurrentLocation()
            } else {
                Json.decodeFromString<CurrentLocationDTO>(it[PreferenceKeys.locationKey]!!)
                    .toModel()
            }
        }

    override suspend fun getCurrentLocation(): CurrentLocation {

        var savedLocation = CurrentLocation()

        dataStore.edit {
            if (!it[PreferenceKeys.locationKey].isNullOrBlank()) {
                savedLocation = Json
                    .decodeFromString<CurrentLocationDTO>(it[PreferenceKeys.locationKey]!!)
                    .toModel()
            }
        }

        return savedLocation
    }

    override suspend fun getHourlyWeather(
        latitude: Double,
        longitude: Double,
        timeZone: String
    ): Result<WeatherInfo, DataError.Remote> {
        return remoteWeatherDataSource
            .getHourlyWeather(latitude, longitude, timeZone)
            .map { dto ->
                WeatherInfo(
                    currentWeatherParameters = dto.currentParameters.toCurrentWeatherParameters(),
                    hourlyWeather = dto.hourlyParameters.toHourlyWeather()
                )
            }
    }
}