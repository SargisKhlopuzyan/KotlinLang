package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas

/**
 * Created by Sargis Khlopuzyan, on 2/18/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
    val list1 = asList(1, 2, 3, 4)
    val list2 = asListWithParametersInLeftSide(125, 1, 2, 3, 4)
    val list3 =
        asListWithParametersInRightSide(1, 2, 3, 4, str = "abc", salary = 100000) //TODO IMPORTANT

    val list4 = asListWithLambda(-1, 0, -2, 2, 3) {
        it > 0
    }
    println(list4)

    val intsList =  arrayOf(8, 9, 8, 5)
    val list5 = asList(1, 2, *intsList, 3, 4)
}


fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

fun <T> asListWithParametersInLeftSide(age: Int, vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

/**
 * Only one parameter may be marked as vararg. If a vararg parameter is not the last one in the list,
 * values for the following parameters can be passed using the named argument syntax, or,
 * if the parameter has a function type, by passing a lambda outside parentheses.
 * */
fun <T> asListWithParametersInRightSide(vararg ts: T, str: String, salary: Int): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    return result
}

fun asListWithLambda(vararg ts: Int, lambda: (Int) -> Boolean): List<Int> {

    val result = ArrayList<Int>()

    for (t in ts) {

        if (lambda(t)) {
            result.add(t)
        }

    }

    return result
}