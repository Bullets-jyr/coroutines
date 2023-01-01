package kr.co.bullets.coroutines.builder

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println(this)
    println(Thread.currentThread().name)
    println("Hello")
}