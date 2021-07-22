package app.sargis.khlopuzyan.kotlinlang.v_1_5_20

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * Created by Sargis Khlopuzyan, on 7/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */

var acquired = 0

class Resource {
    init {
        acquired++
    } // Acquire the resource

    fun close() {
        acquired--
    } // Release the resource
}

fun main() {
    runBlocking {
        repeat(1_000_000) { // Launch 100K coroutines
            launch {
//                try{
                val resource = withTimeout(60) { // Timeout of 60 ms
                    delay(50) // Delay for 50 ms
                    Resource() // Acquire a resource and return it from withTimeout block
                }
                resource.close() // Release the resource
//                } catch (e: Exception) {
//                    println("Exception : $e")
//                }
            }
        }
    }

    // Outside of runBlocking all coroutines have completed
    println(acquired) // Print the number of resources still acquired

//    println("** ** ** ** ** ** ** ** ** ** **")
//
//    runBlocking {
//        repeat(1_000_000) { // Launch 100K coroutines
//            launch {
//                var resource: Resource? = null // Not acquired yet
//                try {
//                    withTimeout(60) { // Timeout of 60 ms
//                        delay(50) // Delay for 50 ms
//                        resource =
//                            Resource() // Acquire a resource and return it from withTimeout block
//                    }
//                    // We can do something else with the resource here
//                } finally {
//                    resource?.close() // Release the resource if it was acquired
//                }
//            }
//        }
//    }
//    // Outside of runBlocking all coroutines have completed
//    println(acquired) // Print the number of resources still acquired

}