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
        (1..3).asFlow().map {
            println("Map: $it")
            requestFlow(it)
        }.collect {
            println("Collect: $it")
        }
    }
}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(1000) // wait 500 ms
    emit("$i: Second")
}