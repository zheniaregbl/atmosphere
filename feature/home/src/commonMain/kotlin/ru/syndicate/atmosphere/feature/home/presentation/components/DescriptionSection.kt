package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.temperature_svg
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.home.presentation.HomeState
import ru.syndicate.atmosphere.feature.home.presentation.util.descriptionByWeatherCode
import ru.syndicate.atmosphere.feature.home.presentation.util.iconByWeatherCode
import kotlin.math.abs

@Composable
internal fun DescriptionSection(
    modifier: Modifier = Modifier,
    state: State<HomeState>,
    hazeState: HazeState
) {

    AnimatedVisibility(
        modifier = modifier,
        visible = state.value.weatherInfo.currentWeatherParameters.weatherCode > -1
    ) {

        Row(modifier = Modifier.fillMaxSize()) {

            val realTemperature = state.value.weatherInfo.currentWeatherParameters.temperature
            val feelTemperature = state.value.weatherInfo.currentWeatherParameters.apparentTemperature

            DescriptionCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
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
                    .padding(16.dp),
                title = "Feel like",
                icon = Res.drawable.temperature_svg,
                value = "$feelTemperature°",
                description = when {
                    abs(realTemperature - feelTemperature) < 5f -> {
                        "The temperature outside feels slightly different from the readings"
                    }
                    abs(realTemperature - feelTemperature) > 5f -> {
                        "The temperature outside is very different from the readings"
                    }
                    else -> "The temperature does not differ from the readings"
                }
            )

            Spacer(modifier = Modifier.width(20.dp))

            val weatherCode = state.value.weatherInfo.currentWeatherParameters.weatherCode

            DescriptionCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
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
                    .padding(16.dp),
                title = "Weather",
                icon = iconByWeatherCode(weatherCode),
                description = descriptionByWeatherCode(weatherCode)
            )
        }
    }
}

@Composable
internal fun DescriptionCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: DrawableResource,
    value: String? = null,
    description: String
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(icon),
                contentDescription = null
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.White
            )
        }

        value?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}