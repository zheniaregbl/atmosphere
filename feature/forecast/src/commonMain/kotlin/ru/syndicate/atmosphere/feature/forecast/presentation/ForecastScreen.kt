package ru.syndicate.atmosphere.feature.forecast.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.syndicate.atmosphere.feature.forecast.domain.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.presentation.components.ForecastCard
import ru.syndicate.atmosphere.feature.forecast.presentation.components.TopPanel

internal class ForecastScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        ForecastScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun ForecastScreenImpl(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            TopPanel(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                topPanelTitle = "Forecast",
                onBackClick = onBackClick
            )

            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(7) {
                    ForecastCard(
                        modifier = Modifier.fillMaxWidth(),
                        dailyForecast = DailyForecast()
                    )
                }
            }
        }
    }
}