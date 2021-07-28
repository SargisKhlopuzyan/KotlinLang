package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.flowCompletion

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/28/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        try {
            simple().collect { value -> println(value) }
        } finally {
            println("Done")
        }
    }
}

fun simple(): Flow<Int> = (1..3).asFlow()