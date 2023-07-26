package kr.co.bullets.coroutines.ex25

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
        val value1 = async(start = CoroutineStart.LAZY) { getRandom1() } // LAZY이기 때문에
        val value2 = async(start = CoroutineStart.LAZY) { getRandom2() }

        value1.start() // 큐에 수행 예약을 한다.
        value2.start()

        println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
    }
    println(elapsedTime)
}