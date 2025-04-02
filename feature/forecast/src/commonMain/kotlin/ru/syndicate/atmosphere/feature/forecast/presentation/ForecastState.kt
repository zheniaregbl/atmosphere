package ru.syndicate.atmosphere.feature.forecast.presentation

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
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast

internal sealed class ForecastScreenState {
    data object Idle : ForecastScreenState()
    data object Loading : ForecastScreenState()
    data class Success(val forecasts: List<DailyForecast>) : ForecastScreenState()
    data object Error : ForecastScreenState()
}

@Composable
internal fun ForecastScreenState.DisplayResult(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    transitionSpec: AnimatedContentTransitionScope<ForecastScreenState>.() -> ContentTransform = {
        fadeIn() + scaleIn(
            animationSpec = spring(stiffness = Spring.StiffnessMedium),
            initialScale = .9f
        ) togetherWith ExitTransition.None
    },
    onIdle: (@Composable () -> Unit)? = null,
    onLoading: @Composable () -> Unit,
    onSuccess: @Composable (ForecastScreenState.Success) -> Unit,
    onError: @Composable () -> Unit
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

                ForecastScreenState.Idle -> onIdle?.invoke()

                ForecastScreenState.Loading -> onLoading.invoke()

                is ForecastScreenState.Success -> onSuccess.invoke(state)

                ForecastScreenState.Error -> onError.invoke()
            }
        }
    }
}

internal data class ForecastState(
    val isLoading: Boolean = false,
    private val showErrorContent: Boolean = false,
    val forecasts: List<DailyForecast>? = null,
    val currentLocation: CurrentLocation = CurrentLocation(),
    val appLanguage: String = Locales.EN
) {

    fun toUiState(): ForecastScreenState {
        return when {
            isLoading -> ForecastScreenState.Loading
            showErrorContent -> ForecastScreenState.Error
            forecasts != null -> ForecastScreenState.Success(forecasts)
            else -> ForecastScreenState.Idle
        }
    }
}