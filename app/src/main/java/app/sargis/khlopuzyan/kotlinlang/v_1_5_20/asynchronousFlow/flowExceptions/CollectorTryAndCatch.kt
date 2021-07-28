package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.flowExceptions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/27/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        try {
            simple().collect { value ->
                println(value)
                check(value <= 1) { "Collected $value" }
            }
        } catch (e: Throwable) {
            println("Caught $e")
        }
    }
}

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // emit next value
    }
}