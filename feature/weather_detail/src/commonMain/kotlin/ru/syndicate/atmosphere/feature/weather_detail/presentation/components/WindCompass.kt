package ru.syndicate.atmosphere.feature.weather_detail.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import ru.syndicate.atmosphere.feature.weather_detail.presentation.translation.util.LocalDetailsStrings
import ru.syndicate.atmosphere.feature.weather_detail.resources.Res
import ru.syndicate.atmosphere.feature.weather_detail.resources.arrow_left_svg

@Composable
internal fun WindCompass(
    modifier: Modifier = Modifier,
    speed: Int = 0,
    direction: Int = 0
) {

    Box(modifier = modifier) {

        Canvas(
            modifier = Modifier
                .matchParentSize()
                .padding(18.dp)
        ) {

            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2 - 2.dp.toPx()
            val strokeWidth = 2.dp.toPx()

            drawArc(
                color = Color.White,
                startAngle = 12f,
                sweepAngle = 67f,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(strokeWidth)
            )

            drawArc(
                color = Color.White,
                startAngle = 102f,
                sweepAngle = 67f,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(strokeWidth)
            )

            drawArc(
                color = Color.White,
                startAngle = 192f,
                sweepAngle = 67f,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(strokeWidth)
            )

            drawArc(
                color = Color.White,
                startAngle = 282f,
                sweepAngle = 67f,
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(strokeWidth)
            )
        }

        SideText(modifier = modifier)

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(22.dp)
                .align(Alignment.Center)
                .rotate(90f + direction.toFloat())
        ) {
            Image(
                modifier = Modifier.size(18.dp),
                painter = painterResource(Res.drawable.arrow_left_svg),
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = speed.toString(),
                style = LocalTextStyle.current,
                lineHeight = 14.sp,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White
            )

            Text(
                text = LocalDetailsStrings.current.windUnit,
                style = LocalTextStyle.current,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun SideText(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 10.dp),
            text = LocalDetailsStrings.current.northSide[0].toString(),
            style = LocalTextStyle.current,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 14.dp),
            text = LocalDetailsStrings.current.eastSide[0].toString(),
            style = LocalTextStyle.current,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            text = LocalDetailsStrings.current.southSide[0].toString(),
            style = LocalTextStyle.current,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp),
            text = LocalDetailsStrings.current.westSide[0].toString(),
            style = LocalTextStyle.current,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}