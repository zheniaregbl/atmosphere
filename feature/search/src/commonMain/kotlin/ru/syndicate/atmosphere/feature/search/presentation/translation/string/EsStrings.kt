package ru.syndicate.atmosphere.feature.search.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.ES)
internal val EsStrings = Strings(
    screenTitle = "Buscar",
    hintText = "Introduce una ciudad...",
    cityList = listOf("Moscú", "Londres", "Madrid", "París", "Roma", "Lisboa", "Berlín"),
    errorMessageNotFoundLocation = "No se pudo encontrar un lugar con ese nombre.",
    errorMessageProblemRequest = "No se pudo encontrar la ubicación debido a un problema con la solicitud."
)