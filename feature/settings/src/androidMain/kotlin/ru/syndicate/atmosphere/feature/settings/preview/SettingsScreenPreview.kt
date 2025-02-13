package ru.syndicate.atmosphere.feature.settings.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.syndicate.atmosphere.core.presentation.theme.AppTheme
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsScreenImpl
import ru.syndicate.atmosphere.feature.settings.presentation.SettingsState

internal val previewState =
    SettingsState()

@Preview
@Composable
private fun SettingsScreenPreview() {

    val state = remember { mutableStateOf(previewState) }

    AppTheme {
        SettingsScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            state = state,
            onAction = { },
            onBackClick = { }
        )
    }
}