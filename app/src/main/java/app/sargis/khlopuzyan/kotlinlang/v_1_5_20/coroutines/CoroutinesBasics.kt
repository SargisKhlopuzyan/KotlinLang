package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/20/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */

fun main() {

    // v1
    runBlocking {
        launch {
            delay(1000L)
            println("World! : v1")
        }
        println("Hello : v1")
    }

    println("** ** ** ** ** ** ** ** ** ** ** ** **")

    // v2
    runBlocking {
        launch { doWorld2() }
        println("Hello : v2")
    }

    println("** ** ** ** ** ** ** ** ** ** ** ** **")

    // v3
    runBlocking {
        doWorld3()
    }

    println("** ** ** ** ** ** ** ** ** ** ** ** **")

    // v4
    runBlocking {
        doWorld4()
        println("Done : v4")
    }

    println("** ** ** ** ** ** ** ** ** ** ** ** **")

    runBlocking {
        repeat(10) {
            launch {
                delay(5000L)
                println(".")
            }
        }
    }

}

suspend fun doWorld2() {
    delay(1000L)
    println("World! : v2")
}

suspend fun doWorld3() {
    coroutineScope {
        launch {
            delay(1000L)
            println("World! : v3")
        }
        println("Hello : v3")
    }
}

suspend fun doWorld4() {
    coroutineScope {
        launch {
            delay(2000L)
            println("World 2 ! : v4")
        }
        launch {
            delay(1000L)
            println("World 1 ! : v4")
        }
        println("Hello : v4")
    }
}