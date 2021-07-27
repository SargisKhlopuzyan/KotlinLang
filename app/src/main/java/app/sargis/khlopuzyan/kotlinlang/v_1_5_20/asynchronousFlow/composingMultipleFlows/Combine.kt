package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.composingMultipleFlows

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

        val nums = (1..3).asFlow().onEach {
            delay(300) // numbers 1..3 every 300 ms
        }

        val strs = flowOf("one", "two", "three").onEach {
            delay(400) // strings every 400 ms
        }

        val startTime = System.currentTimeMillis() // remember the start time

        nums.zip(strs) { a, b -> "$a -> $b" } // compose a single string with "zip"
            // collect and print
            .collect { value ->
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
    }

    println("** ** ** ** ** ** ** ** ** ** ** ** ** **")

    runBlocking {

        val nums = (1..3).asFlow().onEach {
            delay(300) // numbers 1..3 every 300 ms
        }

        val strs = flowOf("one", "two", "three").onEach {
            delay(400) // strings every 400 ms
        }

        val startTime = System.currentTimeMillis() // remember the start time

        nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string with "zip"
            // collect and print
            .collect { value ->
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
    }
}