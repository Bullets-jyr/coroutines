package kr.co.bullets.channel.ex87

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) {
        send(x++)
        delay(100L)
    }
}

fun CoroutineScope.processNumber(id: Int, channel: ReceiveChannel<Int>) = launch {
    channel.consumeEach {
        println("${id}가 ${it}을 받았습니다.")
    }
}


fun main() = runBlocking<Unit> {
    val producer = produceNumbers()
    repeat (5) {
        processNumber(it, producer)
    }
    delay(1000L)
    producer.cancel()
}