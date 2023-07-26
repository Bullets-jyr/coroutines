package kr.co.bullets.flow.ex47

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    flowOf(1, 2, 3, 4, 5).collect { value ->
        println(value)
    }
}