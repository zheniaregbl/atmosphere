package ru.syndicate.atmosphere.feature.home.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.FR)
internal val FrStrings = Strings(
    screenTitle = "Accueil",
    errorStrings = ErrorStrings(
        dialogTitle = "Erreur de requête",
        exception = "Une erreur locale s'est produite lors de la tentative d'obtention de la météo.",
        error = "Une erreur s'est produite lors de la tentative d'obtention de la météo."
    ),
    windTitle = "Vent",
    windUnit = "m/s",
    humidityTitle = "Humidité",
    hourlyForecast = "Prévision horaire",
    feelingTempTitle = "Ressenti",
    hugeDiffTempText = "La température extérieure est très différente des relevés.",
    smallDiffTempText = "La température extérieure semble légèrement différente des relevés.",
    noDiffTempText = "La température ne diffère pas des relevés.",
    weatherDescTitle = "Météo",
    detailForecastTitle = "Prévision détaillée",
    detailForecastDesc = "Consultez les prévisions météo pour aujourd'hui et plus.",
    someDayForecastTitle = "Prévision sur 7 jours",
    someDayForecastDesc = "Aperçu rapide des prévisions météo pour les 7 prochains jours.",
    weatherText = WeatherText(
        clearSky = Pair(
            "Ciel dégagé",
            "Le ciel est complètement dégagé, offrant une journée ensoleillée et lumineuse sans nuages. Parfait pour les activités en plein air !"
        ),
        mainlyClear = Pair(
            "Principalement dégagé",
            "Ciel principalement dégagé avec quelques petits nuages occasionnels. Une journée agréable et calme."
        ),
        partlyCloudy = Pair(
            "Partiellement nuageux",
            "Ciel partiellement nuageux avec un mélange de soleil et de nuages. Doux et confortable."
        ),
        overcast = Pair(
            "Couvert",
            "Ciel couvert, entièrement recouvert de nuages. Attendez-vous à une atmosphère grise et terne."
        ),
        fog = Pair(
            "Brouillard",
            "Brouillard dense réduisant considérablement la visibilité, créant un environnement mystérieux et paisible."
        ),
        lightDrizzle = Pair(
            "Bruine légère",
            "Bruine légère avec une pluie fine et douce. À peine perceptible mais peut humidifier les surfaces."
        ),
        moderateDrizzle = Pair(
            "Bruine modérée",
            "Bruine modérée avec une pluie légère constante. Un parapluie pourrait être nécessaire."
        ),
        heavyDrizzle = Pair(
            "Bruine intense",
            "Bruine dense avec un flux constant et plus intense. Peut rendre les activités en plein air difficiles."
        ),
        lightFreezingDrizzle = Pair(
            "Bruine verglaçante légère",
            "Bruine verglaçante légère avec des gouttes qui gèlent au contact. Les surfaces peuvent devenir glissantes."
        ),
        heavyFreezingDrizzle = Pair(
            "Bruine verglaçante intense",
            "Bruine verglaçante dense avec une intensité plus élevée. Les routes et les trottoirs peuvent devenir dangereusement glissants."
        ),
        slightRain = Pair(
            "Pluie légère",
            "Pluie légère avec une touche douce et rafraîchissante. Idéal pour se rafraîchir."
        ),
        moderateRain = Pair(
            "Pluie modérée",
            "Pluie modérée avec une chute constante et régulière. Un parapluie est recommandé."
        ),
        heavyRain = Pair(
            "Pluie intense",
            "Pluie intense avec une averse puissante. La visibilité peut être réduite et des inondations peuvent survenir dans les zones basses."
        ),
        lightFreezingRain = Pair(
            "Pluie verglaçante légère",
            "Pluie verglaçante légère qui gèle à l'impact. Prudence en raison des conditions glacées."
        ),
        heavyFreezingRain = Pair(
            "Pluie verglaçante intense",
            "Pluie verglaçante intense avec des gouttes plus grosses qui gèlent rapidement. Une extrême prudence est nécessaire en raison de l'accumulation importante de glace."
        ),
        slightSnowFall = Pair(
            "Chute de neige légère",
            "Chute de neige légère avec des flocons légers et duveteux. Crée une ambiance hivernale pittoresque."
        ),
        moderateSnowFall = Pair(
            "Chute de neige modérée",
            "Chute de neige modérée avec une accumulation régulière. La neige est plus intense mais encore gérable."
        ),
        heavySnowFall = Pair(
            "Chute de neige intense",
            "Chute de neige intense avec une accumulation importante. Attendez-vous à des perturbations et à des paysages enneigés impressionnants."
        ),
        snowGrains = Pair(
            "Grains de neige",
            "Petites particules de neige granuleuses tombant par intermittence. Un phénomène météorologique délicat et glacé."
        ),
        slightRainShower = Pair(
            "Averse légère",
            "Averses légères avec des bourrasques courtes et douces. De courte durée mais rafraîchissantes."
        ),
        moderateRainShower = Pair(
            "Averse modérée",
            "Averses modérées avec des bourrasques plus fortes. Peuvent commencer et se terminer rapidement."
        ),
        violentRainShower = Pair(
            "Averse violente",
            "Averses violentes avec des pluies torrentielles. Préparez-vous à des changements météorologiques rapides."
        ),
        slightSnowShower = Pair(
            "Averse de neige légère",
            "Averses de neige légères avec des flocons épars. Une touche de magie hivernale."
        ),
        heavySnowShower = Pair(
            "Averse de neige intense",
            "Averses de neige intenses avec des chutes de neige denses et soudaines. Réduction de la visibilité et accumulations rapides possibles."
        ),
        thunderstorm = Pair(
            "Orage",
            "Un orage léger ou modéré avec des éclairs occasionnels et des grondements de tonnerre. Passionnant mais généralement pas sévère."
        )
    )
)