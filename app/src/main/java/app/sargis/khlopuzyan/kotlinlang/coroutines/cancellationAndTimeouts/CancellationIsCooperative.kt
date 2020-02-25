package app.sargis.khlopuzyan.kotlinlang.coroutines.cancellationAndTimeouts

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Coroutine cancellation is cooperative. A coroutine code has to cooperate to be cancellable.
 * All the suspending functions in kotlinx.coroutines are cancellable.
 * They check for cancellation of coroutine and throw CancellationException when cancelled.
 * However, if a coroutine is working in a computation and does not check for cancellation,
 * then it cannot be cancelled, like the following example shows:
 * */
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 15) { // computation loop, just wastes CPU
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

    // it continues to print "I'm sleeping" even after cancellation until the job completes by itself after five iterations.
}