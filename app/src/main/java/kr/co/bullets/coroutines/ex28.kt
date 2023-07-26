package kr.co.bullets.coroutines.ex28

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    async {
        println("부모의 콘텍스트 / ${Thread.currentThread().name}")
    }

    async(Dispatchers.Default) {
        println("Default / ${Thread.currentThread().name}")
    }

    async(Dispatchers.IO) {
        println("IO / ${Thread.currentThread().name}")
    }

    async(Dispatchers.Unconfined) {
        println("Unconfined / ${Thread.currentThread().name}")
    }

    async(newSingleThreadContext("Bullets")) {
        println("newSingleThreadContext / ${Thread.currentThread().name}")
    }
}