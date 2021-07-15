package app.sargis.khlopuzyan.kotlinlang.v_1.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main2() = runBlocking {
    // launch a lot of coroutines
    repeat(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}


fun main3() = runBlocking {
    repeat(100_000) {
        thread {
            Thread.sleep(2000L)
            print(".")
        }
    }
}

// Global coroutines are like daemon threads
/**
 * The following code launches a long-running coroutine in GlobalScope that prints
 * "I'm sleeping" twice a second and then returns from the main function after some delay:
 * */
fun main() = runBlocking {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // just quit after delay
    /**
     * I'm sleeping 0 ...
     * I'm sleeping 1 ...
     * I'm sleeping 2 ...
     *
     * Active coroutines that were launched in GlobalScope do not keep the process alive. They are like daemon threads.
     * */
}