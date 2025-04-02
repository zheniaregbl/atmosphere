package ru.syndicate.atmosphere.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.datastore.createDataStore
import ru.syndicate.atmosphere.core.presentation.PlatformBatterySettings
import ru.syndicate.atmosphere.widget.domain.WidgetManager

val iosModule = module {
    single<DataStore<Preferences>> { createDataStore() }
    single<WidgetManager> { WidgetManager() }
    single<PlatformBatterySettings> { PlatformBatterySettings() }
}

val iosPlatformModules = listOf(iosModule)