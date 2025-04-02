package ru.syndicate.atmosphere.widget.domain

expect class WidgetManager {
    fun updateWidget()
    fun rerunWidget(timing: Int)
}