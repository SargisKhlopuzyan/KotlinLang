package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/26/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        // a flow of requests
        (1..5).asFlow()
            .map { request -> performRequest(request) }
            .collect { response -> println(response) }
    }
}

suspend fun performRequest(request: Int): String {
    delay(2000) // imitate long-running asynchronous work
    return "response $request"
}