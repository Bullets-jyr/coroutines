package kr.co.bullets.coroutines.ex16

import kotlinx.coroutines.*

suspend fun doCount() = coroutineScope {
    val job1 = launch(Dispatchers.Default) {
        var i = 1
        var nextTime = System.currentTimeMillis() + 100L

        while (i <= 10) {
            val currentTime = System.currentTimeMillis()
            if (currentTime >= nextTime) {
                println(i)
                nextTime = currentTime + 100L
                i++
            }
        }
    }

    delay(200L)
    job1.cancel()
    job1.join()
    println("doCount Done!")
}

fun main() = runBlocking {
    doCount()
}