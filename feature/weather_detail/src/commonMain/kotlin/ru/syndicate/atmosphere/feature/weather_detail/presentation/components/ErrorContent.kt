package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

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
import ru.syndicate.atmosphere.core.presentation.components.ActionButton
import ru.syndicate.atmosphere.core.presentation.theme.GrayColor
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings

@Composable
internal fun ErrorContent(
    modifier: Modifier = Modifier,
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
            text = LocalDetailsStrings.current.errorContentStrings.title,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = Color.White
        )

        Text(
            text = LocalDetailsStrings.current.errorContentStrings.text,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.White
        )

        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = LocalDetailsStrings.current.errorContentStrings.repeatText,
            isConfirm = true,
            onClick = onRepeat
        )
    }
}