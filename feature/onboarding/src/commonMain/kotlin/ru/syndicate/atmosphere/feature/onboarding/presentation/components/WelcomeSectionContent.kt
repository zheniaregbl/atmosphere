package ru.syndicate.atmosphere.feature.onboarding.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.core.presentation.components.ConfirmButton

@Composable
internal fun WelcomeSectionContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(52.dp)
    ) {

        Text(
            text = "Welcome to Atmosphere",
            style = LocalTextStyle.current,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.White
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = "In order to continue you need:",
                style = LocalTextStyle.current,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )

            Text(
                text = "- Select application language",
                style = LocalTextStyle.current,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )

            Text(
                text = "- Select a city to view the weather",
                style = LocalTextStyle.current,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
        }

        ConfirmButton(
            modifier = Modifier.width(300.dp),
            text = "Continue",
            onClick = onClick
        )
    }
}