package kr.co.bullets.coroutines.ex12

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree() = coroutineScope {
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(1000L) // suspension point
        println("3!")
    }
    job.join() // suspension point

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("1!")
    }

    launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L) // suspension point
        println("2!")
    }
    println("4!")
}

fun main() = runBlocking {
    doOneTwoThree()
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}