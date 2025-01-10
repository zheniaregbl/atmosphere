package ru.syndicate.atmosphere.feature.home.di

import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ru.syndicate.atmosphere.navigation.featureSearchModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(homeModule)
        ScreenRegistry { featureSearchModule }
    }
}