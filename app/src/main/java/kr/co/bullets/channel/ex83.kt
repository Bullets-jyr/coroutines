package kr.co.bullets.channel.ex83

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*


fun main() = runBlocking<Unit> {
    val oneToTen = produce { // ProducerScope = CoroutineScope + SendChannel
        for (x in 1..10) {
            channel.send(x)
        }
    }

    oneToTen.consumeEach {
        println(it)
    }
    println("완료")
}