package kr.co.bullets.flow

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    val counter = (1..10)
        .asFlow()
        .count { // 종단 연산자, terminal operator. 특정 값, 컬렉션, 결과 vs 중단 연산자. 결과 X ex) filter
            (it % 2) == 0
        }
    println(counter)
}