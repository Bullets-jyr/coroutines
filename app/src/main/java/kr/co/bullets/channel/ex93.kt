package kr.co.bullets.channel.ex93

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>(2, BufferOverflow.DROP_OLDEST)
    launch {
        for (x in 1..50) {
            channel.send(x)
        }
        channel.close()
    }

    delay(500L)

    for (x in channel) {
        println("${x} 수신")
        delay(100L)
    }
    println("완료")
}