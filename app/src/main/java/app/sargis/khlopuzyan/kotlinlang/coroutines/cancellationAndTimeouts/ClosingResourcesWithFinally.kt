package app.sargis.khlopuzyan.kotlinlang.coroutines.cancellationAndTimeouts

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 2/26/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 *
 * Cancellable suspending functions throw CancellationException on cancellation which can be handled in the usual way.
 * For example, try {...} finally {...} expression and Kotlin use function execute their finalization actions normally when a coroutine is cancelled
 * */
fun main() = runBlocking {

    val job = launch {
        try {
            repeat(1000) {
                println("job: I'am sleeping $ ...")
                delay(500L)
            }
        } finally {
            println("job: I'am running finally")
        }
    }

    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")

//    Result
//    _____________________________
//    job: I'm sleeping 0 ...
//    job: I'm sleeping 1 ...
//    job: I'm sleeping 2 ...
//    main: I'm tired of waiting!
//    job: I'm running finally
//    main: Now I can quit.
}