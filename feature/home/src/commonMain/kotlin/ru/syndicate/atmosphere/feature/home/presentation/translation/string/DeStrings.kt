package ru.syndicate.atmosphere.feature.home.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.DE)
internal val DeStrings = Strings(
    screenTitle = "Startseite",
    hourlyForecast = "Stündliche Vorhersage",
    weatherParameter = WeatherParameter(
        wind = "Wind",
        humidity = "Luftfeuchtigkeit"
    ),
    feelingTempTitle = "Gefühlt wie",
    hugeDiffTempText = "Die Außentemperatur weicht stark von den Messwerten ab.",
    smallDiffTempText = "Die Außentemperatur fühlt sich leicht anders an als die Messwerte.",
    noDiffTempText = "Die Temperatur unterscheidet sich nicht von den Messwerten.",
    weatherDescTitle = "Wetter",
    detailForecastTitle = "Detaillierte Vorhersage",
    detailForecastDesc = "Überprüfen Sie die Wettervorhersage für heute und mehr.",
    someDayForecastTitle = "7-Tage-Vorhersage",
    someDayForecastDesc = "Schneller Überblick über die Wettervorhersage für die nächsten 7 Tage.",
    weatherText = WeatherText(
        clearSky = Pair(
            "Klarer Himmel",
            "Der Himmel ist völlig klar und bietet einen hellen und sonnigen Tag ohne Wolken. Perfekt für Outdoor-Aktivitäten!"
        ),
        mainlyClear = Pair(
            "Überwiegend klar",
            "Überwiegend klarer Himmel mit gelegentlichen kleinen Wolken. Ein angenehmer und ruhiger Tag."
        ),
        partlyCloudy = Pair(
            "Teilweise bewölkt",
            "Teilweise bewölkter Himmel mit einer Mischung aus Sonne und Wolken. Mild und angenehm."
        ),
        overcast = Pair(
            "Bedeckt",
            "Bedeckter Himmel, vollständig mit Wolken bedeckt. Erwarten Sie eine graue und gedämpfte Atmosphäre."
        ),
        fog = Pair(
            "Nebel",
            "Dichter Nebel, der die Sicht erheblich reduziert und eine mysteriöse und friedliche Umgebung schafft."
        ),
        lightDrizzle = Pair(
            "Leichter Nieselregen",
            "Leichter Nieselregen mit einem sanften, feinen Sprühregen. Kaum wahrnehmbar, kann aber Oberflächen benetzen."
        ),
        moderateDrizzle = Pair(
            "Mäßiger Nieselregen",
            "Mäßiger Nieselregen mit gleichmäßigem, leichtem Regen. Vielleicht benötigen Sie einen Regenschirm."
        ),
        heavyDrizzle = Pair(
            "Starker Nieselregen",
            "Dichter Nieselregen mit einem stetigen und stärkeren Fluss. Kann Outdoor-Aktivitäten erschweren."
        ),
        lightFreezingDrizzle = Pair(
            "Leichter gefrierender Nieselregen",
            "Leichter gefrierender Nieselregen mit Tropfen, die bei Kontakt gefrieren. Oberflächen können rutschig werden."
        ),
        heavyFreezingDrizzle = Pair(
            "Starker gefrierender Nieselregen",
            "Dichter gefrierender Nieselregen mit höherer Intensität. Straßen und Gehwege können gefährlich rutschig werden."
        ),
        slightRain = Pair(
            "Leichter Regen",
            "Leichter Regen mit einem sanften, erfrischenden Gefühl. Ideal zum Abkühlen."
        ),
        moderateRain = Pair(
            "Mäßiger Regen",
            "Mäßiger Regen mit gleichmäßigem und stetigem Fall. Ein Regenschirm wird empfohlen."
        ),
        heavyRain = Pair(
            "Starker Regen",
            "Starker Regen mit einem kräftigen Schauer. Die Sicht kann eingeschränkt sein, und in tiefer gelegenen Gebieten können Überschwemmungen auftreten."
        ),
        lightFreezingRain = Pair(
            "Leichter gefrierender Regen",
            "Leichter gefrierender Regen, der beim Aufprall gefriert. Vorsicht bei vereisten Bedingungen."
        ),
        heavyFreezingRain = Pair(
            "Starker gefrierender Regen",
            "Starker gefrierender Regen mit größeren Tropfen, die schnell gefrieren. Extreme Vorsicht ist aufgrund erheblicher Eisbildung erforderlich."
        ),
        slightSnowFall = Pair(
            "Leichter Schneefall",
            "Leichter Schneefall mit leichten, flauschigen Flocken. Schafft eine malerische Winteratmosphäre."
        ),
        moderateSnowFall = Pair(
            "Mäßiger Schneefall",
            "Mäßiger Schneefall mit stetiger Ansammlung. Der Schnee ist intensiver, aber noch handhabbar."
        ),
        heavySnowFall = Pair(
            "Starker Schneefall",
            "Starker Schneefall mit erheblicher Ansammlung. Erwarten Sie Unterbrechungen und beeindruckende Winterlandschaften."
        ),
        snowGrains = Pair(
            "Schneegriesel",
            "Kleine, körnige Schneepartikel, die zeitweise fallen. Ein zartes und frostiges Wetterphänomen."
        ),
        slightRainShower = Pair(
            "Leichter Regenschauer",
            "Leichte Regenschauer mit kurzen, sanften Böen. Kurzlebig, aber erfrischend."
        ),
        moderateRainShower = Pair(
            "Mäßiger Regenschauer",
            "Mäßige Regenschauer mit stärkeren Böen. Können schnell beginnen und enden."
        ),
        violentRainShower = Pair(
            "Heftiger Regenschauer",
            "Heftige Regenschauer mit intensiven Güssen. Bereiten Sie sich auf schnelle Wetteränderungen vor."
        ),
        slightSnowShower = Pair(
            "Leichter Schneeschauer",
            "Leichte Schneeschauer mit vereinzelten Flocken. Ein Hauch von Wintermagie."
        ),
        heavySnowShower = Pair(
            "Starker Schneeschauer",
            "Starke Schneeschauer mit dichtem und plötzlichem Schneefall. Reduzierte Sicht und schnelle Ansammlungen möglich."
        ),
        thunderstorm = Pair(
            "Gewitter",
            "Ein leichtes oder mäßiges Gewitter mit gelegentlichen Blitzen und Donner. Aufregend, aber in der Regel nicht schwerwiegend."
        )
    )
)