package kr.co.bullets.coroutines.builder

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println(Thread.currentThread().name)
    println("Hello")
}