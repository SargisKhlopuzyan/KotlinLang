package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2.functions

/**
 * Functions marked with the infix keyword can also be called using the infix notation
 * (omitting the dot and the parentheses for the call).
 * Infix functions must satisfy the following requirements:
 *
 * They must be member functions or extension functions;
 * They must have a single parameter;
 * The parameter must not accept variable number of arguments and must have no default value.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Infix function calls have lower precedence than the arithmetic operators,
 * type casts, and the rangeTo operator.
 * The following expressions are equivalent:
 *
 * 1 shl 2 + 3 is equivalent to 1 shl (2 + 3)
 * 0 until n * 2 is equivalent to 0 until (n * 2)
 * xs union ys as Set<*> is equivalent to xs union (ys as Set<*>)
 * On the other hand, infix function call's precedence is higher than that of the boolean operators
 * && and ||, is- and in-checks, and some other operators. These expressions are equivalent as well:
 *
 * a && b xor c is equivalent to a && (b xor c)
 * a xor b in c is equivalent to (a xor b) in c
 *
 * */
fun main() {

    // calling the function using the infix notation
    1 shl 2

    // is the same as
    1.shl(2)

    // **************************************************

    // val isExist = 55.from(arrayOf(1, 2, 3, 4, 5, 6, 7))
    val isExist = 55 from arrayOf(1, 2, 3, 4, 5, 6, 7)
    println(isExist)
}

infix fun Int.shl(x: Int): Int {
    return x * this
}

// **************************************************

infix fun <T> T.from(array: Array<T>): Boolean {
    return array.contains(this)
}

// **************************************************

/**
 * Note that infix functions always require both the receiver and the parameter to be specified.
 * When you're calling a method on the current receiver using the infix notation,
 * you need to use this explicitly; unlike regular method calls, it cannot be omitted.
 * This is required to ensure unambiguous parsing.
 * */
class MyStringCollection {

    var str = ""

    infix fun add(s: String) {
        str.plus(s)
    }

    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
//        add "abc"        // Incorrect: the receiver must be specified
    }
}