package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.flatteningFlows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/27/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        val startTime = System.currentTimeMillis() // remember the start time
        (1..3).asFlow().onEach { delay(1000) } // a number every 1000 ms
            .flatMapConcat { requestFlow2(it) }
            .collect { value -> // collect and print
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
    }
}

fun requestFlow2(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(5000) // wait 5000 ms
    emit("$i: Second")
}