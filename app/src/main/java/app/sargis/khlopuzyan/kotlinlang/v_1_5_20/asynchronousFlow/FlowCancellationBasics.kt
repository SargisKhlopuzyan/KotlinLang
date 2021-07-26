package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Created by Sargis Khlopuzyan, on 7/24/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        // Timeout after 250ms
        withTimeoutOrNull(2500) {
            simple5().collect { value -> println(value) }
        }
        println("Done")
    }
}

fun simple5() = flow {
    for (i in 1..5) {
        delay(1000)
        println("Emitting $i")
        emit(i)
    }
}