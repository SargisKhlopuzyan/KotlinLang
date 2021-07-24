package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines.composingSuspendingFunctions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum()}")
        }
        println("Completed in $time ms")
    }

    println("** ** ** ** ** ** ** ** ** **")

    runBlocking {
        try {
            failedConcurrentSum()
        } catch (e: ArithmeticException) {
            println("Computation failed with ArithmeticException")
        }
    }
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne5() }
    val two = async { doSomethingUsefulTwo5() }
    one.await() + two.await()
}

suspend fun doSomethingUsefulOne5(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo5(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

// Cancellation is always propagated through coroutines hierarchy
suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE) // Emulates very long computation
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}