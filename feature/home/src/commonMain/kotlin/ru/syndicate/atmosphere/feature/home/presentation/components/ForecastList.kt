package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.defaultShimmerTheme
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.shimmerSpec
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.feature.home.presentation.DisplayResult
import ru.syndicate.atmosphere.feature.home.presentation.HomeState
import ru.syndicate.atmosphere.feature.home.presentation.translation.util.LocalHomeStrings
import ru.syndicate.atmosphere.feature.home.presentation.util.iconByWeatherCode
import kotlin.math.roundToInt

@Composable
internal fun ForecastList(
    modifier: Modifier = Modifier,
    forecastListState: LazyListState = rememberLazyListState(),
    userScrollEnabled: Boolean = true,
    state: State<HomeState>
) {

    var currentHourIndex by remember { mutableStateOf(0) }

    val shimmerInstance = rememberShimmer(
        shimmerBounds = ShimmerBounds.Window,
        theme = defaultShimmerTheme.copy(
            animationSpec = infiniteRepeatable(
                animation = shimmerSpec(
                    durationMillis = 800,
                    easing = LinearEasing,
                    delayMillis = 500,
                ),
                repeatMode = RepeatMode.Restart,
            )
        )
    )

    LaunchedEffect(state.value) {
        if (state.value.weatherInfo.hourlyWeather.temperatures.isNotEmpty()) {
            currentHourIndex = Clock
                .System
                .now()
                .toLocalDateTime(
                    TimeZone.of(state.value.currentLocation.timeZone)
                )
                .hour
            forecastListState.scrollToItem(currentHourIndex)
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = LocalHomeStrings.current.hourlyForecast,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.White
        )

        Box(modifier = Modifier.fillMaxWidth()) {

            state.value.toUiState().DisplayResult(
                modifier = Modifier.fillMaxWidth(),
                onIdle = {},
                onError = {},
                onLoading = {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        state = forecastListState,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        userScrollEnabled = userScrollEnabled
                    ) {

                        items(24) {

                            Box(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .shimmer(shimmerInstance)
                                    .size(
                                        width = 40.dp,
                                        height = 60.dp
                                    )
                                    .background(color = Color.LightGray)
                            )
                        }
                    }
                },
                onSuccess = { screenState ->
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        state = forecastListState,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        userScrollEnabled = userScrollEnabled
                    ) {

                        itemsIndexed(screenState.weatherInfo.hourlyWeather.temperatures) { index, temperature ->

                            ForecastItem(
                                modifier = Modifier.padding(10.dp),
                                time = if (index < 9) "0$index:00"
                                else "$index:00",
                                temperature = "${temperature.roundToInt()}°",
                                weatherIcon = iconByWeatherCode(
                                    state.value.weatherInfo.hourlyWeather.weatherCodes[index]
                                ),
                                isCurrentHour = index == currentHourIndex
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
internal fun ForecastItem(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
    weatherIcon: DrawableResource,
    isCurrentHour: Boolean
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = time,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = if (isCurrentHour) SelectedBlue else Color.White
        )

        Image(
            painter = painterResource(weatherIcon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(
                color = if (isCurrentHour) SelectedBlue else Color.White
            )
        )

        Text(
            text = temperature,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = if (isCurrentHour) SelectedBlue else Color.White
        )
    }
}