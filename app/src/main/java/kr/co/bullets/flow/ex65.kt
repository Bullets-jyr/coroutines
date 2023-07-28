package kr.co.bullets.flow.ex65

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
        simple().collectLatest { value ->
            println("값 ${value}를 처리하기 시작합니다.")
            delay(300)
            println(value)
            println("처리를 완료하였습니다.")
        }
    }
    println("Collected in $time ms")
}