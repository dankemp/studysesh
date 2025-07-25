package com.example.studysesh

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform