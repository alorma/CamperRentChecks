package com.alorma.camperrent

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform