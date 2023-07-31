package kr.co.bullets.channel.ex88

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

suspend fun produceNumbers(channel: SendChannel<Int>, from: Int, interval: Long) {
    var x = from
    while (true) {
        channel.send(x)
        x += 2
        delay(interval)
    }
}

fun CoroutineScope.processNumber(channel: ReceiveChannel<Int>) = launch {
    channel.consumeEach {
        println("${it}을 받았습니다.")
    }
}


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        produceNumbers(channel, 1, 100L)
    }
    launch {
        produceNumbers(channel, 2, 150L)
    }
    processNumber(channel)
    delay(1000L)
    coroutineContext.cancelChildren()
}