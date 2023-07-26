package kr.co.bullets.coroutines.ex24

import kotlin.random.Random
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun getRandom1(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

suspend fun getRandom2(): Int {
    delay(1000L)
    return Random.nextInt(0, 500)
}

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async { // this: 코루틴
            getRandom1()
        }
        val value2 = async { getRandom2() }
        // job.join() + 결과도 가져옴.
        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}") // suspension point
    }
    println(elapsedTime)
}