package kr.co.bullets.coroutines

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun getRandom1(): Int {
    try {
        delay(1000L)
        return Random.nextInt(0, 500)
    } finally {
        println("getRandom1 is cancelled.")
    }
}

suspend fun getRandom2(): Int {
    delay(500L)
    throw IllegalStateException()
}

suspend fun doSomething() = coroutineScope {
    val value1 = async { getRandom1() }
    val value2 = async { getRandom2() }
    try {
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    } finally {
        println("doSomething is cancelled.")
    }
}

fun main() = runBlocking {
    try {
        doSomething()
    } catch (e: IllegalStateException) {
        println("doSomething failed: $e")
    }
}