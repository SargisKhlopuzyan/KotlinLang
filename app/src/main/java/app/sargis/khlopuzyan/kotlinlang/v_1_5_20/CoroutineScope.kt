package app.sargis.khlopuzyan.kotlinlang.v_1_5_20

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        val activity = Activity()
        activity.doSomething() // run test function
        println("Launched coroutines")
        delay(500L) // delay for half a second
        println("Destroying activity!")
        activity.destroy() // cancels all coroutines
        delay(1000) // visually confirm that they don't work
    }
}

class Activity {
    // private val mainScope = MainScope()
    private val mainScope = CoroutineScope(Dispatchers.Default) // use Default for test purposes

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        // launch ten coroutines for a demo, each working for a different time
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, ... etc
                println("Coroutine $i is done")
            }
        }
    }
}