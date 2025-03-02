package ru.syndicate.atmosphere.feature.home.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.PT)
internal val PtStrings = Strings(
    screenTitle = "Início",
    errorStrings = ErrorStrings(
        dialogTitle = "Erro na solicitação",
        exception = "Ocorreu um erro local ao tentar obter a previsão do tempo.",
        error = "Ocorreu um erro ao tentar obter a previsão do tempo."
    ),
    windTitle = "Vento",
    windUnit = "m/s",
    humidityTitle = "Umidade",
    hourlyForecast = "Previsão horária",
    feelingTempTitle = "Sensação térmica",
    hugeDiffTempText = "A temperatura externa é muito diferente das leituras.",
    smallDiffTempText = "A temperatura externa parece ligeiramente diferente das leituras.",
    noDiffTempText = "A temperatura não difere das leituras.",
    weatherDescTitle = "Clima",
    detailForecastTitle = "Previsão detalhada",
    detailForecastDesc = "Confira a previsão do tempo para hoje e mais.",
    someDayForecastTitle = "Previsão para 7 dias",
    someDayForecastDesc = "Visão rápida da previsão do tempo para os próximos 7 dias.",
    weatherText = WeatherText(
        clearSky = Pair(
            "Céu limpo",
            "O céu está completamente limpo, oferecendo um dia brilhante e ensolarado sem nuvens. Perfeito para atividades ao ar livre!"
        ),
        mainlyClear = Pair(
            "Predominantemente limpo",
            "Céu predominantemente limpo com pequenas nuvens ocasionais. Um dia agradável e tranquilo."
        ),
        partlyCloudy = Pair(
            "Parcialmente nublado",
            "Céu parcialmente nublado com uma mistura de sol e nuvens. Suave e confortável."
        ),
        overcast = Pair(
            "Nublado",
            "Céu nublado, completamente coberto de nuvens. Espere uma atmosfera cinzenta e abafada."
        ),
        fog = Pair(
            "Nevoeiro",
            "Nevoeiro denso reduzindo significativamente a visibilidade, criando um ambiente misterioso e tranquilo."
        ),
        lightDrizzle = Pair(
            "Chuvisco leve",
            "Chuvisco leve com uma chuva fina e suave. Quase imperceptível, mas pode molhar superfícies."
        ),
        moderateDrizzle = Pair(
            "Chuvisco moderado",
            "Chuvisco moderado com chuva leve constante. Talvez precise de um guarda-chuva."
        ),
        heavyDrizzle = Pair(
            "Chuvisco intenso",
            "Chuvisco denso com um fluxo constante e mais intenso. Pode dificultar as atividades ao ar livre."
        ),
        lightFreezingDrizzle = Pair(
            "Chuvisco gelado leve",
            "Chuvisco gelado leve com gotas que congelam ao toque. As superfícies podem ficar escorregadias."
        ),
        heavyFreezingDrizzle = Pair(
            "Chuvisco gelado intenso",
            "Chuvisco gelado denso com maior intensidade. As estradas e calçadas podem ficar perigosamente escorregadias."
        ),
        slightRain = Pair(
            "Chuva leve",
            "Chuva leve com um toque suave e refrescante. Ideal para se refrescar."
        ),
        moderateRain = Pair(
            "Chuva moderada",
            "Chuva moderada com uma queda constante e uniforme. Recomenda-se um guarda-chuva."
        ),
        heavyRain = Pair(
            "Chuva intensa",
            "Chuva intensa com uma chuva forte. A visibilidade pode ser reduzida e podem ocorrer inundações em áreas baixas."
        ),
        lightFreezingRain = Pair(
            "Chuva gelada leve",
            "Chuva gelada leve que congela ao impacto. Cuidado com as condições geladas."
        ),
        heavyFreezingRain = Pair(
            "Chuva gelada intensa",
            "Chuva gelada intensa com gotas maiores que congelam rapidamente. É necessário extremo cuidado devido ao acúmulo significativo de gelo."
        ),
        slightSnowFall = Pair(
            "Queda de neve leve",
            "Queda de neve leve com flocos leves e fofos. Cria uma atmosfera invernal pitoresca."
        ),
        moderateSnowFall = Pair(
            "Queda de neve moderada",
            "Queda de neve moderada com acúmulo constante. A neve é mais intensa, mas ainda gerenciável."
        ),
        heavySnowFall = Pair(
            "Queda de neve intensa",
            "Queda de neve intensa com acúmulo significativo. Espere interrupções e paisagens nevadas impressionantes."
        ),
        snowGrains = Pair(
            "Grãos de neve",
            "Pequenas partículas de neve granulares que caem intermitentemente. Um fenômeno meteorológico delicado e gelado."
        ),
        slightRainShower = Pair(
            "Aguaceiro leve",
            "Aguaceiros leves com rajadas curtas e suaves. De curta duração, mas refrescantes."
        ),
        moderateRainShower = Pair(
            "Aguaceiro moderado",
            "Aguaceiros moderados com rajadas mais fortes. Podem começar e terminar rapidamente."
        ),
        violentRainShower = Pair(
            "Aguaceiro violento",
            "Aguaceiros violentos com chuvas torrenciais. Prepare-se para mudanças rápidas no clima."
        ),
        slightSnowShower = Pair(
            "Aguaceiro de neve leve",
            "Aguaceiros de neve leves com flocos esparsos. Um toque de magia invernal."
        ),
        heavySnowShower = Pair(
            "Aguaceiro de neve intenso",
            "Aguaceiros de neve intensos com quedas de neve densas e repentinas. Redução de visibilidade e acúmulos rápidos possíveis."
        ),
        thunderstorm = Pair(
            "Trovoada",
            "Uma trovoada leve ou moderada com relâmpagos ocasionais e trovões. Emocionante, mas geralmente não severa."
        )
    )
)