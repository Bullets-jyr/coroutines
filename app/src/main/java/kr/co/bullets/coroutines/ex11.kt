package kr.co.bullets.coroutines.ex11

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree() = coroutineScope { // this: 코루틴
    this.launch { // this: 코루틴
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }

    launch { // this: 코루틴
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }

    launch { // this: 코루틴
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("2!")
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}