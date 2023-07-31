package kr.co.bullets.channel.ex92

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>(Channel.RENDEZVOUS)
    launch {
        for (x in 1..20) {
            println("${x} 전송중")
            channel.send(x)
        }
        channel.close()
    }

    for (x in channel) {
        println("${x} 수신")
        delay(100L)
    }
    println("완료")
}