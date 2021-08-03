package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
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
        val squares = produceSquares()
        squares.consumeEach {
            println(it)
        }
        println("Done!")
    }
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
//        println("I'm sleeping $x ...")
        delay(1500)
        send(x * x)
    }
}