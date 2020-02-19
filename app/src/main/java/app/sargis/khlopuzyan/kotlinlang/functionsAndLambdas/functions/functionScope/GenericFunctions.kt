package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.functions.functionScope

/**
 * Created by Sargis Khlopuzyan, on 2/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun <T> myFunction(item: T): List<T> {
    val list = mutableListOf<T>()
    list.add(item)
    return list
}