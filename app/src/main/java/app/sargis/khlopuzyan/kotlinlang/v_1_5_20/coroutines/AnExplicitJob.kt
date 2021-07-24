package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/22/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        val job = launch {
            delay(1000)
            println("Word!")
        }
        println("Hello")
        job.join()
        println("Done")
    }
}