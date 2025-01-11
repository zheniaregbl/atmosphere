package ru.syndicate.atmosphere.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import ru.syndicate.atmosphere.core.di.networkModule
import ru.syndicate.atmosphere.feature.home.di.homeModule
import ru.syndicate.atmosphere.feature.search.di.searchModule

fun initKoin(
    config: KoinAppDeclaration? = null,
    platformModules: List<Module> = emptyList()
) {
    startKoin {
        config?.invoke(this)
        modules(networkModule, homeModule, searchModule)
        modules(platformModules)
    }
}