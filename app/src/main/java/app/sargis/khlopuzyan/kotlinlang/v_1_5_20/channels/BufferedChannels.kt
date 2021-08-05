package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 8/5/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking<Unit> {

        val channel = Channel<Int>(4) // create buffered channel

        val sender = launch { // launch sender coroutine
            repeat(10) {
                println("Sending $it") // print before sending each element
                channel.send(it) // will suspend when buffer is full
            }
        }

        // don't receive anything... just wait....
        delay(1000)

        sender.cancel() // cancel sender coroutine
    }
}