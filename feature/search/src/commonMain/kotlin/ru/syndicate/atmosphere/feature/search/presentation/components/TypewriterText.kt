package ru.syndicate.atmosphere.feature.search.presentation.components

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import kotlinx.coroutines.delay

@Composable
internal fun TypewriterText(
    baseText: String? = null,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    color: Color,
    parts: List<String>
) {

    var partIndex by remember { mutableIntStateOf(0) }
    var partText by remember { mutableStateOf("") }
    val textToDisplay = if (baseText.isNullOrBlank()) partText
    else "$baseText $partText"

    LaunchedEffect(parts) {
        while (partIndex <= parts.size) {

            val part = parts[partIndex]

            part.forEachIndexed { charIndex, _ ->
                partText = part.substring(startIndex = 0, endIndex = charIndex + 1)
                delay(100)
            }

            delay(2500)

            part.forEachIndexed { charIndex, _ ->
                partText = part
                    .substring(startIndex = 0, endIndex = part.length - (charIndex + 1))
                delay(60)
            }

            delay(500)

            partIndex = (partIndex + 1) % parts.size
        }
    }

    Text(
        text = textToDisplay,
        style = LocalTextStyle.current,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color
    )
}