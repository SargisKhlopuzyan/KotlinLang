package app.sargis.khlopuzyan.kotlinlang.gettingStarted.idioms

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val list = listOf(
        Customer("a", "a@email.com"),
        Customer("b", "b@email.com"),
        Customer("c", "c@email.com")
    )

    val maxElement = list.filter {
        it.name.startsWith('a') || it.name.startsWith('b')
    }

    println(maxElement)

    val map = mapOf(Pair("a", 1), Pair("b", 2), Pair("c", 3))

    for ((k, v) in map) {
        println("$k -> $v")
    }
}


/**
 * getters (and setters in case of vars) for all properties
 * equals()
 * hashCode()
 * toString()
 * copy()
 * component1(),
 * component2(),
 * …
 * */
private data class Customer(val name: String, val email: String)