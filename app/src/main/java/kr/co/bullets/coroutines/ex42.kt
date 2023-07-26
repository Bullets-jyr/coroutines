package kr.co.bullets.coroutines.ex42

import java.util.concurrent.atomic.*
import kotlin.system.*
import kotlinx.coroutines.*

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100 // 시작할 코루틴의 갯수
    val k = 1000 // 코루틴 내에서 반복할 횟수
    val elapsed = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("$elapsed ms동안 ${n * k}개의 액션을 수행했습니다.")
}

var counter = 0
val counterContext = newSingleThreadContext("CounterContext")

fun main() = runBlocking {
    withContext(Dispatchers.Default) { // 전체 코드를 하나의 스레드에서...
        massiveRun {
            withContext(counterContext) { // 더하는 코드를 하나의 스레드에서...
                counter++
            }
        }
    }
    println("Counter = $counter")
}