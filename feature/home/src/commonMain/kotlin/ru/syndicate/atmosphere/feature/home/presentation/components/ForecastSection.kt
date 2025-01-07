package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.home.domain.model.HourlyWeather
import ru.syndicate.atmosphere.feature.home.presentation.util.iconByWeatherCode

internal enum class ForecastType(val title: String) {
    Today("Today"),
    Tomorrow("Tomorrow"),
    SeveralDay("7 days")
}

@Composable
internal fun ForecastSection(
    modifier: Modifier = Modifier,
    hourlyWeather: HourlyWeather
) {

    var selectedForecastType by remember { mutableStateOf(ForecastType.Today) }

    val forecastListState = rememberLazyListState()

    LaunchedEffect(hourlyWeather) {
        if (hourlyWeather.temperatures.isNotEmpty()) {
            val currentHour = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).hour
            forecastListState.animateScrollToItem(currentHour)
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            ForecastType.entries.forEach {

                Text(
                    modifier = Modifier
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { selectedForecastType = it }
                        .padding(
                            horizontal = 24.dp,
                            vertical = 14.dp
                        ),
                    text = it.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = if (selectedForecastType == it) FontWeight.Medium
                    else FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.White
                        .copy(alpha = if (selectedForecastType == it) 1f else 0.5f)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {

                    drawLine(
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(x = size.width, y = 0f),
                        color = LightWhite
                    )

                    drawLine(
                        start = Offset(x = 0f, y = size.height),
                        end = Offset(x = size.width, y = size.height),
                        color = LightWhite
                    )
                }
                .padding(vertical = 10.dp),
        ) {

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                state = forecastListState,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                itemsIndexed(hourlyWeather.temperatures) { index, temperature ->

                    ForecastItem(
                        modifier = Modifier.padding(10.dp),
                        time = if (index < 9) "0$index:00"
                        else "$index:00",
                        temperature = "$temperature°",
                        weatherIcon = iconByWeatherCode(
                            hourlyWeather.weatherCodes[index]
                        )
                    )
                }
            }
        }
    }
}

@Composable
internal fun ForecastItem(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
    weatherIcon: DrawableResource
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
            color = Color.White
        )

        Image(
            painter = painterResource(weatherIcon),
            contentDescription = null
        )

        Text(
            text = temperature,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}