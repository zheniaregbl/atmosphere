package ru.syndicate.atmosphere.feature.splash.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.syndicate.atmosphere.feature.splash.presentation.LaunchViewModel

val featureSplashModule = module {
    viewModelOf(::LaunchViewModel)
}