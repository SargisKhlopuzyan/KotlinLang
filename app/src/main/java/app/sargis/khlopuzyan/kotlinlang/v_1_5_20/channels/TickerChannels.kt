package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.channels

import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Created by Sargis Khlopuzyan, on 8/5/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking<Unit> {
        val tickerChannel =
            ticker(delayMillis = 100, initialDelayMillis = 0) // create ticker channel
        var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
        println("Initial element is available immediately: $nextElement") // no initial delay
        nextElement =
            withTimeoutOrNull(50) { tickerChannel.receive() } // all subsequent elements have 100ms delay
        println("Next element is not ready in 50 ms: $nextElement")
        nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
        println("Next element is ready in 100 ms: $nextElement")
        // Emulate large consumption delays
        println("Consumer pauses for 150ms")
        delay(150)
        // Next element is available immediately
        nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
        println("Next element is available immediately after large consumer delay: $nextElement")
        // Note that the pause between `receive` calls is taken into account and next element arrives faster
        nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
        println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")
        tickerChannel.cancel() // indicate that no more elements are needed
    }
}