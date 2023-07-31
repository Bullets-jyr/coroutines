package kr.co.bullets.flow.ex78

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(100) }

fun main() = runBlocking<Unit> {
    events()
        .onEach { event -> println("Event: $event") }
        .collect()
    println("Done")
}