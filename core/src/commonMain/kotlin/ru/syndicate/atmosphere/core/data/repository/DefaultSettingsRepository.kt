package ru.syndicate.atmosphere.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
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
import ru.syndicate.atmosphere.core.presentation.util.LaunchAppType

class DefaultSettingsRepository(
    private val dataStore: DataStore<Preferences>
): SettingsRepository {

    private object PreferenceKeys {
        val launchAppTypeKey = stringPreferencesKey("launch_app_type")
        val locationKey = stringPreferencesKey("selected_location")
        val appLanguageKey = stringPreferencesKey("app_language")
        val widgetTimingKey = intPreferencesKey("widget_timing")
    }

    override val launchAppType: Flow<String> = dataStore
        .data
        .map {
            if (it[PreferenceKeys.launchAppTypeKey].isNullOrBlank()) LaunchAppType.FIRST_LAUNCH
            else it[PreferenceKeys.launchAppTypeKey]!!
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

    override val widgetTiming: Flow<Int> = dataStore
        .data
        .map {
            if (it[PreferenceKeys.widgetTimingKey] == null) 15
            else it[PreferenceKeys.widgetTimingKey]!!
        }

    override suspend fun changeAppLaunchAppType(type: String) {
        dataStore.edit { it[PreferenceKeys.launchAppTypeKey] = type }
    }

    override suspend fun saveSelectedCity(location: CurrentLocation) {
        dataStore.edit { it[PreferenceKeys.locationKey] = Json.encodeToString(location.toDTO()) }
    }

    override suspend fun changeSearchLanguage(language: String) {
        dataStore.edit { it[PreferenceKeys.appLanguageKey] = language }
    }

    override suspend fun changeWidgetTiming(timing: Int) {
        dataStore.edit { it[PreferenceKeys.widgetTimingKey] = timing }
    }
}