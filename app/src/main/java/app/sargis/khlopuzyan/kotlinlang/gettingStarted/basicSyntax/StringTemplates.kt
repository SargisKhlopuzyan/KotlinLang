package app.sargis.khlopuzyan.kotlinlang.gettingStarted.basicSyntax

import java.lang.Integer.parseInt

/**
 * Created by Sargis Khlopuzyan, on 2/6/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    var a = 1

    val s1 = "a is $a"
    println(s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
    println(s2)

    lambdaExpressionsToFilterAndMapCollections()

}

private fun maxOf(a: Int, b: Int) = if (a > b) a else b

private fun printProduct(arg1: String, arg2: String) {

    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

private fun getStringLength(obj: Any): Int? {

    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

private fun getStringLength2(obj: Any): Int? {

    if (obj !is String) {
        return null
    }

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

private fun getStringLength3(obj: Any): Int? {

    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}

private fun checkingIfACollectionContainsAnObjectUsingInOperator() {

    when {
        "orange" in listOf("orange", "blue") -> {

        }

        "red" in listOf("orange", "blue") -> {

        }
    }
}

private fun lambdaExpressionsToFilterAndMapCollections() {

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

    fruits
        .filter {
            it.startsWith("a")
        }
        .sortedBy {
            it
        }
        .map {
            it.toUpperCase()
        }
        .forEach {
            println(it)
        }

}