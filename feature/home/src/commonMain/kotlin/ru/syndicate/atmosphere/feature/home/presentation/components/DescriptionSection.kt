package ru.syndicate.atmosphere.feature.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import atmosphere.feature.home.generated.resources.Res
import atmosphere.feature.home.generated.resources.rain_svg
import atmosphere.feature.home.generated.resources.temperature_svg
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor

@Composable
internal fun DescriptionSection(
    modifier: Modifier = Modifier,
    hazeState: HazeState
) {

    Row(modifier = modifier) {

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
            value = "10°",
            description = "The temperature outside feels a little lower than it actually is."
        )

        Spacer(modifier = Modifier.width(20.dp))

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
            icon = Res.drawable.rain_svg,
            description = "It's raining outside now, it would be a good idea to take an umbrella with you or put on a raincoat."
        )
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

        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {

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