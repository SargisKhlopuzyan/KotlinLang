package app.sargis.khlopuzyan.kotlinlang.v_1.collections.constructingCollections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 *
 * Note that the to notation creates a short-living Pair object,
 * so it's recommended that you use it only if performance isn't critical.
 * To avoid excessive memory usage, use alternative ways.
 * For example, you can create a mutable map and populate it using the write operations.
 * The apply() function can help to keep the initialization fluent here.
 *
 * */
fun main() {
    val numbersMap =
        mutableMapOf<String, Int>().apply { this["one"] = 1; this["two"] = 2; this["three"] = 3 }

    numbersMap.apply {
        this["four"] = 4
        this["five"] = 5
        this["six"] = 6
    }

}