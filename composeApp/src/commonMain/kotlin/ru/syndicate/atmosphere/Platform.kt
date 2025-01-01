package ru.syndicate.atmosphere

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform