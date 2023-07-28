package kr.co.bullets.flow.ex66

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow()
    val strs = flowOf("일", "이", "삼")
    nums.zip(strs) { a, b -> "${a}은(는) $b" }
        .collect { println(it) }
}