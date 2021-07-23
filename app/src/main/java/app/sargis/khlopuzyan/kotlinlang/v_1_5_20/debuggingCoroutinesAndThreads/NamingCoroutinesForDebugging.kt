package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.debuggingCoroutinesAndThreads

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {

    runBlocking(CoroutineName("main")) {

        log3("Started main coroutine")
        // run two background value computations

        val v1 = async (CoroutineName("v1coroutine") ) {
            delay(500)
            log("Computing v1")
            252
        }

        val v2 = async (CoroutineName("v2coroutine") ) {
            delay(1000)
            log("Computing v2")
            6
        }

        log3("The answer for v1 / v2 = ${v1.await() / v2.await()}")
    }
}

fun log3(msg: String) = println("[${Thread.currentThread().name}] $msg")