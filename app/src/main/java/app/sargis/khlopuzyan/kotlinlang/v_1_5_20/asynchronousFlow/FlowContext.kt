package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

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
        simple6().collect { value -> log("Collected $value") }
    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simple6(): Flow<Int> = flow {
    log("Started simple flow")
    for (i in 1..5) {
        emit(i)
    }
}