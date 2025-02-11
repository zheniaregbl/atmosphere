package ru.syndicate.atmosphere.core.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation

interface SettingsRepository {
    val currentLocation: Flow<CurrentLocation>
    val appLanguage: Flow<String>
    suspend fun saveSelectedCity(location: CurrentLocation)
    suspend fun changeSearchLanguage(language: String)
}