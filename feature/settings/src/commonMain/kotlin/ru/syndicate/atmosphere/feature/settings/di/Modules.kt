package ru.syndicate.atmosphere.feature.settings.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsScreen
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsViewModel

val featureSettingsModule = module { viewModelOf(::SettingsViewModel) }

val featureSettingsScreenModule = screenModule {
    register<SharedScreen.SettingsScreen> { SettingsScreen() }
}