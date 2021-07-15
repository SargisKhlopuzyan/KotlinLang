package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * One thing missing from the lambda expression syntax presented above is the ability to specify the return type of the function.
 * In most cases, this is unnecessary because the return type can be inferred automatically.
 * However, if you do need to specify it explicitly, you can use an alternative syntax: an anonymous function.
 * */

val anonymousFunctions = fun(x: Int, y: Int): Int = x + y

// An anonymous function looks very much like a regular function declaration, except that its name is omitted.
// Its body can be either an expression (as shown above) or a block:

val anonymousFunctions2 = fun(x: Int, y: Int): Int {
    return x + y
}


fun main() {

    val ints = intArrayOf(1, 2, 3, 4)

    /**
     * INFO-IMPORTANT-TODO
     * The parameters and the return type are specified in the same way as for regular functions,
     * except that the parameter types can be omitted if they can be inferred from context:
     * */
    ints.filter(fun(item) = item > 5)
    /**
     * INFO-IMPORTANT-TODO
     * The return type inference for anonymous functions works just like for normal functions:
     * the return type is inferred automatically for anonymous functions with an expression body and
     * has to be specified explicitly (or is assumed to be Unit) for anonymous functions with a block body.
     *
     * Note that anonymous function parameters are always passed inside the parentheses.
     * The shorthand syntax allowing to leave the function outside the parentheses works only for lambda expressions.
     *
     * One other difference between lambda expressions and anonymous functions is the behavior of non-local returns.
     * A return statement without a label always returns from the function declared with the fun keyword.
     * This means that a return inside a lambda expression will return from the enclosing function,
     * whereas a return inside an anonymous function will return from the anonymous function itself.
     */
}

// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

val _lambda = { x: Int, y: Int ->
    x + y
}