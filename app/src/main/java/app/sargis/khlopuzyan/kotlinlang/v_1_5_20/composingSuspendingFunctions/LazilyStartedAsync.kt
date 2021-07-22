package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.composingSuspendingFunctions

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Created by Sargis Khlopuzyan, on 7/22/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking<Unit> {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne3() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo3() }
            one.start()
            two.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

    println("** ** ** ** ** ** ** ** ** ** **")

    runBlocking<Unit> {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne3() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo3() }
//            one.start()
//            two.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }
}

suspend fun doSomethingUsefulOne3(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo3(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}