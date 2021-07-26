package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/26/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        // Convert an integer range to a flow
        (1..5).asFlow().collect { value -> println(value) }
    }
}