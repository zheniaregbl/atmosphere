package ru.syndicate.atmosphere.feature.forecast.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.forecast.domain.model.DailyForecast
import ru.syndicate.atmosphere.feature.forecast.presentation.theme.CardColor
import ru.syndicate.atmosphere.feature.forecast.presentation.util.iconByWeatherCode
import ru.syndicate.atmosphere.feature.forecast.presentation.util.localize

@Composable
internal fun ForecastCard(
    modifier: Modifier = Modifier,
    dailyForecast: DailyForecast
) {

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(CardColor)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier.size(28.dp),
                painter = painterResource(iconByWeatherCode(dailyForecast.weatherCode)),
                contentDescription = null
            )

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