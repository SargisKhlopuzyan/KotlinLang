package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/20/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * Invoking a function type instance
 * A value of a function type can be invoked by using its invoke(...) operator: f.invoke(x) or just f(x).
 *
 * If the value has a receiver type, the receiver object should be passed as the first argument.
 * Another way to invoke a value of a function type with receiver is to prepend it with the receiver object,
 * as if the value were an extension function: 1.foo(2),
 * */

fun main() {
    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call
}

val stringPlus: (String, String) -> String = String::plus
val intPlus: Int.(Int) -> Int = Int::plus



