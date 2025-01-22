package ru.syndicate.atmosphere.feature.settings.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.stringResource
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.settings.presentation.components.SettingParameter
import ru.syndicate.atmosphere.feature.settings.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.settings.resources.Res
import ru.syndicate.atmosphere.feature.settings.resources.lang_eng
import ru.syndicate.atmosphere.feature.settings.resources.screen_title
import ru.syndicate.atmosphere.feature.settings.resources.search_lang_desc
import ru.syndicate.atmosphere.feature.settings.resources.search_lang_title
import ru.syndicate.atmosphere.feature.settings.resources.weather_options_desc
import ru.syndicate.atmosphere.feature.settings.resources.weather_options_title

class SettingsScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        SettingsScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun SettingsScreenImpl(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = { }
) {

    Box(modifier = modifier) {

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            TopPanel(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth(),
                topPanelTitle = stringResource(Res.string.screen_title),
                onBackClick = onBackClick
            )

            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxWidth()
            ) {

                item {
                    SettingParameter(
                        modifier = Modifier
                            .widthIn(max = 800.dp)
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    start = Offset(x = 0f, y = size.height),
                                    end = Offset(x = size.width, y = size.height),
                                    color = LightWhite
                                )
                            }
                            .padding(vertical = 14.dp),
                        title = stringResource(Res.string.weather_options_title),
                        description = stringResource(Res.string.weather_options_desc),
                        onClick = { println("Click") }
                    )
                }

                item {
                    SettingParameter(
                        modifier = Modifier
                            .widthIn(max = 800.dp)
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        title = stringResource(Res.string.search_lang_title),
                        description = stringResource(Res.string.search_lang_desc),
                        value = stringResource(Res.string.lang_eng),
                        onClick = { }
                    )
                }
            }
        }
    }
}