package ru.syndicate.atmosphere.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.atmosphere.core.presentation.theme.GrayColor

@Composable
fun ErrorContentWithRetry(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    buttonText: String,
    onRepeat: () -> Unit
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(GrayColor)
            .padding(
                horizontal = 14.dp,
                vertical = 18.dp
            ),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(
            text = title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White
        )

        Text(
            text = text,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )

        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = buttonText,
            isConfirm = true,
            onClick = onRepeat
        )
    }
}