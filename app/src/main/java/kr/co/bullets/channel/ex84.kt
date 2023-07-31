package kr.co.bullets.channel.ex84

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) {
        send(x++)
    }
}

fun CoroutineScope.produceStringNumbers(numbers: ReceiveChannel<Int>): ReceiveChannel<String> = produce {
    for (i in numbers) {
        send("${i}!")
    }
}


fun main() = runBlocking<Unit> {
    val numbers = produceNumbers()
    val stringNumbers = produceStringNumbers(numbers)

    repeat(5) {
        println(stringNumbers.receive())
    }
    println("완료")
    coroutineContext.cancelChildren()
}