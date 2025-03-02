package ru.syndicate.atmosphere.feature.home.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.ES)
internal val EsStrings = Strings(
    screenTitle = "Inicio",
    errorStrings = ErrorStrings(
        dialogTitle = "Error de solicitud",
        exception = "Ocurrió un error local al intentar obtener el clima.",
        error = "Ocurrió un error al intentar obtener el clima."
    ),
    windTitle = "Viento",
    windUnit = "m/s",
    humidityTitle = "Humedad",
    hourlyForecast = "Pronóstico por horas",
    feelingTempTitle = "Se siente como",
    hugeDiffTempText = "La temperatura exterior es muy diferente a las lecturas.",
    smallDiffTempText = "La temperatura exterior se siente ligeramente diferente a las lecturas.",
    noDiffTempText = "La temperatura no difiere de las lecturas.",
    weatherDescTitle = "Clima",
    detailForecastTitle = "Pronóstico detallado",
    detailForecastDesc = "Consulta el pronóstico del tiempo para hoy y más.",
    someDayForecastTitle = "Pronóstico de 7 días",
    someDayForecastDesc = "Vista rápida del pronóstico del tiempo para los próximos 7 días.",
    weatherText = WeatherText(
        clearSky = Pair(
            "Cielo despejado",
            "El cielo está completamente despejado, ofreciendo un día brillante y soleado sin nubes a la vista. ¡Perfecto para actividades al aire libre!"
        ),
        mainlyClear = Pair(
            "Mayormente despejado",
            "Cielos mayormente despejados con pequeñas nubes ocasionales. Un día agradable y tranquilo."
        ),
        partlyCloudy = Pair(
            "Parcialmente nublado",
            "Cielos parcialmente nublados con una mezcla de sol y nubes. Suave y cómodo."
        ),
        overcast = Pair(
            "Nublado",
            "Cielos nublados, completamente cubiertos de nubes. Espera una atmósfera gris y apagada."
        ),
        fog = Pair(
            "Niebla",
            "Niebla densa que reduce significativamente la visibilidad, creando un ambiente misterioso y tranquilo."
        ),
        lightDrizzle = Pair(
            "Llovizna ligera",
            "Llovizna ligera con un rocío suave y delicado. Apenas perceptible pero puede humedecer superficies."
        ),
        moderateDrizzle = Pair(
            "Llovizna moderada",
            "Llovizna moderada con lluvia ligera constante. Podrías necesitar un paraguas."
        ),
        heavyDrizzle = Pair(
            "Llovizna intensa",
            "Llovizna densa con un flujo constante y más intenso. Es probable que dificulte las actividades al aire libre."
        ),
        lightFreezingDrizzle = Pair(
            "Llovizna helada ligera",
            "Llovizna helada ligera con gotas que se congelan al contacto. Las superficies pueden volverse resbaladizas."
        ),
        heavyFreezingDrizzle = Pair(
            "Llovizna helada intensa",
            "Llovizna helada densa con mayor intensidad. Las carreteras y aceras pueden volverse peligrosamente resbaladizas."
        ),
        slightRain = Pair(
            "Lluvia ligera",
            "Lluvia ligera con un toque suave y refrescante. Ideal para refrescarse."
        ),
        moderateRain = Pair(
            "Lluvia moderada",
            "Lluvia moderada con una caída constante y uniforme. Se recomienda un paraguas."
        ),
        heavyRain = Pair(
            "Lluvia intensa",
            "Lluvia intensa con un aguacero potente. La visibilidad puede reducirse y podrían ocurrir inundaciones en zonas bajas."
        ),
        lightFreezingRain = Pair(
            "Lluvia helada ligera",
            "Lluvia helada ligera que se congela al impactar. Precaución por condiciones heladas."
        ),
        heavyFreezingRain = Pair(
            "Lluvia helada intensa",
            "Lluvia helada intensa con gotas más grandes que se congelan rápidamente. Se necesita precaución extrema debido a la acumulación significativa de hielo."
        ),
        slightSnowFall = Pair(
            "Nevada ligera",
            "Nevada ligera con copos suaves y esponjosos. Crea un ambiente invernal pintoresco."
        ),
        moderateSnowFall = Pair(
            "Nevada moderada",
            "Nevada moderada con acumulación constante. La nieve es más intensa pero aún manejable."
        ),
        heavySnowFall = Pair(
            "Nevada intensa",
            "Nevada intensa con acumulación significativa. Espera interrupciones y paisajes nevados impresionantes."
        ),
        snowGrains = Pair(
            "Granos de nieve",
            "Pequeñas partículas de nieve granulares que caen intermitentemente. Un fenómeno climático delicado y helado."
        ),
        slightRainShower = Pair(
            "Chubasco ligero",
            "Chubascos ligeros con ráfagas breves y suaves. De corta duración pero refrescantes."
        ),
        moderateRainShower = Pair(
            "Chubasco moderado",
            "Chubascos moderados con ráfagas más fuertes. Pueden comenzar y terminar rápidamente."
        ),
        violentRainShower = Pair(
            "Chubasco violento",
            "Chubascos violentos con aguaceros intensos. Prepárate para cambios rápidos en el clima."
        ),
        slightSnowShower = Pair(
            "Chubasco de nieve ligero",
            "Chubascos de nieve ligeros con ráfagas dispersas. Un toque de magia invernal."
        ),
        heavySnowShower = Pair(
            "Chubasco de nieve intenso",
            "Chubascos de nieve intensos con nevadas densas y repentinas. Reducción de visibilidad y acumulaciones rápidas posibles."
        ),
        thunderstorm = Pair(
            "Tormenta eléctrica",
            "Una tormenta eléctrica ligera o moderada con relámpagos ocasionales y truenos. Emocionante pero generalmente no severa."
        )
    )
)