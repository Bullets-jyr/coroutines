package kr.co.bullets.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")
        delay(100L)
        println("World!")
    }
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("Hello")
}