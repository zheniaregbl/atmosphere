package ru.syndicate.atmosphere.feature.settings.di

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsScreen

val featureSettingsScreenModule = screenModule {
    register<SharedScreen.SettingsScreen> { SettingsScreen() }
}