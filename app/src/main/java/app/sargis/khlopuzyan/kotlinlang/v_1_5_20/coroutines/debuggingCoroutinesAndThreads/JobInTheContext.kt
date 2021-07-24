package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines.debuggingCoroutinesAndThreads

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        println("My job is ${coroutineContext[Job]}")
    }
}