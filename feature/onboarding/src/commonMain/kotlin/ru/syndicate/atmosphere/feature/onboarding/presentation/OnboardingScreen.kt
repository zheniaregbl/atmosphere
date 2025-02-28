package ru.syndicate.atmosphere.feature.onboarding.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.launch
import ru.syndicate.atmosphere.feature.onboarding.presentation.components.LanguageSelectionContent

internal class OnboardingScreen : Screen {

    @Composable
    override fun Content() {

        OnboardingScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        )
    }
}

@Composable
internal fun OnboardingScreenImpl(
    modifier: Modifier = Modifier
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
                    0 -> LanguageSelectionContent(
                        modifier = Modifier
                            .widthIn(max = 800.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        onSelected = { scope.launch { pagerState.animateScrollToPage(1) } }
                    )
                }
            }
        }
    }
}