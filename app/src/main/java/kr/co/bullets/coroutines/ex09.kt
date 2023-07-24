package kr.co.bullets.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doThree() {
    println("launch3: ${Thread.currentThread().name}")
    delay(1000L)
    println("3!")
}

suspend fun doOne() {
    println("launch1: ${Thread.currentThread().name}")
//    delay(500L)
    println("1!")
}

suspend fun doTwo() {
    println("runBlocking: ${Thread.currentThread().name}")
    delay(500L)
    println("2!")
}

fun main() = runBlocking<Unit> {
    launch {
        doThree()
    }
    launch {
        doOne()
    }
    doTwo()
}

// No main method found in project.
// main은 반드시 반환값이 없어야된는데 Int로 반환값이 있게되어서 Error
//fun main(): Int = runBlocking<Int> {
//    launch {
//        doThree()
//    }
//    launch {
//        doOne()
//    }
//    doTwo()
//    3
//}
