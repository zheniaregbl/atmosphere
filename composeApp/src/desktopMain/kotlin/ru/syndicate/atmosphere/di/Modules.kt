package ru.syndicate.atmosphere.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.datastore.DATA_STORE_FILE_NAME
import ru.syndicate.atmosphere.core.datastore.createDataStore

val desktopModule = module {
    single<DataStore<Preferences>> {
        createDataStore { DATA_STORE_FILE_NAME }
    }
}

val desktopPlatformModules = listOf(desktopModule)