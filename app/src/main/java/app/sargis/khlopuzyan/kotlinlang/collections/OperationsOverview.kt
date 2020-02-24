package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    commonOperationsMain()
    writeOperationsMain()
}

fun commonOperationsMain() {
    val numbers = listOf("one", "two", "three", "four")
    val filterResults = mutableListOf<String>()  //destination object
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
    println(filterResults) // contains results of both operations

    // For convenience, these functions return the destination collection back,
    // so you can create it right in the corresponding argument of the function call:
    // filter numbers right into a new hash set,
    // thus eliminating duplicates in the result
    val result = numbers.mapTo(HashSet()) { it.length }
    println("distinct item lengths are $result")
}

/**
 * INFO-TODO
 *
 * For certain operations, there are pairs of functions for performing the same operation:
 * one applies the operation in-place and the other returns the result as a separate collection.
 * For example, sort() sorts a mutable collection in-place, so it's state changes;
 * sorted() creates a new collection that contains the same elements in the sorted order.
 * */
fun writeOperationsMain() {
    val numbers = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = numbers.sorted()
    println(numbers == sortedNumbers)  // false
    numbers.sort()
    println(numbers == sortedNumbers)  // true
}