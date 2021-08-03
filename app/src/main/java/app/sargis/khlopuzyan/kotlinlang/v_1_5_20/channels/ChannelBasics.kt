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
            // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
            for (x in 1..5) {
                println("job: I'm sleeping $x ...")
                delay(1500L)
                channel.send(x * x)
            }
        }

        // here we print five received integers:
        repeat(5) { println(channel.receive()) }
        println("Done!")
    }
}