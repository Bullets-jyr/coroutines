package kr.co.bullets.coroutines.ex37

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
    val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + ceh)
    val job1 = scope.launch { printRandom1() }
    val job2 = scope.launch { printRandom2() }
    joinAll(job1, job2)
}