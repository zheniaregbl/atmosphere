package ru.syndicate.atmosphere.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.datastore.createDataStore
import ru.syndicate.atmosphere.core.presentation.PlatformBatterySettings
import ru.syndicate.atmosphere.widget.domain.WidgetManager

fun androidModule(context: Context) = module {
    single<DataStore<Preferences>> { createDataStore(context) }
    single<WidgetManager> { WidgetManager(context) }
    single<PlatformBatterySettings> { PlatformBatterySettings(context) }
}

fun androidPlatformModules(context: Context) = listOf(androidModule(context))