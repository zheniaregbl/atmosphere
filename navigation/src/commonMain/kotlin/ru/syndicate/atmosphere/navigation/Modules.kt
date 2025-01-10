package ru.syndicate.atmosphere.navigation

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.atmosphere.feature.search.presentation.SearchScreen

val featureSearchModule = screenModule {
    register<SharedScreen.SearchScreen> { SearchScreen() }
}