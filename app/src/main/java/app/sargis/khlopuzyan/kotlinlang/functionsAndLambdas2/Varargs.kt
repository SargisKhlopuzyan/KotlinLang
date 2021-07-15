package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas2

/**
 * Created by Sargis Khlopuzyan, on 8/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
//    val list = asList(/*str1 = "str1",*/ 1, 2, 3, 4, str2 = "str2")
//    val list2_1 = asList2("str1", 1, 2, 3, 4)
////    val list2_2 = asList2(str1 = "str1", 1, 2, 3, 4) // Compile Error


//    val list3_1 = asList(listOf(1, 2, 3, 4), str2 = "str2")
//    val list3_2 = asList(arrayOf(1, 2, 3, 4), str2 = "str2")
    /**
     * When we call a vararg-function, we can pass arguments one-by-one, e.g. asList(1, 2, 3), or,
     * if we already have an array and want to pass its contents to the function,
     * we use the spread operator (prefix the array with *):
     * */
    val list3_3 = asList(*arrayOf(1, 2, 3, 4), str2 = "str2")
}

/**
 * Only one parameter may be marked as vararg. If a vararg parameter is not the last one in the list,
 * values for the following parameters can be passed using the named argument syntax, or,
 * if the parameter has a function type, by passing a lambda outside parentheses.
 * */
fun <T> asList(/*str1: String,*/ vararg ts: T, str2: String): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        println("t: $t")
        result.add(t)
    }
    return result
}

fun <T> asList2(str1: String, vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}