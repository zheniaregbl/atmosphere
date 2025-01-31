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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.presentation.components.LanguageDialog
import ru.syndicate.atmosphere.core.presentation.theme.LightWhite
import ru.syndicate.atmosphere.feature.settings.presentation.components.SettingParameter
import ru.syndicate.atmosphere.feature.settings.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.settings.resources.Res
import ru.syndicate.atmosphere.feature.settings.resources.screen_title
import ru.syndicate.atmosphere.feature.settings.resources.search_lang_desc
import ru.syndicate.atmosphere.feature.settings.resources.search_lang_title
import ru.syndicate.atmosphere.feature.settings.resources.weather_options_desc
import ru.syndicate.atmosphere.feature.settings.resources.weather_options_title

class SettingsScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<SettingsViewModel>()
        val state = viewModel.state.collectAsState()

        SettingsScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            state = state,
            onAction = { action -> viewModel.onAction(action) },
            onBackClick = { navigator.pop() }
        )
    }
}

@Composable
internal fun SettingsScreenImpl(
    modifier: Modifier = Modifier,
    state: State<SettingsState>,
    onAction: (SettingsAction) -> Unit,
    onBackClick: () -> Unit
) {

    var showLanguageDialog by remember { mutableStateOf(false) }

    val languages = listOf(
        Pair("English", "en"),
        Pair("Russian", "ru"),
        Pair("German", "de"),
        Pair("French", "fr"),
        Pair("Spanish", "es"),
        Pair("Italian", "it"),
        Pair("Portuguese", "pt")
    )
    var searchLanguage by remember {
        mutableStateOf(
            languages
                .find { it.second == state.value.searchLanguage }!!
                .first
        )
    }

    LaunchedEffect(state.value.searchLanguage) {
        searchLanguage = languages
            .find { it.second == state.value.searchLanguage }!!
            .first
    }

    Box(modifier = modifier) {

        Column(
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
                        value = searchLanguage,
                        onClick = { showLanguageDialog = true }
                    )
                }
            }
        }

        LanguageDialog(
            showDialog = showLanguageDialog,
            initialValue = state.value.searchLanguage,
            languages = languages,
            onSelectedLanguage = {
                onAction(SettingsAction.OnChangeSearchLanguage(it))
                showLanguageDialog = false
            },
            onDismissRequest = { showLanguageDialog = false }
        )
    }
}