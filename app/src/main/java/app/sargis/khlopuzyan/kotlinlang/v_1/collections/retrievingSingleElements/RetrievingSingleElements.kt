package app.sargis.khlopuzyan.kotlinlang.v_1.collections.retrievingSingleElements

/**
 * Created by Sargis Khlopuzyan, on 3/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Retrieving by position
 *
 * For retrieving an element at a specific position, there is the function elementAt().
 * Call it with the integer number as an argument, and you'll receive the collection element at the given position.
 * The first element has the position 0, and the last one is (size - 1).
 *
 * elementAt() is useful for collections that do not provide indexed access, or are not statically known to provide one.
 * In case of List, it's more idiomatic to use indexed access operator (get() or []).
 * */
fun main() {
    retrievingByPosition()
    retrievingByCondition()
    randomElement()
    checkingExistence()
}

fun retrievingByPosition() {
    val numbers = linkedSetOf("one", "two", "three", "four", "five")
    println(numbers.elementAt(3))

    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet.elementAt(0)) // elements are stored in the ascending order

    // There are also useful aliases for retrieving the first and the last element of the collection: first() and last().
    println(numbers.first())
    println(numbers.last())

    /**
     * To avoid exceptions when retrieving element with non-existing positions, use safe variations of elementAt():
     *
     * - elementAtOrNull() returns null when the specified position is out of the collection bounds.
     * - elementAtOrElse() additionally takes a lambda function that maps an Int argument to an instance of the collection element type.
     *   When called with an out-of-bounds position, the elementAtOrElse() returns the result of the lambda on the given value.
     * */
    println(numbers.elementAtOrNull(5))
    println(numbers.elementAtOrElse(5) { index -> "The value for index $index is undefined" })
}

fun retrievingByCondition() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.first { it.length > 3 })
    println(numbers.last { it.startsWith("f") })

    /**
     * If no elements match the predicate, both functions throw exceptions.
     * To avoid them, use firstOrNull() and lastOrNull() instead: they return null if no matching elements are found.
     * */
    println(numbers.firstOrNull { it.length > 6 })

    /**
     * Alternatively, you can use the aliases if their names suit your situation better:
     * - find() instead of firstOrNull()
     * - findLast() instead of lastOrNull()
     * */
    val numbers2 = listOf(1, 2, 3, 4)
    println(numbers2.find { it % 2 == 10 })
    println(numbers2.findLast { it % 2 == 0 })
}

fun randomElement() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.random())
}

/**
 * Checking existence
 *
 * To check the presence of an element in a collection, use the contains() function.
 * It returns true if there is a collection element that equals() the function argument.
 * You can call contains() in the operator form with the in keyword.
 *
 * To check the presence of multiple instances together at once, call containsAll() with a collection of these instances as an argument.
 * */
fun checkingExistence() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.contains("four"))
    println("zero" in numbers)

    println(numbers.containsAll(listOf("four", "two")))
    println(numbers.containsAll(listOf("one", "zero")))

    /**
     * Additionally, you can check if the collection contains any elements by calling isEmpty() or isNotEmpty().
     * */
    println(numbers.isEmpty())
    println(numbers.isNotEmpty())

    val empty = emptyList<String>()
    println(empty.isEmpty())
    println(empty.isNotEmpty())
}