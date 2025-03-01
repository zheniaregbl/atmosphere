package ru.syndicate.atmosphere.feature.onboarding.presentation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.core.presentation.translation.Locales
import ru.syndicate.atmosphere.feature.onboarding.presentation.components.WelcomeSectionContent
import ru.syndicate.atmosphere.feature.onboarding.presentation.components.LanguageSelectionContent
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.util.LocalOnboardingStrings
import ru.syndicate.atmosphere.feature.onboarding.presentation.translation.util.TranslationUtil.translations

internal class OnboardingScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val searchScreen = rememberScreen(SharedScreen.SearchScreen(isInitSelect = true))

        val viewModel = koinViewModel<OnboardingViewModel>()
        val state by viewModel.state.collectAsState()

        val lyricist = rememberStrings(
            translations = translations,
            defaultLanguageTag = Locales.EN,
            currentLanguageTag = state.appLanguage
        )

        LaunchedEffect(state.isLanguageSelected) {
            if (state.isLanguageSelected)
                lyricist.languageTag = state.appLanguage
        }

        ProvideStrings(
            lyricist = lyricist,
            provider = LocalOnboardingStrings
        ) {
            OnboardingScreenImpl(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                onAction = {
                    viewModel.onAction(it)
                    when (it) {
                        OnboardingAction.NavigateToSearch -> navigator.replace(searchScreen)
                        else -> Unit
                    }
                }
            )
        }
    }
}

@Composable
internal fun OnboardingScreenImpl(
    modifier: Modifier = Modifier,
    onAction: (OnboardingAction) -> Unit
) {

    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 2 }
    )

    Box(modifier = modifier) {

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            userScrollEnabled = false
        ) { page ->

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                when (page) {

                    0 -> WelcomeSectionContent(
                        modifier = Modifier
                            .widthIn(max = 800.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        onClick = {
                            if (!pagerState.isScrollInProgress) {
                                scope.launch {
                                    pagerState.animateScrollToPage(
                                        page = 1,
                                        animationSpec = tween(durationMillis = 400)
                                    )
                                }
                            }
                        }
                    )

                    1 -> LanguageSelectionContent(
                        modifier = Modifier
                            .widthIn(max = 800.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        onSelected = {
                            if (!pagerState.isScrollInProgress) {
                                onAction(OnboardingAction.OnChangeSearchLanguage(it))
                                onAction(OnboardingAction.NavigateToSearch)
                            }
                        }
                    )
                }
            }
        }
    }
}