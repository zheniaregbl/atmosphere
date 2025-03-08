rootProject.name = "atmosphere"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenLocal()
    }
}

include(":composeApp")
include(":core")
include(":widget")
include(":feature:splash")
include(":feature:onboarding")
include(":feature:home")
include(":feature:search")
include(":feature:settings")
include(":feature:weather_detail")
include(":feature:forecast")