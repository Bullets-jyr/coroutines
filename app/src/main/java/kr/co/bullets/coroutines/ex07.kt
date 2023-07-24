package kr.co.bullets.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("launch1: ${Thread.currentThread().name}")
//        delay(1000L) // suspension point (중단점)
        delay(200L) // suspension point (중단점)
        println("3!")
    }
    launch {
        println("launch2: ${Thread.currentThread().name}")
        delay(1000L) // suspension point (중단점)
        println("1!")
    }
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L) // suspension point (중단점)
    println("2!")
}