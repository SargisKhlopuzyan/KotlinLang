package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines.debuggingCoroutinesAndThreads

import kotlinx.coroutines.Job
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
        // launch a coroutine to process some kind of incoming request
        val request = launch {
            // it spawns two other jobs
            launch(Job()) {
                println("job1: I run in my own Job and execute independently!")
                delay(1000)
                println("job1: I am not affected by cancellation of the request")
            }
            // and the other inherits the parent context
            launch {
                delay(100)
                println("job2: I am a child of the request coroutine")
                delay(1000)
                println("job2: I will not execute this line if my parent request is cancelled")
            }
        }

        delay(500)
        request.cancel() // cancel processing of the request
        delay(1000) // delay a second to see what happens
        println("main: Who has survived request cancellation?")
    }


    // version 2
    runBlocking {

        var request2: Job? = null

        // launch a coroutine to process some kind of incoming request
        val request = launch {
            // it spawns two other jobs
            request2 = launch(Job()) {
                println("job1: I run in my own Job and execute independently!")
                delay(2000)
                println("job1: I am not affected by cancellation of the request")
            }
            // and the other inherits the parent context
            launch {
                delay(100)
                println("job2: I am a child of the request coroutine")
                delay(1000)
                println("job2: I will not execute this line if my parent request is cancelled")
            }
        }

        delay(500)
        request.cancel() // cancel processing of the request
        delay(1000) // delay a second to see what happens
        println("main: Who has survived request cancellation?")
        request2?.join()
    }
}