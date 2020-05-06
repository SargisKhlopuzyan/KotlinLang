package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas2.functions

/**
 * Function scope
 *
 * In Kotlin functions can be declared at top level in a file,
 * meaning you do not need to create a class to hold a function,
 * which you are required to do in languages such as Java, C# or Scala.
 * In addition to top level functions, Kotlin functions can also be declared local,
 * as member functions and extension functions.
 * */

/** top level function */
fun topLevelFunction() {

}

fun main() {
    FunctionScope().memberFunction(10)
}

class FunctionScope {

    /** member function */
    fun memberFunction(x: Int) {

        println(x)

//        localFunction(10) // Error

        /** local function */
        fun localFunction(y: Int) {
            println(x + y)
        }

        println(x)

        localFunction(10)
    }
}

/** extension function */
fun Int.extensionFunction() {

}