package kr.co.bullets.coroutines.ex31

import kotlin.system.*
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val elapsed = measureTimeMillis {
        val job = launch { // 부모
            launch { // 자식 1
                println("launch1: ${Thread.currentThread().name}")
                delay(5000L)
            }

            launch { // 자식 2
                println("launch2: ${Thread.currentThread().name}")
                delay(10L)
            }
        }
        job.join()
    }
    println(elapsed)
}