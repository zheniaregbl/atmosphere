package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.home.presentation.HomeState

@Composable
internal actual fun ForecastSection(
    modifier: Modifier,
    state: State<HomeState>
) {

    ForecastList(
        modifier = modifier
            .drawBehind {
                drawLine(
                    start = Offset(x = 0f, y = size.height),
                    end = Offset(x = size.width, y = size.height),
                    color = LightWhite
                )
            }
            .padding(vertical = 10.dp),
        state = state
    )
}