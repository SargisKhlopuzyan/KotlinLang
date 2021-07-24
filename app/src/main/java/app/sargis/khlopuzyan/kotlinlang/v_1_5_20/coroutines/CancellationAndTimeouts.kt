package app.sargis.khlopuzyan.kotlinlang.v_1_5_20

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 7/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {

    runBlocking {
        val job = launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }

        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel()
        job.join()
        println("main: Now I can quit.")
    }

    println("** ** ** ** ** ** ** ** ** ** ** **")

    /**
     * v: 1
     * if a coroutine is working in a computation and does not check for cancellation,
     * then it cannot be cancelled, like the following example shows
     * */
    runBlocking {

        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
//        job.cancel() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }

    println("** ** ** ** ** ** ** ** ** ** ** **")

    /**
     * v: 2
     * if a coroutine is working in a computation and does not check for cancellation,
     * then it cannot be cancelled, like the following example shows
     * */
    runBlocking {

        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }

    println("** ** ** ** ** ** ** ** ** ** ** **")

    /**
     * Making computation code cancellable
     * */
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // cancellable computation loop
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}