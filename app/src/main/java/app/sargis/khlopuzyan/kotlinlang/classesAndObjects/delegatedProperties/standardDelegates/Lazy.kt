package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegatedProperties.standardDelegates

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
    val x = lazyValue
    val y = lazyValue
    val z = lazyValue
}

/**
 * INFO-TODO
 * If the synchronization of initialization delegate is not required, so that multiple threads can
 * execute it simultaneously, pass LazyThreadSafetyMode.PUBLICATION as a parameter to the lazy() function
 *
 *      val lazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION) {...}
 *
 *
 * INFO-TODO
 * if you're sure that the initialization will always happen on the same thread as the one where you use the property,
 * you can use LazyThreadSafetyMode.NONE: it doesn't incur any thread-safety guarantees and the related overhead
 *
 *      val lazyValue: String by lazy(LazyThreadSafetyMode.NONE) {...}
 * */

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}