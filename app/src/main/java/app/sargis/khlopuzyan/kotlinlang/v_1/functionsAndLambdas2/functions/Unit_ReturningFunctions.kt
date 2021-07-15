package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2.functions

fun main() {
    println(printHello("Sargis"))
}

// If a function does not return any useful value, its return type is Unit.
// Unit is a type with only one value - Unit.
// This value does not have to be returned explicitly:
fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
}