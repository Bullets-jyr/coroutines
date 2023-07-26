package kr.co.bullets.coroutines.ex29

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    async(Dispatchers.Unconfined) {
        println("Unconfined / ${Thread.currentThread().name}")
        delay(1000L) // suspension.point
        println("Unconfined / ${Thread.currentThread().name}")
        delay(1000L) // suspension.point
        println("Unconfined / ${Thread.currentThread().name}")
    }
}