package ru.syndicate.atmosphere.widget.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.CircularProgressIndicator
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.preview.ExperimentalGlancePreviewApi
import androidx.glance.preview.Preview
import androidx.glance.text.FontFamily
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.widget.R
import ru.syndicate.atmosphere.widget.UpdateWeatherAction
import ru.syndicate.atmosphere.widget.presentation.translation.EnStrings
import ru.syndicate.atmosphere.widget.presentation.util.getRefreshTextByLanguage
import ru.syndicate.atmosphere.widget.presentation.util.iconByWeatherCode

@Composable
internal fun WeatherWidgetUI(
    currentTemperature: Int,
    maxTemperature: Int,
    minTemperature: Int,
    currentWeatherCode: Int,
    lastUpdateTime: String,
    lastUpdateDay: String,
    isUpdating: Boolean,
    appLanguage: String
) {

    Column(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(
                imageProvider = ImageProvider(R.drawable.widget_background),
                colorFilter = ColorFilter.tint(ColorProvider(BackgroundColor))
            )
            .clickable(actionRunCallback<UpdateWeatherAction>())
            .padding(14.dp)
    ) {

        Row(
            modifier = GlanceModifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (isUpdating) {
                CircularProgressIndicator(color = ColorProvider(LightWhite))
            } else {

                Column {

                    Text(
                        text = "$lastUpdateDay,$lastUpdateTime",
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
                        text = "$maxTemperature°/$minTemperature°",
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
                    provider = ImageProvider(iconByWeatherCode(currentWeatherCode)),
                    contentDescription = null
                )

            }
        }

        Spacer(modifier = GlanceModifier.height(4.dp))

        Text(
            modifier = GlanceModifier.fillMaxWidth(),
            text = getRefreshTextByLanguage(appLanguage),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = ColorProvider(LightWhite)
            )
        )
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 200, heightDp = 150)
@Composable
private fun WeatherWidgetPreview() {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetUI(
            currentTemperature = 20,
            maxTemperature = 20,
            minTemperature = 0,
            currentWeatherCode = 1,
            lastUpdateTime = "10:10",
            lastUpdateDay = EnStrings.weekDayTitle.monday,
            isUpdating = false,
            appLanguage = Locales.EN
        )
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 200, heightDp = 150)
@Composable
private fun WeatherWidgetUpdatingPreview() {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetUI(
            currentTemperature = 20,
            maxTemperature = 20,
            minTemperature = 0,
            currentWeatherCode = 1,
            lastUpdateTime = "10:10",
            lastUpdateDay = EnStrings.weekDayTitle.monday,
            isUpdating = true,
            appLanguage = Locales.EN
        )
    }
}