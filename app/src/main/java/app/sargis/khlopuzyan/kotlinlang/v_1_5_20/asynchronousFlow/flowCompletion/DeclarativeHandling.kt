package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.flowCompletion

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/28/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        simple2()
            .onCompletion {
                println("Done")
            }
            .collect { value -> println(value) }
    }

    println("** ** ** ** ** ** ** ** ** ** ** ** ** **")

    runBlocking {
        simple3()
            .onCompletion { cause -> if (cause != null) println("Flow completed exceptionally") }
            .catch { cause -> println("Caught exception") }
            .collect { value -> println(value) }
    }
}

fun simple2(): Flow<Int> = (1..3).asFlow()

fun simple3(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}