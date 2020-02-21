package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO_TODO
 * Passing trailing lambdas
 * In Kotlin, there is a convention: if the last parameter of a function is a function,
 * then a lambda expression passed as the corresponding argument can be placed outside the parentheses
 * */
fun main() {
    val myClass3 = MyClass3()

    /**
     * INFO-TODO
     * Such syntax is also known as trailing lambda.
     * */
    myClass3.myFunction(0) { x, y ->
        (x + y).toString()
    }
    // Or
    myClass3.myFunction(0, { x: Int, y: Int -> (x + y).toString() })

    // If the lambda is the only argument to that call, the parentheses can be omitted entirely:
    myClass3.myFunction2 { x, y ->
        (x + y).toString()
    }
}

class MyClass3 {

    val myFunctionType: (Int, Float) -> String = { i: Int, f ->
        (i * f).toString()
    }

    val lambda/*: (Int, Float) -> String*/ = { i: Int, f: Float ->
        (i * f).toString()
    }

    fun myFunction(x: Int, lambda: (Int, Int) -> String) {
        if (lambda(x, x).startsWith("0", true)) {
            println("x starts with 0")
        } else {
            println("x does not start with 0")
        }
    }

    fun myFunction2(lambda: (Int, Int) -> String) {

        val x = 4
        val y = 14

        if (lambda(x, x).startsWith("0", true)) {
            println("x starts with 0")
        } else {
            println("x does not start with 0")
        }
    }
}