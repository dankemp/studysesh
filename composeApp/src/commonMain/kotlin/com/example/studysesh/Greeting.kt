package com.example.studysesh

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hellooooooooo, ${platform.name}!"
    }
}