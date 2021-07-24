package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/24/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        // Launch a concurrent coroutine to check if the main thread is blocked
        launch {
            for (k in 1..3) {
                println("I'm not blocked $k")
                delay(2000)
            }
        }

        // Collect the flow
        simple3().collect { value ->
            println(value)
        }
    }
}

fun simple3(): Flow<Int> = flow {
    for (i in 1..3) {
//        Thread.sleep(2000)
        delay(1000) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}