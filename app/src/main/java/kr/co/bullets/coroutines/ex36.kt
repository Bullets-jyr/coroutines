package kr.co.bullets.coroutines.ex36

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun getRandom1(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom2(): Int {
    delay(500L)
    throw ArithmeticException()
}

val ceh = CoroutineExceptionHandler { _, exception ->
    println("Something happend: $exception")
}

fun main() = runBlocking<Unit> {
    val job = launch (ceh) { // ceh가 동작하지 않습니다.
        val a = async { getRandom1() }
        val b = async { getRandom2() }
        println(a.await())
        println(b.await())
    }
    job.join()
}