package ru.syndicate.atmosphere.feature.onboarding.presentation

internal sealed interface OnboardingAction {
    data class OnChangeSearchLanguage(val language: String) : OnboardingAction
    data object NavigateToSearch : OnboardingAction
}