package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow.launchingFlow

import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/28/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
//    runBlocking {
//        foo().collect { value ->
//            if (value == 3) cancel()
//            println(value)
//        }
//    }
//
//    println("** ** ** ** ** ** ** ** ** ** ** **")
//
//    runBlocking {
//        (1..5).asFlow().collect { value ->
//            if (value == 3) cancel()
//            println(value)
//        }
//    }

    println("** ** ** ** ** ** ** ** ** ** ** **")

    // Making busy flow cancellable
    runBlocking {
        (1..5).asFlow().cancellable().collect { value ->
            if (value == 3) cancel()
            println(value)
        }
    }

}

fun foo(): Flow<Int> = flow {
    for (i in 1..5) {
        println("Emitting $i")
        emit(i)
    }
}