package kr.co.bullets.coroutines.ex27

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch {
        println("부모의 콘텍스트 / ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default / ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("IO / ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined / ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("Bullets")) {
        println("newSingleThreadContext / ${Thread.currentThread().name}")
    }
}