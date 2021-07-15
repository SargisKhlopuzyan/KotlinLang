package app.sargis.khlopuzyan.kotlinlang.v_1.collections.retrievingCollectionParts

/**
 * Created by Sargis Khlopuzyan, on 3/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Slice
 *
 * slice() returns a list of the collection elements with given indices.
 * The indices may be passed either as a range or as a collection of integer values
 * */
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))
}