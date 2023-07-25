package kr.co.bullets.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree() = coroutineScope {
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L)
        println("3!")
    }
    job.join()

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }

    repeat(1000) {
        launch {
            println("launch3: ${Thread.currentThread().name}")
            delay(500L)
            println("2!")
        }
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}