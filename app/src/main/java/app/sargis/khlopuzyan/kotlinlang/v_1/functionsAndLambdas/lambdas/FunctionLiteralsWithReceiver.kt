package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Function types with receiver, such as A.(B) -> C, can be instantiated with a special form of function literals
 * – function literals with receiver.
 *
 * As said above, Kotlin provides the ability to call an instance of a function type with receiver providing the receiver object.
 *
 * Inside the body of the function literal, the receiver object passed to a call becomes an implicit this,
 * so that you can access the members of that receiver object without any additional qualifiers,
 * or access the receiver object using a this expression.
 *
 * This behavior is similar to extension functions, which also allow you to access the members of the receiver object inside the body of the function.
 * */

// Here is an example of a function literal with receiver along with its type, where plus is called on the receiver object:
val sum1: Int.(Int) -> Int = { other ->
    println("this: $this | other: $other")
    this.plus(other)
}

/**
 * INFO-IMPORTANT-TODO
 * The anonymous function syntax allows you to specify the receiver type of a function literal directly.
 * This can be useful if you need to declare a variable of a function type with receiver, and to use it later.
 * */
val sum3 = fun Int.(other: Int): Int { return this + other }
// Or
val sum4 = fun Int.(other: Int): Int = this + other

fun main() {
    val result = 2.sum1(8)
    println("result: $result")

    val result2 = 7.sum4(5)
    println("result2: $result2")


    val myHTML: HTML = html {
        // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }
    println("myHTML: $myHTML")
}

/**
 * Lambda expressions can be used as function literals with receiver when the receiver type can be inferred from context.
 * One of the most important examples of their usage is type-safe builders:
 * */

class HTML {
    fun body() {}
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()  // create the receiver object
    html.init()        // pass the receiver object to the lambda
    return html
}