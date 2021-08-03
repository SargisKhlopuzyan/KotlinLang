package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 8/3/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        val numbers = produceNumbers() // produces integers from 1 and on
        val squares = square(numbers) // squares integers

        repeat(5) {
            println(squares.receive()) // print first five
        }

        println("Done!") // we are done
        coroutineContext.cancelChildren() // cancel children coroutines
    }
}

fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}

fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) {
        delay(1500)
        send(x++) // infinite stream of integers starting from 1
    }
}