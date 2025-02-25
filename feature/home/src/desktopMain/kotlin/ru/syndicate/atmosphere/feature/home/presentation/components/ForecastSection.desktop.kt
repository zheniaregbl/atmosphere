package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.home.presentation.HomeState

@Composable
internal actual fun ForecastSection(
    modifier: Modifier,
    state: State<HomeState>
) {

    val lazyListState = rememberLazyListState()

    Column(
        modifier = modifier
            .drawBehind {
                drawLine(
                    start = Offset(x = 0f, y = size.height),
                    end = Offset(x = size.width, y = size.height),
                    color = LightWhite
                )
            }
            .padding(top = 10.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        ForecastList(
            modifier = modifier,
            forecastListState = lazyListState,
            userScrollEnabled = false,
            state = state
        )

        HorizontalScrollbar(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp),
            adapter = rememberScrollbarAdapter(lazyListState),
            style = LocalScrollbarStyle.current.copy(
                hoverColor = LightWhite,
                unhoverColor = LightWhite.copy(alpha = 0.6f)
            )
        )
    }
}