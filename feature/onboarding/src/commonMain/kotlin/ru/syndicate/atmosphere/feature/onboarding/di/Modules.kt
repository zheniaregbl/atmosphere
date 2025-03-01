package ru.syndicate.atmosphere.feature.onboarding.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.onboarding.presentation.OnboardingScreen
import ru.syndicate.atmosphere.feature.onboarding.presentation.OnboardingViewModel

val featureOnboardingModule = module {
    viewModelOf(::OnboardingViewModel)
}

val featureOnboardingScreenModule = screenModule {
    register<SharedScreen.OnboardingScreen> { OnboardingScreen() }
}