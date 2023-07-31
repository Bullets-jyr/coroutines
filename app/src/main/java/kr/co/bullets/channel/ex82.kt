package kr.co.bullets.channel.ex82

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        for (x in 1..10) {
            channel.send(x)
        }
        channel.close()
    }

    for (x in channel) {
        println(x)
    }
    println("완료")
}