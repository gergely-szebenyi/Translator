package com.prekogdevs.translator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform