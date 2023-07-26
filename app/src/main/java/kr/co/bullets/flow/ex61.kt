package kr.co.bullets.flow.ex61

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

// 모든 것이 상대적인 순서 (업, 다운 스트림)
fun simple(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(100L)
        log("값 ${i}를 emit합니다.")
        emit(i)
    } // 업 스트림: Dispatchers.Default
}.map {
    it * 2 // 업 스트림
}.flowOn(Dispatchers.Default)

fun main() = runBlocking<Unit> {
    simple().collect { value -> // 다운 스트림
        log("${value}를 받음.")
    }
}