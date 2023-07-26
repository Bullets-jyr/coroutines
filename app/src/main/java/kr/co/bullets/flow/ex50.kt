package kr.co.bullets.flow.ex50

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    (1..20).asFlow().filter {
        (it % 2) == 0 // 술어 predicate
    }.collect {
        println(it)
    }
}