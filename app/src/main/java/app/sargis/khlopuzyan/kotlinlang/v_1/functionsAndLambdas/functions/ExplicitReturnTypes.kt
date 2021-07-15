package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.functions

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Functions with block body must always specify return types explicitly, unless it's intended for them to return Unit,
 * in which case it is optional. Kotlin does not infer return types for functions with block bodies because such
 * functions may have complex control flow in the body,  and the return type will be non-obvious to the reader (and sometimes even for the compiler).
 * */

fun myFunction(x: Int, str: String, lambda: (Int, Int) -> Boolean) = lambda(x, x * x)

fun myFunction2(x: Int, str: String, lambda: (Int, Int) -> Boolean) =
    if (x > 2 * x) "positive" else "negative"