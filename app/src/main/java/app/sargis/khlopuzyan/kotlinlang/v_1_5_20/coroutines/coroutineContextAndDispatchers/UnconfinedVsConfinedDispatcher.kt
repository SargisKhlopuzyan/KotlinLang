package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines.coroutineContextAndDispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        launch (Dispatchers.Unconfined) { // not confined -- will work with main thread
            println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
            delay(500)
            println("Unconfined : After delay in thread ${Thread.currentThread().name}")
        }
        launch { // context of the parent, main runBlocking coroutine
            println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
            delay(1000)
            println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
        }
    }
}