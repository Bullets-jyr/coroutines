package kr.co.bullets.coroutines.ex33

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun printRandom() {
    delay(500L)
    println(Random.nextInt(0, 500))
}

fun main() {
    val job = GlobalScope.launch(Dispatchers.IO) {
        launch { printRandom() }
    }
    Thread.sleep(1000L)
}