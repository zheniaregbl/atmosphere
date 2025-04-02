package ru.syndicate.atmosphere.core.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation

interface SettingsRepository {
    val launchAppType: Flow<String>
    val currentLocation: Flow<CurrentLocation>
    val appLanguage: Flow<String>
    val widgetTiming: Flow<Int>
    suspend fun changeAppLaunchAppType(type: String)
    suspend fun saveSelectedCity(location: CurrentLocation)
    suspend fun changeSearchLanguage(language: String)
    suspend fun changeWidgetTiming(timing: Int)
}