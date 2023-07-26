package kr.co.bullets.flow.ex57

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun someCalc(i: Int): Int {
    delay(10L)
    return i * 2
}

fun main() = runBlocking<Unit> {
    val value = (1..10)
        .asFlow()
        .fold(10) { a, b ->
            a + b
        }
    println(value)
}