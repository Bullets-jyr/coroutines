package kr.co.bullets.flow.ex51

import kotlin.random.Random
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    (1..20).asFlow().filterNot {
        (it % 2) == 0
    }.map {
        it * 3
    }.collect {
        println(it)
    }
}