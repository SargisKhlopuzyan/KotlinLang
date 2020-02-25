package app.sargis.khlopuzyan.kotlinlang.coroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() = runBlocking {

    launch {
        doWorld()
    }

    println("Hello,")

}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}