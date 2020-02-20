package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.lambdas

fun main() {

    val lambdaExpressionResult = lambdaExpression(5, 6)
    println("lambdaExpressionResult: $lambdaExpressionResult")

    val anonymousFunctionResult = anonymousFunction(5, 6)
    println("anonymousFunctionResult: $anonymousFunctionResult")

    //********************************************************

    mainFunction()

    //********************************************************

    val functionTypeResult = functionType(5, 6)
    println("functionResult: $functionTypeResult")
}

/**
 * INFO-IMPORTANT-TODO
 * There are several ways to obtain an instance of a function type:
 *
 * 1:
 * - Using a code block within a function literal, in one of the forms:
 *   - a lambda expression: { a, b -> a + b },
 *   - an anonymous function: fun(s: String): Int { return s.toIntOrNull() ?: 0 }
 * */
//********************************************************

val lambdaExpression = { a: Int, b: Int -> a + b }

val anonymousFunction = fun(a: Int, b: Int): String {
    return (a + b).toString()
}

//********************************************************

/**
 * INFO-IMPORTANT-TODO
 *
 * 2:
 * - Using a callable reference to an existing declaration:
 *   - a top-level, local, member, or extension function: ::isOdd, String::toInt,
 *   - a top-level, member, or extension property: List<Int>::size,
 *   - a constructor: ::Regex
 * These include bound callable references that point to a member of a particular instance: foo::toString.
 * */

//a top-level function
fun functionIsOdd(value: Int): Boolean {
    return value % 2 == 0
}


//extension function
fun String.convertToInt(): Int {
    return this.toInt()
}

class MyClass {
    fun myLocalFunction(value: Int): String = value.toString()
}

fun mainFunction() {

    //a top-level function
    val funIssOdd = ::functionIsOdd
    val isOddResult = funIssOdd(552)
    println("isOddResult: $isOddResult")

    //extension function
    val funIntValue = String::convertToInt
    val intValue = funIntValue("123456789")
    println(intValue)
}

//********************************************************

val functionType: (Int, Int) -> (String) = { x, y ->
    (x * y).toString()
}