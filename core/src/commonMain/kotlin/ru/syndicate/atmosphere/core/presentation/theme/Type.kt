package ru.syndicate.atmosphere.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import atmosphere.core.generated.resources.Res
import atmosphere.core.generated.resources.inter_bold
import atmosphere.core.generated.resources.inter_medium
import atmosphere.core.generated.resources.inter_regular
import org.jetbrains.compose.resources.Font

@Composable
fun InterFontFamily() = FontFamily(
    Font(Res.font.inter_regular, FontWeight.Normal),
    Font(Res.font.inter_medium, FontWeight.Medium),
    Font(Res.font.inter_bold, FontWeight.Bold)
)

@Composable
fun InterTypography() = Typography().run {

    val interFontFamily = InterFontFamily()

    copy(
        displayLarge = displayLarge.copy(fontFamily = interFontFamily),
        displayMedium = displayMedium.copy(fontFamily = interFontFamily),
        displaySmall = displaySmall.copy(fontFamily = interFontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = interFontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = interFontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = interFontFamily),
        titleLarge = titleLarge.copy(fontFamily = interFontFamily),
        titleMedium = titleMedium.copy(fontFamily = interFontFamily),
        titleSmall = titleSmall.copy(fontFamily = interFontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = interFontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = interFontFamily),
        bodySmall = bodySmall.copy(fontFamily = interFontFamily),
        labelLarge = labelLarge.copy(fontFamily = interFontFamily),
        labelMedium = labelMedium.copy(fontFamily = interFontFamily),
        labelSmall = labelSmall.copy(fontFamily = interFontFamily)
    )
}