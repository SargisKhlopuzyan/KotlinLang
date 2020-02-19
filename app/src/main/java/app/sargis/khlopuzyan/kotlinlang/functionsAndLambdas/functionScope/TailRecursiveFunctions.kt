package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.functionScope

import kotlin.math.abs
import kotlin.math.cos

/**
 * Created by Sargis Khlopuzyan, on 2/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    val result = findFixPoint()
    println("result: $result")

    val result1 = findFixPointError1()
    println("result1: $result1")

    val result2 = findFixPointError2()
    println("result2: $result2")
}

/**
 * INFO-TODO
 * Kotlin supports a style of functional programming known as tail recursion. This allows some algorithms that would normally
 * be written using loops to instead be written using a recursive function, but without the risk of stack overflow.
 * When a function is marked with the tailrec modifier and meets the required form, the compiler optimises out the recursion,
 * leaving behind a fast and efficient loop based version instead:
 *
 *
 * INFO-TODO
 * To be eligible for the tailrec modifier, a function must call itself as the last operation it performs.
 * You cannot use tail recursion when there is more code after the recursive call, and you cannot use it within try/catch/finally blocks.
 * Currently, tail recursion is supported by Kotlin for JVM and Kotlin/Native.
 *
 * */

val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double = if (abs(x - cos(x)) < eps) x else findFixPoint(
    cos(x)
)

// The resulting code is equivalent to this more traditional style:

private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}


/**
 * TODO IMPORTANT
 * TODO WARNING!!  |  WRONG!!
 * A function is marked as tails-recursive but no tail calls are found
 * */
tailrec fun findFixPointError1(x: Double = 1.0): Double =
    if (abs(x - cos(x)) >= eps) findFixPoint(cos(x)) else x

/**
 * TODO IMPORTANT
 * TODO WARNING!!  |  WRONG!!
 * A function is marked as tails-recursive but no tail calls are found
 * */
tailrec fun findFixPointError2(x: Double = 1.0): Double = try {
    x
} catch (e: Exception) {
    findFixPoint(cos(x))
}