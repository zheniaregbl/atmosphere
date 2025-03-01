package ru.syndicate.atmosphere.feature.search.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.search.data.network.KtorRemoteSearchCityDataSource
import ru.syndicate.atmosphere.feature.search.data.network.RemoteSearchCityDataSource
import ru.syndicate.atmosphere.feature.search.data.repository.DefaultSearchCityRepository
import ru.syndicate.atmosphere.feature.search.domain.repository.SearchCityRepository
import ru.syndicate.atmosphere.feature.search.presentation.CityListViewModel
import ru.syndicate.atmosphere.feature.search.presentation.SearchScreen

val featureSearchModule = module {
    singleOf(::KtorRemoteSearchCityDataSource).bind<RemoteSearchCityDataSource>()
    singleOf(::DefaultSearchCityRepository).bind<SearchCityRepository>()

    viewModelOf(::CityListViewModel)
}

val featureSearchScreenModule = screenModule {
    register<SharedScreen.SearchScreen> { provider -> SearchScreen(provider.isInitSelect) }
}