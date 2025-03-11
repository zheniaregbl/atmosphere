package ru.syndicate.atmosphere.widget.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
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
import ru.syndicate.atmosphere.widget.presentation.util.getErrorMessage
import ru.syndicate.atmosphere.widget.presentation.util.getRefreshTextByLanguage

@Composable
internal fun WeatherWidgetErrorUI(
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
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = getErrorMessage(appLanguage),
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = ColorProvider(LightWhite)
            )
        )

        Spacer(modifier = GlanceModifier.height(6.dp))

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
private fun WeatherWidgetErrorPreview() {

    Box(
        modifier = GlanceModifier.padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        WeatherWidgetErrorUI(Locales.EN)
    }
}