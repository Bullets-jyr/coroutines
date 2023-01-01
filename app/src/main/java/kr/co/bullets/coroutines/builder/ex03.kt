package kr.co.bullets.coroutines.builder

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println(coroutineContext)
    println(this.coroutineContext)
    println(Thread.currentThread().name)
    println("Hello")
}