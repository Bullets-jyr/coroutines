package kr.co.bullets.coroutines.ex32

import kotlin.system.*
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // CoroutineContext: 부모 + 자식
    launch {  // CoroutineContext
        launch(Dispatchers.IO + CoroutineName("launch1")) { // CoroutineContext
            println("launch1: ${Thread.currentThread().name}")
//            println(coroutineContext[CoroutineDispatcher])
            println(coroutineContext[CoroutineName])
            delay(5000L)
        }

        launch(Dispatchers.Default + CoroutineName("launch2")) { // CoroutineContext
            println("launch2: ${Thread.currentThread().name}")
//            println(coroutineContext[CoroutineDispatcher])
            println(coroutineContext[CoroutineName])
            delay(10L)
        }
    }
}