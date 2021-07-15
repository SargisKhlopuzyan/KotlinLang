package app.sargis.khlopuzyan.kotlinlang.v_1.coroutines.basics

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
    yourFirstCoroutineMain()
    bridgingBlockingAndNonBlockingWorldsMain()
    bridgingBlockingAndNonBlockingWorldsMain2()
    waitingForAJobMain()
    structuredConcurrencyMain()
}


fun yourFirstCoroutineMain() {

    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    Thread.sleep(2000L)

    // Or

    thread {
        //        delay(1000L) // Error!!
        Thread.sleep(1000L)
        println("thread -> World!")
    }
    println("thread -> Hello,")
    Thread.sleep(2000L)
}

fun bridgingBlockingAndNonBlockingWorldsMain() {

    // launch a new coroutine in background and continue
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues here immediately

    // but this expression blocks the main thread
    runBlocking {
        delay(4000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
    println("!!!!")
}

//Or

/**
 * Here runBlocking<Unit> { ... } works as an adaptor that is used to start the top-level main coroutine.
 * We explicitly specify its Unit return type, because a well-formed main function in Kotlin has to return Unit.
 * */
//_________________________________________________// start main coroutine
fun bridgingBlockingAndNonBlockingWorldsMain2() = runBlocking<Unit> {

    GlobalScope.launch {
        // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main coroutine continues here immediately
    delay(4000L)      // delaying for 2 seconds to keep JVM alive
    println("!!!!")
}

fun waitingForAJobMain() = runBlocking {
    var x = 1
    // launch a new coroutine and keep a reference to its Job
    val job = GlobalScope.launch {
        delay(1000L)
        println("World! x: $x")
        x = 2
    }

    println("Hello, x: $x")
    x = 3
    delay(4000L)
    x = 4
//    job.join() // wait until child coroutine completes
    x = 5

    // Result
    // Hello, x: 1
    // World! x: 3
}

fun structuredConcurrencyMain() = runBlocking {
    // launch a new coroutine in the scope of runBlocking
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
}