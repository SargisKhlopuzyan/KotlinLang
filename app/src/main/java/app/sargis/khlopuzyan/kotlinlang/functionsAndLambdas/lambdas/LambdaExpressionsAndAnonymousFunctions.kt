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


    val result4 = sum2(5, 6)
    println("result4: $result4")
}

fun max(arg1: String, lambda: (String, String) -> Boolean) {
    println("arg1: $arg1 lambda: ${lambda.invoke("a", "A")}")
    //Or
    println("arg1: $arg1 lambda: ${lambda("a", "A")}")
}

fun compare(a: String, b: String): Boolean = a.equals(b, true)

/**
 * INFO-TODO
 * Lambda expression syntax
 *
 * A lambda expression is always surrounded by curly braces, parameter declarations in the full syntactic
 * form go inside curly braces and have optional type annotations, the body goes after an -> sign.
 * If the inferred return type of the lambda is not Unit, the last (or possibly single) expression
 * inside the lambda body is treated as the return value.
 */
//The full syntactic form of lambda expressions is as follows:
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//If we leave all the optional annotations out, what's left looks like this:
val sum2 = { x: Int, y: Int -> x + y }
