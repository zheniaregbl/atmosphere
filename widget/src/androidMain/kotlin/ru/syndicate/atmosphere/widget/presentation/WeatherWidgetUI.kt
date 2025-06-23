package ru.syndicate.atmosphere.widget.presentation

import android.widget.RemoteViews
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.action.clickable
import androidx.glance.appwidget.AndroidRemoteViews
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
import kotlinx.datetime.LocalDateTime
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.widget.R
import ru.syndicate.atmosphere.widget.UpdateWeatherAction
import ru.syndicate.atmosphere.widget.domain.model.WeatherWidgetInfo
import ru.syndicate.atmosphere.widget.presentation.util.getRefreshTextByLanguage
import ru.syndicate.atmosphere.widget.presentation.util.getWeekDayByLanguage
import ru.syndicate.atmosphere.widget.presentation.util.iconByWeatherCode

@Composable
internal fun WeatherWidgetUI(
    weatherWidgetInfo: WeatherWidgetInfo,
    isLoading: Boolean
) {

    val context = LocalContext.current
    val widgetProgressBarLayout = RemoteViews(
        context.packageName,
        R.layout.widget_progress_bar
    )

    val lastUpdateDay = getWeekDayByLanguage(
        LocalDateTime.parse(weatherWidgetInfo.lastUpdateDateTime).dayOfWeek,
        weatherWidgetInfo.appLanguage
    )

    Column(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(ImageProvider(R.drawable.widget_background))
            .clickable(
                onClick = actionRunCallback<UpdateWeatherAction>(),
                rippleOverride = R.color.transparent
            )
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when {
            isLoading -> {
                AndroidRemoteViews(
                    modifier = GlanceModifier.size(40.dp),
                    remoteViews = widgetProgressBarLayout
                )
            }
            weatherWidgetInfo.isError -> {
                WeatherWidgetErrorUI(weatherWidgetInfo.appLanguage)
            }
            else -> {
                Row(
                    modifier = GlanceModifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = "$lastUpdateDay,${weatherWidgetInfo.lastUpdateTime}",
                            style = TextStyle(
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = ColorProvider(LightWhite)
                            )
                        )

                        Text(
                            text = "${weatherWidgetInfo.currentTemperature}°",
                            style = TextStyle(
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                color = ColorProvider(LightWhite)
                            )
                        )

                        Text(
                            text = "${weatherWidgetInfo.maxTemperature}°/${weatherWidgetInfo.minTemperature}°",
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
                        provider = ImageProvider(
                            iconByWeatherCode(
                                weatherWidgetInfo.weatherCode,
                                weatherWidgetInfo.isDay
                            )
                        ),
                        contentDescription = null
                    )
                }

                Spacer(modifier = GlanceModifier.height(4.dp))

                Text(
                    modifier = GlanceModifier.fillMaxWidth(),
                    text = getRefreshTextByLanguage(weatherWidgetInfo.appLanguage),
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
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 240, heightDp = 150)
@Composable
private fun WeatherWidgetPreview() {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetUI(
            weatherWidgetInfo = WeatherWidgetInfo(),
            isLoading = false
        )
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 240, heightDp = 150)
@Composable
private fun WeatherWidgetLoadingPreview() {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetUI(
            weatherWidgetInfo = WeatherWidgetInfo(),
            isLoading = true
        )
    }
}

@OptIn(ExperimentalGlancePreviewApi::class)
@Preview(widthDp = 240, heightDp = 150)
@Composable
private fun WeatherWidgetErrorPreview() {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetUI(
            weatherWidgetInfo = WeatherWidgetInfo(isError = true),
            isLoading = false
        )
    }
}