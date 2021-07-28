package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.exceptionTransparency

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
            .onEach { value ->
                check(value <= 1) { "Collected $value" }
                println(value)
            }
            .catch { e -> println("Caught $e") }
            .collect()
    }
}

fun simple2(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}