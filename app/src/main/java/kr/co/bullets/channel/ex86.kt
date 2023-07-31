package kr.co.bullets.channel.ex86

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) {
        send(x++)
    }
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int): ReceiveChannel<Int> = produce {
    for (i in numbers) {
        if (i % prime != 0) {
            send(i)
        }
    }
}


fun main() = runBlocking<Unit> {
    var numbers = numbersFrom(2)

    repeat(10) {
        val prime = numbers.receive()
        println(prime)
        numbers = filter(numbers, prime)
    }
    println("완료")
    coroutineContext.cancelChildren()
}