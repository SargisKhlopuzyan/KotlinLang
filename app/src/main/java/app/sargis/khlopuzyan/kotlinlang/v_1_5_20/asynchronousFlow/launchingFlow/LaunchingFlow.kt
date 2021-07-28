package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.launchingFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/28/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
//    runBlocking {
//        events().onEach { event -> println("Event: $event") }
//            .collect() // <--- Collecting the flow waits
//        println("Done")
//    }

    println("** ** ** ** ** ** ** ** ** ** ** ** ** **")

    runBlocking {
        events().onEach { event -> println("Event: $event") }
            .launchIn(this)
        println("Done")
    }
}

// Imitate a flow of events
fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(1000) }