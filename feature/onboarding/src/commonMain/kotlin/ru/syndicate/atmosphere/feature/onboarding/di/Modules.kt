package ru.syndicate.atmosphere.feature.onboarding.di

import cafe.adriel.voyager.core.registry.screenModule
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.onboarding.presentation.OnboardingScreen

val featureOnboardingScreenModule = screenModule {
    register<SharedScreen.OnboardingScreen> { OnboardingScreen() }
}