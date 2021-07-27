package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/26/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        (1..5).asFlow()
            .filter {
                println("Filter $it")
                it % 2 == 0
            }
            .map {
                println("Map $it")
                "String $it"
            }.collect {
                println("Collect $it")
            }
    }
}