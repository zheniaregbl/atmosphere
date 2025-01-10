package ru.syndicate.atmosphere.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import ru.syndicate.atmosphere.core.di.networkModule
import ru.syndicate.atmosphere.feature.home.di.homeModule
import ru.syndicate.atmosphere.feature.search.di.searchModule

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(networkModule, homeModule, searchModule)
    }
}