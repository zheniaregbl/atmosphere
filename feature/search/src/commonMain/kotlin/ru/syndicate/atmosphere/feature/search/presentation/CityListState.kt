package ru.syndicate.atmosphere.feature.search.presentation

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
import ru.syndicate.atmosphere.feature.search.domain.model.City

internal sealed class CityListScreenState {
    data object Idle : CityListScreenState()
    data object Loading : CityListScreenState()
    data class Success(val cityList: List<City>) : CityListScreenState()
    data class Error(val errorMessageCode: Int) : CityListScreenState()
}

@Composable
internal fun CityListScreenState.DisplayResult(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    transitionSpec: AnimatedContentTransitionScope<CityListScreenState>.() -> ContentTransform = {
        fadeIn() + scaleIn(
            animationSpec = spring(stiffness = Spring.StiffnessMedium),
            initialScale = .9f
        ) togetherWith ExitTransition.None
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

                CityListScreenState.Idle -> onIdle?.invoke()

                CityListScreenState.Loading -> onLoading.invoke()

                is CityListScreenState.Success -> onSuccess.invoke(state)

                is CityListScreenState.Error -> onError.invoke(state)
            }
        }
    }
}

internal data class CityListState(
    val isLoading: Boolean = false,
    val errorMessageCode: Int? = null,
    val searchCityText: String = "",
    val searchLanguage: String = Locales.EN,
    val searchCityList: List<City> = emptyList(),
    val savedCity: CurrentLocation? = null
) {

    fun toUiState(): CityListScreenState {
        return when {
            isLoading -> CityListScreenState.Loading
            searchCityList.isNotEmpty() -> CityListScreenState.Success(searchCityList)
            errorMessageCode != null -> CityListScreenState.Error(errorMessageCode)
            else -> CityListScreenState.Idle
        }
    }
}