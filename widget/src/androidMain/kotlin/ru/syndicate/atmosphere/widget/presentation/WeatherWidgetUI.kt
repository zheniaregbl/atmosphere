package ru.syndicate.atmosphere.widget.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.FontFamily
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.widget.R
import ru.syndicate.atmosphere.widget.UpdateWeatherAction
import ru.syndicate.atmosphere.widget.WeatherWidget

@Composable
fun WeatherWidgetUI(
    currentTemperature: Int
) {

    Row(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(
                imageProvider = ImageProvider(R.drawable.widget_background),
                colorFilter = ColorFilter.tint(ColorProvider(BackgroundColor))
            )
            .clickable(onClick = actionRunCallback<UpdateWeatherAction>())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {

            Text(
                text = "Mon,10:10",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = ColorProvider(LightWhite)
                )
            )

            Text(
                text = "${currentTemperature}°",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = ColorProvider(LightWhite)
                )
            )

            Text(
                text = "30°/12°",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = ColorProvider(LightWhite)
                )
            )
        }

        Spacer(modifier = GlanceModifier.defaultWeight())

        Image(
            modifier = GlanceModifier.size(64.dp),
            provider = ImageProvider(R.drawable.cloudy_svg),
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 200, heightDp = 150)
@Composable
private fun WeatherWidgetPreview(modifier: Modifier = Modifier) {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetUI(20)
    }
}