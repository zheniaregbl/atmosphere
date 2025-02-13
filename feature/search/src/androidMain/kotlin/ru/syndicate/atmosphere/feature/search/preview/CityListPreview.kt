package ru.syndicate.atmosphere.feature.search.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.search.domain.model.City
import ru.syndicate.atmosphere.feature.search.presentation.CityListScreenImpl
import ru.syndicate.atmosphere.feature.search.presentation.CityListState

internal val previewState =
    CityListState(searchCityList = List(10) { City() })

@Preview
@Composable
private fun CityListPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        CityListScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            onAction = { },
            onBackClick = { }
        )
    }
}