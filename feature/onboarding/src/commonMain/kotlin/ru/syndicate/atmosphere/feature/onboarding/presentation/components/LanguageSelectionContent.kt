package ru.syndicate.atmosphere.feature.onboarding.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.core.presentation.components.ConfirmButton
import ru.syndicate.atmosphere.core.presentation.components.LanguagePicker
import ru.syndicate.atmosphere.core.presentation.components.rememberPickerState
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@Composable
internal fun LanguageSelectionContent(
    modifier: Modifier = Modifier,
    onSelected: () -> Unit
) {

    val languagePickerState = rememberPickerState()
    val languages = listOf(
        Pair("English", "en"),
        Pair("Русский", "ru"),
        Pair("Deutsch", "de"),
        Pair("Français", "fr"),
        Pair("Español", "es"),
        Pair("Italiano", "it"),
        Pair("Português", "pt")
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "Select app language",
                style = LocalTextStyle.current,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "Select the application language to continue.",
                style = LocalTextStyle.current,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.White
            )
        }

        LanguagePicker(
            modifier = Modifier.width(200.dp),
            textModifier = Modifier.padding(10.dp),
            state = languagePickerState,
            items = languages.map { it.first },
            startIndex = languages.map { it.second }.indexOf(Locales.EN),
            fontSize = 18.sp,
            itemColor = Color.White,
            borderColor = Color.White
        )

        ConfirmButton(
            modifier = Modifier.width(300.dp),
            text = "Continue",
            onClick = onSelected
        )
    }
}