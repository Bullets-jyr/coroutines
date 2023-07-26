package kr.co.bullets.coroutines.ex38

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

suspend fun supervisoredFunc() = supervisorScope {
    launch { printRandom1() }
    launch(ceh) { printRandom2() }
}

val ceh = CoroutineExceptionHandler { _, exception ->
    println("Something happend: $exception")
}

fun main() = runBlocking<Unit> {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch {
        supervisoredFunc()
    }
    job.join()
}