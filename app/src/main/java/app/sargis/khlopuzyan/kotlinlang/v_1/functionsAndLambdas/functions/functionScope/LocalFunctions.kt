package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.functions.functionScope

/**
 * Created by Sargis Khlopuzyan, on 2/18/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Kotlin supports local functions, i.e. a function inside another function:
 *
 *Local function can access local variables of outer functions (i.e. the closure),
 *
 * */


fun myFuntion(x: Int) {

    var bool = true

    fun myFunction(x: Int, y: Int) {
        if (bool) {
            myFunction(x, y)
            bool = false
        }
    }

}