package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2.functions

fun main() {
    println(asList(1, 2, 3))

    /**
     * When we call a vararg-function, we can pass arguments one-by-one, e.g. asList(1, 2, 3), or,
     * if we already have an array and want to pass its contents to the function,
     * we use the spread operator (prefix the array with *):
     * */
    val array = arrayOf(3, 4, 5)
    println(asList(1, 2, *array, 6, 7))

    println(asList2(111, 2, 3, 4)) // [2, 3, 4]

//    println(asList3(1, 2, 3, 111)) // Error - No value passed for parameter 'index'
    println(asList3(1, 2, 3, index = 111))
}

/**
 * Only one parameter may be marked as vararg.
 * If a vararg parameter is not the last one in the list,
 * values for the following parameters can be passed using the named argument syntax,
 * or, if the parameter has a function type, by passing a lambda outside parentheses.
 * */
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

fun <T> asList2(index: Int, vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

fun <T> asList3(vararg ts: T, index: Int): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}