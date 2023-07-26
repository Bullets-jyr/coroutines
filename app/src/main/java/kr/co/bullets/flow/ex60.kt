package kr.co.bullets.flow.ex60

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simple(): Flow<Int> = flow { // 플로우 내에서는 컨텍스트를 바꿀 수 없음.
//    withContext(Dispatchers.Default) {
        for (i in 1..10) {
            delay(100L)
            emit(i)
        }
//    }
}

fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO) {
        simple()
            .collect { value -> log("${value}를 받음.") }
    }
}