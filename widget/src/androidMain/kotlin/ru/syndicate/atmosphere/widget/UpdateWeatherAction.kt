package ru.syndicate.atmosphere.widget

import android.content.Context
import android.content.Intent
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback

internal class UpdateWeatherAction : ActionCallback {

    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        val intent = Intent(context, ShortWeatherWidgetReceiver::class.java).apply {
            action = ShortWeatherWidgetReceiver.UPDATE_ACTION
        }
        context.sendBroadcast(intent)
    }
}