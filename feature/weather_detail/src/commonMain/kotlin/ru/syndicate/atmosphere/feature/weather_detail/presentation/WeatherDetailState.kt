package ru.syndicate.atmosphere.feature.weather_detail.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.feature.weather_detail.domain.model.WeatherDetail

internal sealed class WeatherDetailScreenState {
    data object Idle : WeatherDetailScreenState()
    data object Loading : WeatherDetailScreenState()
    data class Success(val details: WeatherDetail) : WeatherDetailScreenState()
}

@Composable
internal fun WeatherDetailScreenState.DisplayResult(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    transitionSpec: AnimatedContentTransitionScope<WeatherDetailScreenState>.() -> ContentTransform = {
        fadeIn() + scaleIn(
            animationSpec = spring(stiffness = Spring.StiffnessMedium),
            initialScale = .9f
        ) togetherWith ExitTransition.None
    },
    onIdle: (@Composable () -> Unit)? = null,
    onLoading: @Composable () -> Unit,
    onSuccess: @Composable (WeatherDetailScreenState.Success) -> Unit
) {

    AnimatedContent(
        targetState = this,
        transitionSpec = transitionSpec
    ) { state ->

        Box(
            modifier = modifier,
            contentAlignment = contentAlignment
        ) {

            when (state) {

                WeatherDetailScreenState.Idle -> onIdle?.invoke()

                WeatherDetailScreenState.Loading -> onLoading.invoke()

                is WeatherDetailScreenState.Success -> onSuccess.invoke(state)
            }
        }
    }
}

internal data class WeatherDetailState(
    val isLoading: Boolean = false,
    val details: WeatherDetail? = null,
    val currentLocation: CurrentLocation = CurrentLocation(),
    val appLanguage: String = Locales.EN
) {

    fun toUiState(): WeatherDetailScreenState {
        return when {
            isLoading -> WeatherDetailScreenState.Loading
            details != null -> WeatherDetailScreenState.Success(details)
            else -> WeatherDetailScreenState.Idle
        }
    }
}