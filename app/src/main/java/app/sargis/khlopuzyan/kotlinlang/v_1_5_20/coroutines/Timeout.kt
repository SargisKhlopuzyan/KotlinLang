package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 7/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */

fun main() {
//    runBlocking {
//        withTimeout(1300) {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500)
//            }
//        }
//    }

    runBlocking {
        val result = withTimeoutOrNull(1300) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500)
            }
            "Done"
        }
        println("Result is $result")
    }

    runBlocking {
        val result = withTimeoutOrNull(1300) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
//                delay(500)
            }
            "Done"
        }
        println("Result is $result")
    }
}