package ru.syndicate.atmosphere.feature.forecast.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.feature.forecast.generated.resources.Res
import atmosphere.feature.forecast.generated.resources.humidity_svg
import atmosphere.feature.forecast.generated.resources.sun_svg
import atmosphere.feature.forecast.generated.resources.temperature_svg
import atmosphere.feature.forecast.generated.resources.wind_svg
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.GrayColor
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.presentation.translation.util.LocalForecastStrings
import ru.syndicate.atmosphere.feature.forecast.presentation.util.iconByWeatherCode
import ru.syndicate.atmosphere.feature.forecast.presentation.util.localize

@Composable
internal fun ForecastCard(
    modifier: Modifier = Modifier,
    dailyForecast: DailyForecast
) {

    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(GrayColor)
            .clickable(
                onClick = { isExpanded = !isExpanded },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(10.dp)
    ) {

        ForecastCardTitle(
            modifier = Modifier.fillMaxWidth(),
            isExpanded = isExpanded,
            dailyForecast = dailyForecast
        )

        AnimatedVisibility(visible = isExpanded) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.fillMaxWidth()) {

                    ParameterSection(
                        modifier = Modifier.weight(1f),
                        title = LocalForecastStrings.current.temperatureSectionTitle,
                        icon = Res.drawable.temperature_svg,
                        content = {

                            ParameterRow(
                                title = LocalForecastStrings.current.maximum,
                                value = "${dailyForecast.maxTemperature}°",
                            )

                            ParameterRow(
                                title = LocalForecastStrings.current.minimum,
                                value = "${dailyForecast.minTemperature}°",
                            )
                        }
                    )

                    Spacer(modifier = Modifier.width(22.dp))

                    ParameterSection(
                        modifier = Modifier.weight(1f),
                        title = LocalForecastStrings.current.precipitationSectionTitle,
                        icon = Res.drawable.humidity_svg,
                        content = {
                            ParameterRow(
                                title = LocalForecastStrings.current.precipitationProbability,
                                value = "${dailyForecast.precipitationProbability} %",
                            )
                        }
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {

                    ParameterSection(
                        modifier = Modifier.weight(1f),
                        title = LocalForecastStrings.current.windSectionTitle,
                        icon = Res.drawable.wind_svg,
                        content = {

                            ParameterRow(
                                title = LocalForecastStrings.current.speed,
                                value = "${dailyForecast.maxWindSpeed} " +
                                        LocalForecastStrings.current.windUnit,
                            )
                        }
                    )

                    Spacer(modifier = Modifier.width(22.dp))

                    ParameterSection(
                        modifier = Modifier.weight(1f),
                        title = LocalForecastStrings.current.sunSectionTitle,
                        icon = Res.drawable.sun_svg,
                        content = {

                            ParameterRow(
                                title = LocalForecastStrings.current.sunrise,
                                value = "${dailyForecast.sunrise}",
                            )

                            ParameterRow(
                                title = LocalForecastStrings.current.sunset,
                                value = "${dailyForecast.sunset}",
                            )
                        }
                    )
                }
            }

        }
    }
}

@Composable
private fun ForecastCardTitle(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    dailyForecast: DailyForecast
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier.size(28.dp),
            painter = painterResource(iconByWeatherCode(dailyForecast.weatherCode)),
            contentDescription = null
        )

        AnimatedContent(
            modifier = Modifier.fillMaxWidth(),
            targetState = isExpanded,
            transitionSpec = {
                fadeIn(animationSpec = tween(200))
                    .togetherWith(
                        fadeOut(animationSpec = tween(200))
                    )
            },
            label = "Forecast card title animation"
        ) { isExpandedState ->

            if (isExpandedState) {

                Text(
                    text = "${dailyForecast.date.dayOfWeek.localize()}, ${dailyForecast.date.dayOfMonth} " +
                            dailyForecast.date.month.localize(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = LightWhite
                )

            } else {

                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {

                    Text(
                        text = "${dailyForecast.maxTemperature}° / ${dailyForecast.minTemperature}°",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = LightWhite
                    )

                    Text(
                        text = "${dailyForecast.date.dayOfWeek.localize()}, ${dailyForecast.date.dayOfMonth} " +
                                dailyForecast.date.month.localize(),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = LightWhite
                    )
                }

            }
        }
    }
}

@Composable
private fun ParameterSection(
    modifier: Modifier = Modifier,
    title: String,
    icon: DrawableResource,
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier.size(18.dp),
                painter = painterResource(icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(LightWhite)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = LightWhite
            )
        }

        content()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ParameterRow(
    title: String,
    value: String
) {

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = LightWhite
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = LightWhite
        )
    }
}