package ru.syndicate.atmosphere.feature.home.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.syndicate.atmosphere.feature.home.domain.model.WeatherInfo

sealed class HomeScreenState {
    data object Idle : HomeScreenState()
    data object Loading : HomeScreenState()
    data class Error(val errorMessage: String) : HomeScreenState()
    data class Success(val weatherInfo: WeatherInfo) : HomeScreenState()
}

@Composable
fun HomeScreenState.DisplayResult(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    transitionSpec: AnimatedContentTransitionScope<HomeScreenState>.() -> ContentTransform = {
        fadeIn(tween(durationMillis = 200)) togetherWith
                ExitTransition.None
    },
    onIdle: (@Composable () -> Unit)? = null,
    onLoading: @Composable () -> Unit,
    onSuccess: @Composable (HomeScreenState.Success) -> Unit,
    onSuccessBox: (@Composable BoxScope.(HomeScreenState.Success) -> Unit)? = null,
    onError: @Composable (HomeScreenState.Error) -> Unit
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

                is HomeScreenState.Error -> onError.invoke(state)

                HomeScreenState.Idle -> onIdle?.invoke()

                HomeScreenState.Loading -> onLoading.invoke()

                is HomeScreenState.Success -> if (onSuccessBox != null) onSuccessBox(state)
                else onSuccess.invoke(state)
            }
        }
    }
}

data class HomeState(
    val isLoading: Boolean = false,
    val weatherInfo: WeatherInfo = WeatherInfo()
) {

    fun toUiState(): HomeScreenState {
        return if (isLoading) HomeScreenState.Loading
        else HomeScreenState.Success(weatherInfo)
    }
}