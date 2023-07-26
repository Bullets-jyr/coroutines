package kr.co.bullets.coroutines.ex34

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun printRandom() {
    delay(500L)
    println(Random.nextInt(0, 500))
}

fun main() {
    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("Bullets"))
    val job = scope.launch(Dispatchers.IO) {
        launch { printRandom() }
    }
    Thread.sleep(1000L)
}