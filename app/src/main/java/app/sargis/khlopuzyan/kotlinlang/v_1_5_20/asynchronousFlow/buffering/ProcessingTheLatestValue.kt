package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.buffering

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Created by Sargis Khlopuzyan, on 7/27/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            simple4()
                .collectLatest { value -> // cancel & restart on the latest value
                    println("Collecting $value")
                    delay(3000) // pretend we are processing it for 3000 ms
                    println("Done $value")
                }
        }

        println("Collected in $time ms")
    }
}

fun simple4(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000) // pretend we are asynchronously waiting 1000 ms
        emit(i) // emit next value
    }
}