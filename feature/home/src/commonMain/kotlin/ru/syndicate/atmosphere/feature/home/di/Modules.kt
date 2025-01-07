package ru.syndicate.atmosphere.feature.home.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.syndicate.atmosphere.feature.home.data.network.RemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.data.network.KtorRemoteWeatherDataSource
import ru.syndicate.atmosphere.feature.home.data.repository.DefaultWeatherRepository
import ru.syndicate.atmosphere.feature.home.domain.repository.WeatherRepository
import ru.syndicate.atmosphere.feature.home.presentation.HomeViewModel

val homeModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    singleOf(::KtorRemoteWeatherDataSource).bind<RemoteWeatherDataSource>()
    singleOf(::DefaultWeatherRepository).bind<WeatherRepository>()

    viewModelOf(::HomeViewModel)
}