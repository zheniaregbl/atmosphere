package ru.syndicate.atmosphere.feature.home.presentation.translation.string

import cafe.adriel.lyricist.LyricistStrings
import ru.syndicate.atmosphere.core.presentation.translation.Locales

@LyricistStrings(languageTag = Locales.EN, default = true)
internal val EnStrings = Strings(
    screenTitle = "Home",
    errorStrings = ErrorStrings(
        dialogTitle = "Request error",
        exception = "A local error occurred while trying to fetch the weather.",
        error = "An error occurred while trying to fetch the weather."
    ),
    windTitle = "Wind",
    windUnit = "m/s",
    humidityTitle = "Humidity",
    hourlyForecast = "Hourly forecast",
    feelingTempTitle = "Feel like",
    hugeDiffTempText = "The temperature outside is very different from the readings.",
    smallDiffTempText = "The temperature outside feels slightly different from the readings.",
    noDiffTempText = "The temperature does not differ from the readings.",
    weatherDescTitle = "Weather",
    detailForecastTitle = "Detailed forecast",
    detailForecastDesc = "Check out the weather forecast for today and more.",
    someDayForecastTitle = "7 day forecast",
    someDayForecastDesc = "View a quick overview of the weather forecast for the next 7 days.",
    weatherText = WeatherText(
        clearSky = Pair(
            "Clear sky",
            "The sky is completely clear, offering a bright and sunny day with no clouds in sight. Perfect for outdoor activities!"
        ),
        mainlyClear = Pair(
            "Mainly clear",
            "Mainly clear skies with occasional small clouds. A pleasant and calm day."
        ),
        partlyCloudy = Pair(
            "Partly cloudy",
            "Partly cloudy skies with a mix of sun and clouds. Mild and comfortable."
        ),
        overcast = Pair(
            "Overcast",
            "Overcast skies, fully covered with clouds. Expect a gray and muted atmosphere."
        ),
        fog = Pair(
            "Fog",
            "Dense fog reducing visibility significantly, creating a mysterious and tranquil environment."
        ),
        lightDrizzle = Pair(
            "Light drizzle",
            "Light drizzle with a soft, gentle spray. Barely noticeable but can dampen surfaces."
        ),
        moderateDrizzle = Pair(
            "Moderate drizzle",
            "Moderate drizzle with consistent light rain. Might need an umbrella."
        ),
        heavyDrizzle = Pair(
            "Heavy drizzle",
            "Dense drizzle with a steady, heavier flow. Likely to make outdoor activities challenging."
        ),
        lightFreezingDrizzle = Pair(
            "Light freezing drizzle",
            "Light freezing drizzle with droplets freezing on contact. Surfaces may become slippery."
        ),
        heavyFreezingDrizzle = Pair(
            "Heavy freezing drizzle",
            "Dense freezing drizzle with higher intensity. Roads and sidewalks can turn dangerously icy."
        ),
        slightRain = Pair(
            "Slight rain",
            "Slight rain with a soft, refreshing touch. Great for cooling down."
        ),
        moderateRain = Pair(
            "Moderate rain",
            "Moderate rain with a steady and consistent fall. An umbrella is recommended."
        ),
        heavyRain = Pair(
            "Heavy rain",
            "Heavy rain with a powerful downpour. Visibility may be reduced, and flooding could occur in low-lying areas."
        ),
        lightFreezingRain = Pair(
            "Light freezing rain",
            "Light freezing rain that freezes upon impact. Caution required for icy conditions."
        ),
        heavyFreezingRain = Pair(
            "Heavy freezing rain",
            "Heavy freezing rain with larger droplets freezing rapidly. Extreme caution needed due to significant ice buildup."
        ),
        slightSnowFall = Pair(
            "Slight snow fall",
            "Slight snowfall with light, fluffy flakes. Creates a picturesque, wintry vibe."
        ),
        moderateSnowFall = Pair(
            "Moderate snow fall",
            "Moderate snowfall with steady accumulation. Snow is heavier but still manageable."
        ),
        heavySnowFall = Pair(
            "Heavy snow fall",
            "Heavy snowfall with intense accumulation. Expect disruptions and stunning snowy landscapes."
        ),
        snowGrains = Pair(
            "Snow grains",
            "Tiny, granular snow particles falling intermittently. A delicate and frosty weather event."
        ),
        slightRainShower = Pair(
            "Slight rain shower",
            "Slight rain showers with brief, light bursts. Short-lived but refreshing."
        ),
        moderateRainShower = Pair(
            "Moderate rain shower",
            "Moderate rain showers with stronger bursts. May come and go quickly."
        ),
        violentRainShower = Pair(
            "Violent rain shower",
            "Violent rain showers with intense downpours. Prepare for rapid weather changes."
        ),
        slightSnowShower = Pair(
            "Slight snow shower",
            "Slight snow showers with light, scattered flurries. A touch of winter magic."
        ),
        heavySnowShower = Pair(
            "Heavy snow shower",
            "Heavy snow showers with dense and sudden snowfall. Reduced visibility and quick accumulations possible."
        ),
        thunderstorm = Pair(
            "Thunderstorm",
            "A slight or moderate thunderstorm with occasional lightning and rumbles of thunder. Exciting but generally not severe."
        )
    )
)