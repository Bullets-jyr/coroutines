package kr.co.bullets.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun doOneTwoThree(): Unit {
    // launch는 반드시 코루틴 안에서 호출이 되어야합니다.
//    launch { // this: 코루틴. Receiver. 수신객체
//        println("launch1: ${Thread.currentThread().name}")
//        delay(1000L) // suspension point
//        println("3!")
//    }
//
//    launch { // this: 코루틴. Receiver. 수신객체
//        println("launch2: ${Thread.currentThread().name}")
//        println("1!")
//    }
//
//    launch { // this: 코루틴. Receiver. 수신객체
//        println("launch3: ${Thread.currentThread().name}")
//        delay(500L) // suspension point
//        println("2!")
//    }
    println("4!")
}

fun main(): Unit = runBlocking<Unit> { // this: 코루틴. Receiver. 수신객체
    doOneTwoThree() // suspension point
    println("runBlocking: ${Thread.currentThread().name}")
    println("5!")
}