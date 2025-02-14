package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.haze.HazeDefaults
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import ru.syndicate.atmosphere.core.presentation.theme.BackgroundColor

@Composable
internal fun ParameterCard(
    modifier: Modifier = Modifier,
    hazeState: HazeState,
    title: @Composable RowScope.() -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .hazeChild(
                state = hazeState,
                style = HazeDefaults
                    .style(
                        backgroundColor = BackgroundColor,
                        tint = HazeTint(color = Color.DarkGray.copy(alpha = .5f)),
                        blurRadius = 8.dp,
                    )
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        Row(
            modifier = Modifier.padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            content = title
        )

        content()
    }
}

@Composable
internal fun ParameterRow(
    parameter: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = parameter,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.White
        )

        Text(
            text = value,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Composable
internal fun ParameterRow(
    parameter: String,
    value: AnnotatedString,
    valueTextStyle: TextStyle
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = parameter,
            style = LocalTextStyle.current,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.White
        )

        Text(
            text = value,
            style = valueTextStyle
        )
    }
}