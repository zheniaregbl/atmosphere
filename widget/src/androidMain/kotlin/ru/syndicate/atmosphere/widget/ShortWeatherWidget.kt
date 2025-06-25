package ru.syndicate.atmosphere.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import kotlinx.serialization.json.Json
import ru.syndicate.atmosphere.widget.data.dto.ShortWeatherWidgetInfoDTO
import ru.syndicate.atmosphere.widget.data.mapper.toModel
import ru.syndicate.atmosphere.widget.presentation.ShortWeatherWidgetUI

internal class ShortWeatherWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) = provideContent {

        val weatherWidgetInfoString = currentState(ShortWeatherWidgetReceiver.WeatherWidgetInfo) ?: ""
        val isLoading = currentState(ShortWeatherWidgetReceiver.IsLoading) ?: false

        val weatherWidgetInfo = Json
            .decodeFromString<ShortWeatherWidgetInfoDTO>(weatherWidgetInfoString)
            .toModel()

        Box(
            modifier = GlanceModifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ShortWeatherWidgetUI(
                shortWeatherWidgetInfo = weatherWidgetInfo,
                isLoading = isLoading
            )
        }
    }
}