package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.coroutineContextAndDispatchers

import kotlinx.coroutines.*

/**
 * Created by Sargis Khlopuzyan, on 7/23/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    runBlocking {
        // context of the parent, main runBlocking coroutine
        launch {
            println("main runBlocking : I'm working in thread ${Thread.currentThread().name}")
        }

        // not confined -- will work with main thread
        launch(Dispatchers.Unconfined) {
            println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
        }

        // will get dispatched to DefaultDispatcher
        launch(Dispatchers.Default) {
            println("Default : I'm working in thread ${Thread.currentThread().name}")
        }

        // will get its own new thread
        @OptIn(ExperimentalCoroutinesApi::class)
        launch(newSingleThreadContext("MyOwnThread")) {
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }
}