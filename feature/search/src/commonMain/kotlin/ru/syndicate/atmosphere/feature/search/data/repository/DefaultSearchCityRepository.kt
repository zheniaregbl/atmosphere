package ru.syndicate.atmosphere.feature.search.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.syndicate.atmosphere.core.data.mapper.toDTO
import ru.syndicate.atmosphere.core.domain.DataError
import ru.syndicate.atmosphere.core.domain.Result
import ru.syndicate.atmosphere.core.domain.map
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.feature.search.data.mapper.toCity
import ru.syndicate.atmosphere.feature.search.data.network.RemoteSearchCityDataSource
import ru.syndicate.atmosphere.feature.search.domain.model.City
import ru.syndicate.atmosphere.feature.search.domain.repository.SearchCityRepository

internal class DefaultSearchCityRepository(
    private val remoteSearchCityDataSource: RemoteSearchCityDataSource,
    private val dataStore: DataStore<Preferences>
): SearchCityRepository {

    override suspend fun searchCity(text: String): Result<List<City>, DataError.Remote> {
        return remoteSearchCityDataSource
            .searchCity(text)
            .map { dto ->
                dto
                    .cityList?.map { it.toCity() } ?: emptyList()
            }
    }

    override suspend fun saveSelectedCity(location: CurrentLocation) {
        val locationKey = stringPreferencesKey("selected_location")
        dataStore.edit {
            val saveLocation = Json.encodeToString(location.toDTO())
            it[locationKey] = saveLocation
            println("saved location : $saveLocation")
        }
    }
}