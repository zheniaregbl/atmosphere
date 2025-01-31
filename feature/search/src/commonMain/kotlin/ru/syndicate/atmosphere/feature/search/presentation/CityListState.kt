package ru.syndicate.atmosphere.feature.search.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.syndicate.atmosphere.core.domain.model.CurrentLocation
import ru.syndicate.atmosphere.feature.search.domain.model.City

internal sealed class CityListScreenState {
    data object Idle : CityListScreenState()
    data object Loading : CityListScreenState()
    data class Error(val errorMessage: String) : CityListScreenState()
    data class Success(val cityList: List<City>) : CityListScreenState()
}

@Composable
internal fun CityListScreenState.DisplayResult(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    transitionSpec: AnimatedContentTransitionScope<CityListScreenState>.() -> ContentTransform = {
        fadeIn(tween(durationMillis = 200)) togetherWith
                ExitTransition.None
    },
    onIdle: (@Composable () -> Unit)? = null,
    onLoading: @Composable () -> Unit,
    onSuccess: @Composable (CityListScreenState.Success) -> Unit,
    onError: @Composable (CityListScreenState.Error) -> Unit
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

                is CityListScreenState.Error -> onError.invoke(state)

                CityListScreenState.Idle -> onIdle?.invoke()

                CityListScreenState.Loading -> onLoading.invoke()

                is CityListScreenState.Success -> onSuccess.invoke(state)
            }
        }
    }
}

internal data class CityListState(
    val isLoading: Boolean = false,
    val searchCityText: String = "",
    val searchLanguage: String = "en",
    val searchCityList: List<City> = emptyList(),
    val savedCity: CurrentLocation? = null
) {

    fun toUiState(): CityListScreenState {
        return if (isLoading) CityListScreenState.Loading
        else CityListScreenState.Success(searchCityList)
    }
}