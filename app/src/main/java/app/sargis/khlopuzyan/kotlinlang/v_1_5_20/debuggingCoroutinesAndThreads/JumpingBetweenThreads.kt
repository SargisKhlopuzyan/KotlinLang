package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.debuggingCoroutinesAndThreads

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun log2(msg: String) = println("[${Thread.currentThread().name}] $msg")

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    @OptIn(ExperimentalCoroutinesApi::class)
    newSingleThreadContext("Ctx1").use { ctx1 -> // Executor Coroutine Dispatcher
        newSingleThreadContext("Ctx2").use { ctx2 -> // Executor Coroutine Dispatcher
            runBlocking(ctx1) {
                log("Started in ctx1")
                withContext(ctx2) {
                    log("Working in ctx2")
                }
                log("Back to ctx1")
            }
        }
    }
}