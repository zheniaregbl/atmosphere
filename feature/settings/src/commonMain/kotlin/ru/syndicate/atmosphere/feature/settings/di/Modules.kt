package ru.syndicate.atmosphere.feature.settings.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsScreen
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsViewModel
import ru.syndicate.atmosphere.core.data.repository.DefaultSettingsRepository
import ru.syndicate.atmosphere.core.domain.repository.SettingsRepository

val featureSettingsModule = module {
    singleOf(::DefaultSettingsRepository).bind<SettingsRepository>()
    viewModelOf(::SettingsViewModel)
}

val featureSettingsScreenModule = screenModule {
    register<SharedScreen.SettingsScreen> { SettingsScreen() }
}