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
import androidx.compose.ui.unit.dp
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.presentation.components.LanguageDialog
import ru.syndicate.atmosphere.feature.settings.presentation.components.SettingParameter
import ru.syndicate.atmosphere.feature.settings.presentation.components.TopPanel
import ru.syndicate.atmosphere.feature.settings.presentation.translation.util.TranslationUtil.LocalSettingsStrings
import ru.syndicate.atmosphere.feature.settings.presentation.translation.util.TranslationUtil.translations

class SettingsScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<SettingsViewModel>()
        val state = viewModel.state.collectAsState()

        SettingsScreenImpl(
            modifier = Modifier.fillMaxSize(),
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
        Pair("Русский", "ru"),
        Pair("Deutsch", "de"),
        Pair("Français", "fr"),
        Pair("Español", "es"),
        Pair("Italiano", "it"),
        Pair("Português", "pt")
    )

    var searchLanguage by remember {
        mutableStateOf(
            languages
                .find { it.second == state.value.searchLanguage }!!
                .first
        )
    }

    val lyricist = rememberStrings(
        translations = translations,
        defaultLanguageTag = "en",
        currentLanguageTag = state.value.searchLanguage
    )

    LaunchedEffect(state.value.searchLanguage) {
        searchLanguage = languages
            .find { it.second == state.value.searchLanguage }!!
            .first
    }

    ProvideStrings(
        lyricist = lyricist,
        provider = LocalSettingsStrings
    ) {

        Box(modifier = modifier.statusBarsPadding()) {

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
                    topPanelTitle = LocalSettingsStrings.current.screenTitle,
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
                                .padding(vertical = 14.dp),
                            title = LocalSettingsStrings.current.langSectionTitle,
                            description = LocalSettingsStrings.current.langSectionDesc,
                            value = searchLanguage,
                            onClick = { showLanguageDialog = true }
                        )
                    }
                }
            }
        }

        LanguageDialog(
            showDialog = showLanguageDialog,
            initialValue = state.value.searchLanguage,
            title = LocalSettingsStrings.current.selectLangDialogTitle,
            buttonText = LocalSettingsStrings.current.selectButtonText,
            languages = languages,
            onSelectedLanguage = {
                onAction(SettingsAction.OnChangeSearchLanguage(it))
                showLanguageDialog = false
            },
            onDismissRequest = { showLanguageDialog = false }
        )
    }
}