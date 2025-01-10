package ru.syndicate.atmosphere.feature.search.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.feature.search.data.network.KtorRemoteSearchCityDataSource
import ru.syndicate.atmosphere.feature.search.data.network.RemoteSearchCityDataSource
import ru.syndicate.atmosphere.feature.search.data.repository.DefaultSearchCityRepository
import ru.syndicate.atmosphere.feature.search.domain.repository.SearchCityRepository
import ru.syndicate.atmosphere.feature.search.presentation.CityListViewModel

val searchModule = module {
    singleOf(::KtorRemoteSearchCityDataSource).bind<RemoteSearchCityDataSource>()
    singleOf(::DefaultSearchCityRepository).bind<SearchCityRepository>()

    viewModelOf(::CityListViewModel)
}