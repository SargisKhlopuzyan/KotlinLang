package app.sargis.khlopuzyan.kotlinlang.v_1.coroutines.cancellationAndTimeouts

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Created by Sargis Khlopuzyan, on 2/26/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main2() = runBlocking {

    withTimeout(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }

//    It produces the following output:
//
//        I'm sleeping 0 ...
//        I'm sleeping 1 ...
//        I'm sleeping 2 ...
//        Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1300 ms

}

fun main() = runBlocking {

    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // will get cancelled before it produces this result
    }
    println("Result is $result")

//    There is no longer an exception when running this code:
//
//        I'm sleeping 0 ...
//        I'm sleeping 1 ...
//        I'm sleeping 2 ...
//        Result is null
}