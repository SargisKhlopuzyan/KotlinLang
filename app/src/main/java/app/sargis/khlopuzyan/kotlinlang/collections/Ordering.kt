package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 3/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
    collectionOrdering()
    naturalOrder()
    customOrders()
    reverseOrder()
    randomOrder()
}

/**
 * In Kotlin, the orders of objects can be defined in several ways.
 * First, there is natural order. It is defined for inheritors of the Comparable interface.
 * order is used for sorting them when no other order is specified.
 *
 * Most built-in types are comparable:
 * - Numeric types use the traditional numerical order: 1 is greater than 0; -3.4f is greater than -5f, an so on.
 * - Char and String use the lexicographical order: b is greater than a; world is greater than hello.
 *
 * To define a natural order for a user-defined type, make the type an inheritor of Comparable.
 * This requires implementing the compareTo() function. compareTo() must take another object of the
 * same type as an argument and return an integer value showing which object is greater:
 *
 * - Positive values show that the receiver object is greater.
 * - Negative values show that it's less than the argument.
 * - Zero shows that the objects are equal.
 * */
fun collectionOrdering() {
    println(Version2(1, 2) > Version2(1, 3))
    println(Version2(2, 0) > Version2(1, 5))

    val lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))
}

class Version2(val major: Int, val minor: Int) : Comparable<Version2> {

    override fun compareTo(other: Version2): Int {
        if (this.major != other.major) {
            return this.major - other.major
        } else if (this.minor != other.minor) {
            return this.minor - other.minor
        } else return 0
    }

}

/**
 * Natural order
 *
 * The basic functions sorted() and sortedDescending() return elements of a collection sorted
 * into ascending and descending sequence according to their natural order.
 * These functions apply to collections of Comparable elements.
 * */
fun naturalOrder() {
    val numbers = listOf("one", "two", "three", "four")

    println("Sorted ascending: ${numbers.sorted()}")
    println("Sorted descending: ${numbers.sortedDescending()}")
}

/**
 * Custom orders
 *
 * For sorting in custom orders or sorting non-comparable objects, there are the functions sortedBy() and sortedByDescending().
 * They take a selector function that maps collection elements to Comparable values and sort the collection in natural order of that values.
 * */
fun customOrders() {
    val numbers = listOf("one", "two", "three", "four")

    val sortedNumbers = numbers.sortedBy { it.length }
    println("Sorted by length ascending: $sortedNumbers")
    val sortedByLast = numbers.sortedByDescending { it.last() }
    println("Sorted by the last letter descending: $sortedByLast")

    /**
     * To define a custom order for the collection sorting, you can provide your own Comparator.
     * To do this, call the sortedWith() function passing in your Comparator.
     * With this function, sorting strings by their length looks like this:
     * */
    println("Sorted by length ascending: ${numbers.sortedWith(compareBy { it.length })}")
}

/**
 * 1..
 * reversed() returns a new collection with the copies of the elements.
 * So, if you change the original collection later, this won't affect the previously obtained results of reversed().
 *
 * 2..
 * Another reversing function - asReversed() - returns a reversed view of the same collection instance,
 * so it may be more lightweight and preferable than reversed() if the original list is not going to change.
 * */
fun reverseOrder() {
//    1..
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.reversed()) // [four, three, two, one]

//    2..
    val reversedNumbers = numbers.asReversed()
    println(reversedNumbers) // [four, three, two, one]
    println(numbers) // [one, two, three, four]

    println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *")
//    If the original list is mutable, all its changes reflect in its reversed views and vice versa.
    val numbers2 = mutableListOf("one", "two", "three", "four")
    val reversedNumbers2 = numbers2.asReversed()
    println(reversedNumbers2.hashCode())
    println(numbers2.hashCode())
    println(reversedNumbers2)
    numbers2.add("five")
    println(reversedNumbers2)

}

/**
 * Random order
 *
 * Finally, there is a function that returns a new List containing the collection elements in a random order - shuffled().
 * You can call it without arguments or with a Random object.
 * */
fun randomOrder() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.shuffled())
}