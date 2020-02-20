package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/20/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * Lambda Expressions and Anonymous Functions
 * Lambda expressions and anonymous functions are 'function literals',
 * i.e. functions that are not declared, but passed immediately as an expression.
 * */
fun main() {

//    val lambda: (String, String) -> Boolean = { str1, str2 ->
//        str1.equals(str2, true)
//    }

    val result1 = max("ARG_1") { str1, str2 ->
        str1.equals(str2, true)
    }
    //Or
    val result2 = max("ARG_1", { str1, str2 ->
        str1.equals(str2, true)
    })
    //Or
    val result3 = max("ARG_1", ::compare)
}

fun max(arg1: String, lambda: (String, String) -> Boolean) {
    println("arg1: $arg1 lambda: ${lambda.invoke("a", "A")}")
    //Or
    println("arg1: $arg1 lambda: ${lambda("a", "A")}")
}

fun compare(a: String, b: String): Boolean = a.equals(b, true)