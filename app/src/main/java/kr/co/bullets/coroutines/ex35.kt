package kr.co.bullets.coroutines.ex35

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun printRandom1() {
    delay(1000L)
    println(Random.nextInt(0, 500))
}

suspend fun printRandom2() {
    delay(500L)
    throw ArithmeticException()
}

val ceh = CoroutineExceptionHandler { _, exception ->
    println("Something happend: $exception")
}

fun main() = runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch (ceh) {
        launch { printRandom1() }
        launch { printRandom2() }
    }
    job.join()
}