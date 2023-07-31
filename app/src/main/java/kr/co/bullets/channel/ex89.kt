package kr.co.bullets.channel.ex89

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

suspend fun someone(channel: Channel<String>, name: String) {
    for (comment in channel) {
        println("${name}: ${comment}")
        channel.send(comment.drop(1) + comment.first())
        delay(100L)
    }
}

fun main() = runBlocking<Unit> {
    val channel = Channel<String>()
    launch {
        someone(channel, "민준")
    }
    launch {
        someone(channel, "서연")
    }
    channel.send("Bullets 블렛츠")
    delay(1000L)
    coroutineContext.cancelChildren()
}