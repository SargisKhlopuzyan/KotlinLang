package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

import android.content.Context
import android.widget.Button

/**
 * Created by Sargis Khlopuzyan, on 2/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    onClick()
    onClickWithParams("age", 12)
    onClickWithNamedParams("age", 12)

    val context: Context? = null
    val button = Button(context)
    button.buttonOnClick(12)

//    onClickWithParamsSuspend("age", 12)
}

/**
 * Function types
 *
 * Kotlin uses a family of function types like (Int) -> String for declarations that deal with functions: val onClick: () -> Unit = ....
 * These types have a special notation that corresponds to the signatures of the functions, i.e. their parameters and return values:
 *
 * - All function types have a parenthesized parameter types list and a return type: (A, B) -> C denotes a
 *   type that represents functions taking two arguments of types A and B and returning a value of type C.
 *   The parameter types list may be empty, as in () -> A. The Unit return type cannot be omitted.
 *
 * - Function types can optionally have an additional receiver type, which is specified before a dot in the notation: the type A.(B) -> C
 *   represents functions that can be called on a receiver object of A with a parameter of B and return a value of C.
 *   Function literals with receiver are often used along with these types.
 *
 * - Suspending functions belong to function types of a special kind, which have a suspend modifier
 *   in the notation, such as suspend () -> Unit or suspend A.(B) -> C.
 * */

val onClick: () -> Unit = {
    println("in onClick function")
}

val onClickWithParams: (String, Int) -> Unit = { str, value ->
    println("in onClick function -> xstr: $str, value: $value")
}

val onClickWithNamedParams: (str: String, value: Int) -> Unit = { str, value ->
    println("in onClick function -> xstr: $str, value: $value")
}

val buttonOnClick: Button.(Int) -> Unit = { value: Int ->
    println("in buttonOnClick function -> value: $value")
}

// suspend * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

val onClickSuspend: suspend () -> Unit = {
    println("in onClick function")
}

val onClickWithParamsSuspend: suspend (str: String, value: Int) -> Unit = { str, value ->
    println("in onClick function -> xstr: $str, value: $value")
}

val buttonOnClickSuspend: suspend Button.(Int) -> Unit = { value: Int ->
    println("in buttonOnClick function -> value: $value")
}