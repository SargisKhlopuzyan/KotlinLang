package app.sargis.khlopuzyan.kotlinlang.coroutines.cancellationAndTimeouts

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 2/26/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        // As you can see, now this loop is cancelled. isActive is an extension property available inside the coroutine via the CoroutineScope object.
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