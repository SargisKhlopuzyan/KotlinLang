package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/**
 * Created by Sargis Khlopuzyan, on 7/26/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {

    runBlocking {
        (1..5).asFlow()
            // a flow of requests
            .transform { request ->
                emit("Making request $request")
                emit(performRequest2(request))
            }
            .collect { response -> println(response) }
    }
}

suspend fun performRequest2(request: Int): String {
    delay(2000)
    return "response $request"
}