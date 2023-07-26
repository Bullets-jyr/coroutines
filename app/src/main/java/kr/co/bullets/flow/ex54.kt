package kr.co.bullets.flow.ex54

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun someCalc(i: Int): Int {
    delay(10L)
    return i * 2
}

fun main() = runBlocking<Unit> {
    (1..20).asFlow().transform {
        emit(it)
        emit(someCalc(it))
    }.takeWhile {
        it < 15
    }.collect {
        println(it)
    }
}