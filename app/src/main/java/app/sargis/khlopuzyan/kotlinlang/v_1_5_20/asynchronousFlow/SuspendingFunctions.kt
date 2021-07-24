package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/24/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */

fun main() {
    runBlocking {
        simple2().forEach { value ->
            println(value)

        }
    }
}

suspend fun simple2(): List<Int> {
    delay(2000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}