package ru.syndicate.atmosphere.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.datastore.DATA_STORE_FILE_NAME
import ru.syndicate.atmosphere.core.datastore.createDataStore
import ru.syndicate.atmosphere.core.presentation.PlatformBatterySettings
import ru.syndicate.atmosphere.widget.domain.WidgetManager

val desktopModule = module {
    single<DataStore<Preferences>> { createDataStore { DATA_STORE_FILE_NAME } }
    single<WidgetManager> { WidgetManager() }
    single<PlatformBatterySettings> { PlatformBatterySettings() }
}

val desktopPlatformModules = listOf(desktopModule)