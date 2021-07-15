package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2

/**
 * Created by Sargis Khlopuzyan, on 8/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
//    varargFunction(string = "a", "b", "c")
    varargFunction(string = *arrayOf("a", "b", "c"))
    varargFunction("a", "b", "c")
    varargFunction(*arrayOf("a", "b", "c"))
}

fun varargFunction(vararg string: String) {
    println("${string[1]}")
}