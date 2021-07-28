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
        simple()
            .catch { e -> emit("Caught $e") } // emit on exception
            .collect { value -> println(value) }
    }
}

fun simple(): Flow<String> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // emit next value
    }
}.map { value ->
    check(value <= 1) { "Cached on $value" }
    "string $value"
}