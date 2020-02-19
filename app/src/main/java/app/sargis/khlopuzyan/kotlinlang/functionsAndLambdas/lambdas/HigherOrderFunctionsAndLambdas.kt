package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * Kotlin functions are first-class, which means that they can be stored in variables and data structures,
 * passed as arguments to and returned from other higher-order functions.
 * You can operate with functions in any way that is possible for other non-function values.
 *
 * To facilitate this, Kotlin, as a statically typed programming language, uses a family of function types
 * to represent functions and provides a set of specialized language constructs, such as lambda expressions.
 *
 *
 * INFO-TODO
 * A higher-order function is a function that takes functions as parameters, or returns a function.
 *
 * */

fun main() {

    val list = mutableListOf(1, 2, 3, 4, 5)

    val foldResult1 = list.fold(
        "a",
        { x: String, y: Int ->
            x + y
        }
    )
    println(foldResult1)

    val foldResult2 = list.fold(
        5,
        { x, y ->
            // Parameter types in a lambda are optional if they can be inferred:
            x - y
        }
    )
    println(foldResult2)

    val foldResult3 = list.fold(
        "a"
    ) { x: String, y: Int ->
        x + y
    }
    println(foldResult3)

    val foldResult4 = list.fold(
        5
    ) { x, y ->
        // Parameter types in a lambda are optional if they can be inferred:
        x - y
    }
    println(foldResult4)


    //TODO
    // Function references can also be used for higher-order function calls:
    val product = list.fold(1, Int::times)
    println(product)
}

fun <T, R> Collection<T>.fold(
    initial: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}