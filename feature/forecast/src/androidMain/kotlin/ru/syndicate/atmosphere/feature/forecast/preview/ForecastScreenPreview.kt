package ru.syndicate.atmosphere.feature.forecast.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.presentation.ForecastScreenImpl
import ru.syndicate.atmosphere.feature.forecast.presentation.ForecastState

internal val previewState =
    ForecastState(forecasts = (0..6).map { DailyForecast() })

@Preview
@Composable
private fun ForecastScreenPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        ForecastScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .statusBarsPadding(),
            state = state,
            onBackClick = { }
        )
    }
}