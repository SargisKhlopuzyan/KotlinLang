package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.debuggingCoroutinesAndThreads

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {

    runBlocking<Unit> {

        val a = async {
            log("I'm computing a piece of the answer")
            6
        }

        val b = async {
            log("I'm computing another piece of the answer")
            7
        }

        log("The answer is ${a.await() * b.await()}")

    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")