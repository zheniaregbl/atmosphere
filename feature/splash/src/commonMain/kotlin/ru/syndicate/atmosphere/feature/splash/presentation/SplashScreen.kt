package ru.syndicate.atmosphere.feature.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.navigation.SharedScreen
import ru.syndicate.atmosphere.feature.splash.resources.Res
import ru.syndicate.atmosphere.feature.splash.resources.fog_svg
import ru.syndicate.atmosphere.feature.splash.resources.open_meteo_svg

class SplashScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val homeScreen = rememberScreen(SharedScreen.HomeScreen)

        SplashScreenImpl(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            onLaunch = { navigator.replace(homeScreen) }
        )
    }
}

@Composable
internal fun SplashScreenImpl(
    modifier: Modifier = Modifier,
    onLaunch: () -> Unit
) {

    LaunchedEffect(Unit) {
        delay(1500)
        onLaunch()
    }

    Box(modifier = modifier) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Image(
                modifier = Modifier.size(160.dp),
                painter = painterResource(Res.drawable.fog_svg),
                contentDescription = null
            )

            Text(
                text = "Atmosphere",
                style = LocalTextStyle.current,
                fontWeight = FontWeight.Medium,
                fontSize = 32.sp,
                color = Color.White
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.Medium)) {
                        append("Powered by ")
                    }
                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("Open-Meteo")
                    }
                },
                style = LocalTextStyle.current,
                fontSize = 14.sp,
                color = Color.White
            )

            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(Res.drawable.open_meteo_svg),
                contentDescription = null
            )
        }
    }
}