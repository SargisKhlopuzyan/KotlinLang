package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.functions

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    printHello(
        null
    )
}

/**
 * Functions with block body must always specify return types explicitly,
 * unless it's intended for them to return Unit, in which case it is optional.
 * */
fun printHello(name: String?): Unit {
    if (name != null) {
        println("Hello $name")
    } else {
        println("Hi there!")
        // `return Unit` or `return` is optional
//        return Unit
//        return
    }
}