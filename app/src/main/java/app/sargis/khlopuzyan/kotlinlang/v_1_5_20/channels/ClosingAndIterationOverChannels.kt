package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 8/3/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {

        val channel = Channel<Int>()
        launch {
            for (x in 1..5) {
                println("I'm sleeping $x ...")
                delay(1500)
                channel.send(x * x)
            }
            channel.close() // we're done sending
        }

        // here we print received values using `for` loop (until the channel is closed)
        for (y in channel) {
            println(y)
        }

        println("Done!")
    }
}