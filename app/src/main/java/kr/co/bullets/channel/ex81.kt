package kr.co.bullets.channel.ex81

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*


fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        for (x in 1..10) {
            channel.send(x)
        }

        repeat(10) {
            println(channel.receive())
        }
        println("완료")
    }
}