package app.sargis.khlopuzyan.kotlinlang.v_1.coroutines.basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 2/25/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Scope builder
 *
 * INFO-TODO
 *
 * In addition to the coroutine scope provided by different builders,
 * it is possible to declare your own scope using coroutineScope builder.
 * It creates a coroutine scope and does not complete until all launched children complete.
 *
 * runBlocking and coroutineScope may look similar because they both wait for its body and all its children to complete.
 * The main difference between these two is that the runBlocking method blocks the current thread for waiting,
 * while coroutineScope just suspends, releasing the underlying thread for other usages. Because of that difference,
 * runBlocking is a regular function and coroutineScope is a suspending function.
 * */
//_____________________// this: CoroutineScope
fun main() = runBlocking {

    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    //_____________// Creates a coroutine scope
    coroutineScope {

        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
}