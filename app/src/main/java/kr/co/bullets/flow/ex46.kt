package kr.co.bullets.flow.ex46

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun flowSomething(): Flow<Int> = flow {
    repeat(10) {
        emit(Random.nextInt(0, 500))
        delay(100L)
    }
}

fun main() = runBlocking<Unit> {
    // withTimeout으로 가능
    val result = withTimeoutOrNull(500L) {
        flowSomething().collect { value ->
            println(value)
        }
        true
    } ?: false
    if (!result) {
        println("취소되었습니다.")
    }
}