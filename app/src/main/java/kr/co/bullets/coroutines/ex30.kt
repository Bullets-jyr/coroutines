package kr.co.bullets.coroutines.ex30

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job = launch {
        launch(Job()) { // Job()을 새로 만들 경우, 부모, 자식 관계가 끊어집니다.
            println(coroutineContext[Job])
            println("launch1: ${Thread.currentThread().name}")
            delay(1000L)
            println("3!")
        }

        launch {
            println(coroutineContext[Job])
            println("launch2: ${Thread.currentThread().name}")
            delay(1000L)
            println("1!")
        }
    }

    delay(500L)
    job.cancelAndJoin()
    delay(1000L)
}