package ru.syndicate.atmosphere.presentation.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.composeapp.generated.resources.Res
import atmosphere.composeapp.generated.resources.arrow_svg
import atmosphere.composeapp.generated.resources.humidity_svg
import atmosphere.composeapp.generated.resources.wind_svg
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.presentation.theme.LightWhite

sealed class WeatherParameter(
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
fun MainInfoSection(
    modifier: Modifier = Modifier,
    hazeState: HazeState
) {

    val weatherParameterList = listOf(
        WeatherParameter.Wind,
        WeatherParameter.Humidity
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "15°",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 74.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

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
                        WeatherParameter.Wind -> "4"
                        WeatherParameter.Humidity -> "55"
                    },
                    weatherParameter = it
                )
            }
        }
    }
}

@Composable
private fun ParameterView(
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