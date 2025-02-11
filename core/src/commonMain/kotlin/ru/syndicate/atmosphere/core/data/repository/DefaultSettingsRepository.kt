package ru.syndicate.atmosphere.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.syndicate.atmosphere.core.data.dto.CurrentLocationDTO
import ru.syndicate.atmosphere.core.data.mapper.toDTO
import ru.syndicate.atmosphere.core.data.mapper.toModel
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository
import ru.syndicate.atmosphere.core.presentation.translation.Locales

class DefaultSettingsRepository(
    private val dataStore: DataStore<Preferences>
): SettingsRepository {

    private object PreferenceKeys {
        val locationKey = stringPreferencesKey("selected_location")
        val appLanguageKey = stringPreferencesKey("app_language")
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

    override val appLanguage: Flow<String> = dataStore
        .data
        .map {
            if (it[PreferenceKeys.appLanguageKey].isNullOrBlank()) Locales.EN
            else it[PreferenceKeys.appLanguageKey]!!
        }

    override suspend fun saveSelectedCity(location: CurrentLocation) {
        dataStore.edit { it[PreferenceKeys.locationKey] = Json.encodeToString(location.toDTO()) }
    }

    override suspend fun changeSearchLanguage(language: String) {
        dataStore.edit { it[PreferenceKeys.appLanguageKey] = language }
    }
}