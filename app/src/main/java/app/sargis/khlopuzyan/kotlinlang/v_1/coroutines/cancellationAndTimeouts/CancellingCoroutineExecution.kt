package app.sargis.khlopuzyan.kotlinlang.v_1.coroutines.cancellationAndTimeouts

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Cancelling coroutine execution
 *
 * INFO-TODO
 *
 * In a long-running application you might need fine-grained control on your background coroutines.
 * For example, a user might have closed the page that launched a coroutine and
 * now its result is no longer needed and its operation can be cancelled.
 * The launch function returns a Job that can be used to cancel the running coroutine:
 * */
fun main() = runBlocking {

    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")

//    It produces the following output:
//        job: I'm sleeping 0 ...
//        job: I'm sleeping 1 ...
//        job: I'm sleeping 2 ...
//        main: I'm tired of waiting!
//        main: Now I can quit.
}