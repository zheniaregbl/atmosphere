package ru.syndicate.atmosphere.feature.search.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.core.presentation.theme.GrayColor
import ru.syndicate.atmosphere.core.presentation.theme.SelectedBlue
import ru.syndicate.atmosphere.feature.search.presentation.theme.HintColor
import ru.syndicate.atmosphere.feature.search.resources.Res
import ru.syndicate.atmosphere.feature.search.resources.search_svg

@Composable
internal fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    hintList: List<String>,
    onValueChange: (String) -> Unit,
    onImeSearch: () -> Unit
) {

    CompositionLocalProvider(
        LocalTextSelectionColors provides TextSelectionColors(
            handleColor = SelectedBlue,
            backgroundColor = SelectedBlue
        )
    ) {

        BasicTextField(
            modifier = modifier,
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Color.White
            ),
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { onImeSearch() }
            ),
            singleLine = true,
            cursorBrush = SolidColor(SelectedBlue)
        ) { innerTextField ->

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .background(GrayColor)
                    .padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(Res.drawable.search_svg),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        color = if (value.isNotBlank()) Color.White else HintColor
                    )
                )

                Box(modifier = Modifier.weight(1f)) {

                    innerTextField()

                    if (value.isBlank()) {
                        TypewriterText(
                            baseText = "",
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            color = HintColor,
                            parts = hintList
                        )
                    }
                }
            }
        }
    }
}