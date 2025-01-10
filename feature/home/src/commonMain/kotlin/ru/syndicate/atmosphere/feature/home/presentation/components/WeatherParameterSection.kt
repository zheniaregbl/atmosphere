package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.humidity_svg
import atmosphere.feature.home.generated.resources.refresh_svg
import atmosphere.feature.home.generated.resources.wind_svg
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.defaultShimmerTheme
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import com.valentinilk.shimmer.shimmerSpec
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.home.presentation.DisplayResult
import ru.syndicate.atmosphere.feature.home.presentation.HomeState
import ru.syndicate.atmosphere.feature.home.presentation.util.weatherTitleByWeatherCode
import kotlin.math.roundToInt

internal sealed class WeatherParameter(
    val title: String,
    val unit: String,
    val icon: DrawableResource
) {

    data object Wind : WeatherParameter(
        title = "Wind",
        unit = "m/s",
        icon = Res.drawable.wind_svg
    )

    data object Humidity : WeatherParameter(
        title = "Humidity",
        unit = "%",
        icon = Res.drawable.humidity_svg
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun WeatherParameterSection(
    modifier: Modifier = Modifier,
    state: State<HomeState>,
    hazeState: HazeState,
    onRefreshClick: () -> Unit
) {

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

    val weatherParameterList = listOf(
        WeatherParameter.Wind,
        WeatherParameter.Humidity
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        state.value.toUiState().DisplayResult(
            modifier = Modifier.fillMaxWidth(),
            onIdle = {},
            onError = {},
            onLoading = {
                AdaptiveCircularProgressIndicator(
                    modifier = Modifier
                        .padding(30.dp)
                        .size(50.dp),
                    color = Color.White,
                )
            },
            onSuccess = {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = weatherTitleByWeatherCode(
                            state
                                .value
                                .weatherInfo
                                .currentWeatherParameters
                                .weatherCode
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 22.sp,
                        color = Color.White
                    )

                    Text(
                        modifier = Modifier.padding(vertical = 14.dp),
                        text = "${state.value.weatherInfo.currentWeatherParameters.temperature.roundToInt()}°",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 74.sp,
                        color = Color.White
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(6.dp))

        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = !state.value.isLoading,
            enter = EnterTransition.None,
            exit = ExitTransition.None
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .clip(CircleShape)
                    .hazeChild(
                        state = hazeState,
                        style = HazeDefaults
                            .style(
                                backgroundColor = BackgroundColor,
                                tint = HazeTint(color = Color.DarkGray.copy(alpha = .5f)),
                                blurRadius = 8.dp,
                            )
                    )
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onRefreshClick
                    )
                    .padding(14.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(Res.drawable.refresh_svg),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        state.value.toUiState().DisplayResult(
            modifier = Modifier.fillMaxWidth(),
            onIdle = {},
            onError = {},
            onLoading = {
                FlowRow(
                    modifier = Modifier.padding(vertical = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .shimmer(shimmerInstance)
                            .size(
                                width = 130.dp,
                                height = 70.dp
                            )
                            .background(color = Color.LightGray)
                            .padding(14.dp)
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .shimmer(shimmerInstance)
                            .size(
                                width = 130.dp,
                                height = 70.dp
                            )
                            .background(color = Color.LightGray)
                            .padding(14.dp)
                    )
                }
            },
            onSuccess = {
                FlowRow(
                    modifier = Modifier.padding(vertical = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    weatherParameterList.forEach {

                        ParameterView(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .hazeChild(
                                    state = hazeState,
                                    style = HazeDefaults
                                        .style(
                                            backgroundColor = BackgroundColor,
                                            tint = HazeTint(color = Color.DarkGray.copy(alpha = .5f)),
                                            blurRadius = 8.dp,
                                        )
                                )
                                .padding(14.dp),
                            value = when (it) {
                                WeatherParameter.Wind -> state
                                    .value
                                    .weatherInfo
                                    .currentWeatherParameters
                                    .windSpeed
                                    .toString()
                                WeatherParameter.Humidity -> state
                                    .value
                                    .weatherInfo
                                    .currentWeatherParameters
                                    .humidity
                                    .toString()
                            },
                            weatherParameter = it
                        )
                    }
                }
            }
        )
    }
}

@Composable
internal fun ParameterView(
    modifier: Modifier = Modifier,
    value: String,
    weatherParameter: WeatherParameter
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(weatherParameter.icon),
                contentDescription = null
            )

            Text(
                text = "$value ${weatherParameter.unit}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = LightWhite
            )
        }

        Text(
            text = weatherParameter.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = LightWhite
        )
    }
}