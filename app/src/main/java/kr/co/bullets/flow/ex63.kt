package kr.co.bullets.flow.ex63

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.*

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple().buffer()
            .collect { value ->
                delay(300)
                println(value)
            }
    }
    println("Collected in $time ms")
}