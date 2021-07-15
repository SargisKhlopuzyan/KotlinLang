package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2

/**
 * Created by Sargis Khlopuzyan, on 8/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    unitFunction("Jack")
    unitFunction(null)
}

fun unitFunction(name: String?): Unit {
    if (name != null) {
        println("Hello $name")
        return Unit
    } else {
        println("Hi there!")
    }
}