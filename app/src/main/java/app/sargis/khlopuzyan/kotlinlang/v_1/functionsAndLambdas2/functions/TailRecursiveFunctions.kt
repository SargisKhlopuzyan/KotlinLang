package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2.functions

import kotlin.math.abs
import kotlin.math.cos

fun main() {
    var x = findFixPoint(1.0)
    println(x)
}

val eps = 1E-10 // "good enough", could be 10^-15

/**
 * Kotlin supports a style of functional programming known as tail recursion.
 * This allows some algorithms that would normally be written using loops to instead
 * be written using a recursive function, but without the risk of stack overflow.
 * When a function is marked with the tailrec modifier and meets the required form, the compiler
 * optimises out the recursion, leaving behind a fast and efficient loop based version instead:
 * */
tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (abs(x - cos(x)) < eps) {
        x
    }
    else
        findFixPoint(cos(x))


private fun findFixPoint2(t: Double = 1.0): Double {
    var x = t
    while (true) {
        val y = cos(x)
        if (abs(x - y) < eps)
            return x
        x = cos(x)
    }
}

/**
 * To be eligible for the tailrec modifier, a function must call itself as the last operation it performs.
 * You cannot use tail recursion when there is more code after the recursive call, and you cannot use it
 * within try/catch/finally blocks. Currently, tail recursion is supported by Kotlin for JVM and Kotlin/Native.
 * */