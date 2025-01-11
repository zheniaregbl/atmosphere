package ru.syndicate.atmosphere.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.datastore.createDataStore

val iosModule = module {
    single<DataStore<Preferences>> {
        createDataStore()
    }
}

val iosPlatformModules = listOf(iosModule)