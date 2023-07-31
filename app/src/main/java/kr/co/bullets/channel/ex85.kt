package kr.co.bullets.channel.ex85

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) {
        send(x++)
    }
}

fun CoroutineScope.filterOdd(numbers: ReceiveChannel<Int>): ReceiveChannel<String> = produce {
    for (i in numbers) {
        if (i % 2 == 1) {
            send("${i}!")
        }
    }
}


fun main() = runBlocking<Unit> {
    val numbers = produceNumbers()
    val oddNumbers = filterOdd(numbers)

    repeat(10) {
        println(oddNumbers.receive())
    }
    println("완료")
    coroutineContext.cancelChildren()
}