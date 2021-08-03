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

        var cur = numbersFrom(2)

        repeat(10) {
            val prime = cur.receive()
            println(prime)
            cur = filter(cur, prime)
        }

        coroutineContext.cancelChildren() // cancel all children to let main finish
    }
}

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) {
        delay(1500)
        send(x++)
    } // infinite stream of integers from start
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numbers) {
        if (x % prime != 0) {
            send(x)
        }
    }
}