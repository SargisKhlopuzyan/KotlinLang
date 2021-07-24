package app.sargis.khlopuzyan.kotlinlang.v_1_5_20

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 7/21/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {

    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm in sleeping $i ...")
                    delay(500)
                }
            } finally {
                try {
                    suspendFunctionInFinal()
                } catch (e: CancellationException) {
                    println("e: $e")
                }
            }
        }

        delay(1300) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }

    println("** ** ** ** ** ** ** ** ** ** ** **")

    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm in sleeping $i ...")
                    delay(500)
                }
            } finally {
                withContext(NonCancellable) {
                    println("job: I'm running finally")
                    delay(1000)
                    println("job: And I've just delayed for 1 sec because I'm non-cancellable")
                }
            }
        }

        delay(1300) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin()
        println("main: Now I can quit.")
    }
}

suspend fun suspendFunctionInFinal() {
    coroutineScope {
        launch {
            repeat(100) {
                delay(2000)
                println("main: I am in suspendFunctionInFinal")
            }
        }
    }
}