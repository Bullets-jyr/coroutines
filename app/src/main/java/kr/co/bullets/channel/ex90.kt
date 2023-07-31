package kr.co.bullets.channel.ex90

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.selects.*

fun CoroutineScope.sayFast() = produce<String> {
    while (true) {
        delay(100L)
        send("Bullets")
    }
}

fun CoroutineScope.sayCampus() = produce<String> {
    while (true) {
        delay(150L)
        send("블렛츠")
    }
}

fun main() = runBlocking<Unit> {
    val fasts = sayFast()
    val campuses = sayCampus()
    repeat (5) {
        select<Unit> {
            fasts.onReceive {
                println("bullets: $it")
            }
            campuses.onReceive {
                println("블렛츠: $it")
            }
        }
    }
    coroutineContext.cancelChildren()
}