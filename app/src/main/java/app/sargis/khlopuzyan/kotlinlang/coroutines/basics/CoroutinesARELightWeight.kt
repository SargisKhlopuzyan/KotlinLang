package app.sargis.khlopuzyan.kotlinlang.coroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main2() = runBlocking {
    // launch a lot of coroutines
    repeat(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}


fun main() = runBlocking {
    repeat(100_000) {
        thread {
            Thread.sleep(2000L)
            print(".")
        }
    }
}