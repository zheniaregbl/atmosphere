package ru.syndicate.atmosphere.feature.home.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.IT)
internal val ItStrings = Strings(
    screenTitle = "Home",
    errorStrings = ErrorStrings(
        dialogTitle = "Errore di richiesta",
        exception = "Si è verificato un errore locale durante il tentativo di ottenere le previsioni meteo.",
        error = "Si è verificato un errore durante il tentativo di ottenere le previsioni meteo."
    ),
    windTitle = "Vento",
    windUnit = "m/s",
    humidityTitle = "Umidità",
    hourlyForecast = "Previsioni orarie",
    feelingTempTitle = "Percepito come",
    hugeDiffTempText = "La temperatura esterna è molto diversa dalle letture.",
    smallDiffTempText = "La temperatura esterna sembra leggermente diversa dalle letture.",
    noDiffTempText = "La temperatura non differisce dalle letture.",
    weatherDescTitle = "Meteo",
    detailForecastTitle = "Previsioni dettagliate",
    detailForecastDesc = "Consulta le previsioni del tempo per oggi e altro.",
    someDayForecastTitle = "Previsioni per 7 giorni",
    someDayForecastDesc = "Panoramica veloce delle previsioni del tempo per i prossimi 7 giorni.",
    weatherText = WeatherText(
        clearSky = Pair(
            "Cielo sereno",
            "Il cielo è completamente sereno, offrendo una giornata luminosa e soleggiata senza nuvole. Perfetto per le attività all'aperto!"
        ),
        mainlyClear = Pair(
            "Prevalentemente sereno",
            "Cielo prevalentemente sereno con occasionali piccole nuvole. Una giornata piacevole e tranquilla."
        ),
        partlyCloudy = Pair(
            "Parzialmente nuvoloso",
            "Cielo parzialmente nuvoloso con un mix di sole e nuvole. Dolce e confortevole."
        ),
        overcast = Pair(
            "Nuvoloso",
            "Cielo nuvoloso, completamente coperto di nuvole. Aspettati un'atmosfera grigia e smorzata."
        ),
        fog = Pair(
            "Nebbia",
            "Nebbia densa che riduce significativamente la visibilità, creando un ambiente misterioso e tranquillo."
        ),
        lightDrizzle = Pair(
            "Pioggerella leggera",
            "Pioggerella leggera con una pioggia fine e delicata. Appena percettibile ma può bagnare le superfici."
        ),
        moderateDrizzle = Pair(
            "Pioggerella moderata",
            "Pioggerella moderata con una pioggia leggera costante. Potrebbe servire un ombrello."
        ),
        heavyDrizzle = Pair(
            "Pioggerella intensa",
            "Pioggerella densa con un flusso costante e più intenso. Potrebbe rendere difficili le attività all'aperto."
        ),
        lightFreezingDrizzle = Pair(
            "Pioggerella gelata leggera",
            "Pioggerella gelata leggera con gocce che si congelano al contatto. Le superfici possono diventare scivolose."
        ),
        heavyFreezingDrizzle = Pair(
            "Pioggerella gelata intensa",
            "Pioggerella gelata densa con maggiore intensità. Le strade e i marciapiedi possono diventare pericolosamente scivolosi."
        ),
        slightRain = Pair(
            "Pioggia leggera",
            "Pioggia leggera con un tocco delicato e rinfrescante. Ideale per rinfrescarsi."
        ),
        moderateRain = Pair(
            "Pioggia moderata",
            "Pioggia moderata con una caduta costante e regolare. Si consiglia un ombrello."
        ),
        heavyRain = Pair(
            "Pioggia intensa",
            "Pioggia intensa con un acquazzone potente. La visibilità può ridursi e potrebbero verificarsi inondazioni nelle zone basse."
        ),
        lightFreezingRain = Pair(
            "Pioggia gelata leggera",
            "Pioggia gelata leggera che si congela all'impatto. Attenzione per le condizioni ghiacciate."
        ),
        heavyFreezingRain = Pair(
            "Pioggia gelata intensa",
            "Pioggia gelata intensa con gocce più grandi che si congelano rapidamente. È necessaria estrema cautela a causa del significativo accumulo di ghiaccio."
        ),
        slightSnowFall = Pair(
            "Nevischio leggero",
            "Nevischio leggero con fiocchi leggeri e soffici. Crea un'atmosfera invernale pittoresca."
        ),
        moderateSnowFall = Pair(
            "Nevischio moderato",
            "Nevischio moderato con accumulo costante. La neve è più intensa ma ancora gestibile."
        ),
        heavySnowFall = Pair(
            "Nevischio intenso",
            "Nevischio intenso con accumulo significativo. Aspettati interruzioni e paesaggi innevati impressionanti."
        ),
        snowGrains = Pair(
            "Granelli di neve",
            "Piccole particelle di neve granulari che cadono a intermittenza. Un fenomeno meteorologico delicato e gelido."
        ),
        slightRainShower = Pair(
            "Rovescio leggero",
            "Rovesci leggeri con brevi e lievi raffiche. Di breve durata ma rinfrescanti."
        ),
        moderateRainShower = Pair(
            "Rovescio moderato",
            "Rovesci moderati con raffiche più forti. Possono iniziare e finire rapidamente."
        ),
        violentRainShower = Pair(
            "Rovescio violento",
            "Rovesci violenti con piogge torrenziali. Preparati a rapidi cambiamenti meteorologici."
        ),
        slightSnowShower = Pair(
            "Rovescio di neve leggero",
            "Rovesci di neve leggeri con fiocchi sparsi. Un tocco di magia invernale."
        ),
        heavySnowShower = Pair(
            "Rovescio di neve intenso",
            "Rovesci di neve intensi con nevicate dense e improvvise. Riduzione della visibilità e accumuli rapidi possibili."
        ),
        thunderstorm = Pair(
            "Temporale",
            "Un temporale leggero o moderato con lampi occasionali e tuoni. Emozionante ma generalmente non grave."
        )
    )
)