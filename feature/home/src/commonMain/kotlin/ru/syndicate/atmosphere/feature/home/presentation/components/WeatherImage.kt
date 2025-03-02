package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import ru.syndicate.atmosphere.feature.home.presentation.DisplayResult
import ru.syndicate.atmosphere.feature.home.presentation.HomeState
import ru.syndicate.atmosphere.feature.home.presentation.util.lottieStringByWeatherCode

@Composable
internal fun WeatherImage(
    modifier: Modifier = Modifier,
    state: State<HomeState>,
    hazeState: HazeState,
) {

    state.value.toUiState().DisplayResult(
        modifier = modifier,
        contentAlignment = Alignment.TopStart,
        onIdle = {},
        onError = {},
        onLoading = {},
        onSuccess = {},
        onSuccessBox = {

            val composition by rememberLottieComposition {
                LottieCompositionSpec
                    .JsonString(
                        lottieStringByWeatherCode(
                            state
                                .value
                                .weatherInfo
                                ?.currentWeatherParameters
                                ?.weatherCode ?: 0
                        )
                    )
            }
            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = Compottie.IterateForever
            )

            Image(
                modifier = Modifier
                    .height(380.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 50.dp)
                    .alpha(0.35f)
                    .haze(hazeState),
                painter = rememberLottiePainter(
                    composition = composition,
                    progress = { progress },
                ),
                contentDescription = null
            )
        }
    )
}