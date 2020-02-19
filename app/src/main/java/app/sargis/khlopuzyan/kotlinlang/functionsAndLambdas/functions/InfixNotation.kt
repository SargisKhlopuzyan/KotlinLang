package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.functions

/**
 * Created by Sargis Khlopuzyan, on 2/18/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Functions marked with the infix keyword can also be called using the infix notation
 * (omitting the dot and the parentheses for the call).
 *
 * Infix functions must satisfy the following requirements:
 * - They must be member functions or extension functions;
 * - They must have a single parameter;
 * - The parameter must not accept variable number of arguments and must have no default value.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Infix function calls have lower precedence than the arithmetic operators,
 * type casts, and the rangeTo operator. The following expressions are equivalent:
 *
 * 1 shl 2 + 3 is equivalent to 1 shl (2 + 3)
 * 0 until n * 2 is equivalent to 0 until (n * 2)
 * xs union ys as Set<*> is equivalent to xs union (ys as Set<*>)
 * On the other hand, infix function call's precedence is higher than that of the boolean operators && and ||,
 * is- and in-checks, and some other operators. These expressions are equivalent as well:
 *
 * a && b xor c is equivalent to a && (b xor c)
 * a xor b in c is equivalent to (a xor b) in c
 * See the Grammar reference for the complete operators precedence hierarchy.
 *
 * */
infix fun Int.sha1(x: Int): Int {
    return this * x * 8 / 7
}

fun main() {
    val x = 6 sha1 3
    println(x)

    val myStringCollection =
        MyStringCollection()

    myStringCollection.add("abc")
    myStringCollection add "abc"
}

class MyStringCollection {
    infix fun add(s: String) { /*...*/ }

    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
//        add "abc"        // Incorrect: the receiver must be specified
    }
}