package com.nimain.atmosphere

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform