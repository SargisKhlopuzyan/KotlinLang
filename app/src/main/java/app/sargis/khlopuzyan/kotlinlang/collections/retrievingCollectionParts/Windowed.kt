package app.sargis.khlopuzyan.kotlinlang.collections.retrievingCollectionParts

/**
 * Created by Sargis Khlopuzyan, on 3/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Windowed
 *
 * You can retrieve all possible ranges of the collection elements of a given size.
 * The function for getting them is called windowed(): it returns a list of element ranges that you
 * would see if you were looking at the collection through a sliding window of the given size.
 * Unlike chunked(), windowed() returns element ranges (windows) starting from each collection element.
 * All the windows are returned as elements of a single List.
 * */
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.windowed(4)) // [[one, two, three, four], [two, three, four, five]]

    /**
     * windowed() provides more flexibility with optional parameters:
     * - step defines a distance between first elements of two adjacent windows.
     *   By default the value is 1, so the result contains windows starting from all elements.
     *   If you increase the step to 2, you will receive only windows starting from odd elements: first, third, an so on.
     *
     * - partialWindows includes windows of smaller sizes that start from the elements at the end of the collection.
     *   For example, if you request windows of three elements, you can't build them for the last two elements.
     *   Enabling partialWindows in this case includes two more lists of sizes 2 and 1.
     *
     *
     *   Finally, you can apply a transformation to the returned ranges right away.
     *   To do this, provide the transformation as a lambda function when calling windowed()
     * */
    val numbers2 = (1..10).toList()
    println(numbers2.windowed(3, step = 2, partialWindows = true)) // [[1, 2, 3], [3, 4, 5], [5, 6, 7], [7, 8, 9], [9, 10]]
    println(numbers2.windowed(3)) // [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9], [8, 9, 10]]
    println(numbers2.windowed(3) { it.sum() }) // [6, 9, 12, 15, 18, 21, 24, 27]

    /**
     * To build two-element windows, there is a separate function - zipWithNext().
     * It creates pairs of adjacent elements of the receiver collection. Note that zipWithNext() doesn't break the collection into pairs;
     * it creates a Pair for each element except the last one, so its result on [1, 2, 3, 4] is [[1, 2], [2, 3], [3, 4]], not [[1, 2], [3, 4]].
     * zipWithNext() can be called with a transformation function as well; it should take two elements of the receiver collection as arguments.
     * */
    println(numbers.zipWithNext()) // [(one, two), (two, three), (three, four), (four, five)]
    println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length}) // [false, false, true, false]
}