package ru.syndicate.atmosphere.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor

@Composable
fun LanguageDialog(
    showDialog: Boolean,
    initialValue: String,
    title: String,
    buttonText: String,
    languages: List<Pair<String, String>> =
        listOf(
            Pair("English", "en"),
            Pair("Russian", "ru"),
            Pair("German", "de"),
            Pair("French", "fr"),
            Pair("Spanish", "es"),
            Pair("Italian", "it"),
            Pair("Portuguese", "pt")
        ),
    onSelectedLanguage: (String) -> Unit,
    onDismissRequest: () -> Unit = { }
) {

    DialogPopup(
        showDialog = showDialog,
        onDismissRequest = onDismissRequest
    ) {
        LanguageDialogUI(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(
                    horizontal = 14.dp,
                    vertical = 18.dp
                ),
            title = title,
            buttonText = buttonText,
            initialValue = initialValue,
            languages = languages,
            onSelectedLanguage = onSelectedLanguage
        )
    }
}

@Composable
internal fun LanguageDialogUI(
    modifier: Modifier = Modifier,
    title: String,
    buttonText: String,
    initialValue: String,
    languages: List<Pair<String, String>>,
    onSelectedLanguage: (String) -> Unit
) {

    val languagePickerState = rememberPickerState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {

        Text(
            text = title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LanguagePicker(
                modifier = Modifier.width(200.dp),
                textModifier = Modifier.padding(10.dp),
                state = languagePickerState,
                items = languages.map { it.first },
                startIndex = languages.map { it.second }.indexOf(initialValue),
                fontSize = 18.sp,
                itemColor = Color.White,
                borderColor = Color.White
            )
        }

        ActionButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            text = buttonText,
            isConfirm = true,
            onClick = {
                onSelectedLanguage(
                    languages
                        .find { it.first == languagePickerState.selectedItem }!!
                        .second
                )
            }
        )
    }
}