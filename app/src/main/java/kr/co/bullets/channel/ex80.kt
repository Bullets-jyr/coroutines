package kr.co.bullets.channel.ex80

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        for (x in 1..10) {
            channel.send(x) // suspension point
        }
    }

    repeat(10) {
        println(channel.receive()) // suspension point
    }
    println("완료")
}