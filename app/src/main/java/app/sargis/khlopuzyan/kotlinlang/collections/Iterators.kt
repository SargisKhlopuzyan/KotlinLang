package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
    iteratorsMain()
    listIteratorsMain()
    mutableIteratorsMain()
}

/**
 * INFO-TODO
 *
 * Iterators can be obtained for inheritors of the Iterable<T> interface, including Set and List, by calling
 * the iterator() function. Once you obtain an iterator, it points to the first element of a collection; calling the
 * next() function returns this element and moves the iterator position to the following element if it exists.
 * Once the iterator passes through the last element, it can no longer be used for retrieving elements; neither
 * can it be reset to any previous position. To iterate through the collection again, create a new iterato
 * */
fun iteratorsMain() {
    val numbers = listOf("one", "two", "three", "four")

    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }
    // Or
    for (item in numbers) {
        println(item)
    }
    // Or
    numbers.forEach {
        println(it)
    }
}

/**
 * INFO-TODO
 *
 * For lists, there is a special iterator implementation: ListIterator.
 * It supports iterating lists in both directions: forwards and backwards.
 * Backward iteration is implemented by the functions hasPrevious() and previous().
 * Additionally, the ListIterator provides information about the element indices with the functions nextIndex() and previousIndex().
 * */
fun listIteratorsMain() {
    val numbers = listOf("one", "two", "three", "four")
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) listIterator.next()
    println("Iterating backwards:")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }
}

/**
 * INFO-TODO
 *
 * For iterating mutable collections, there is MutableIterator that extends Iterator with the element removal function remove().
 * So, you can remove elements from a collection while iterating it.
 * */
fun mutableIteratorsMain() {
    val numbers = mutableListOf("one", "four", "four")
    val mutableListIterator = numbers.listIterator()

    mutableListIterator.next()
    mutableListIterator.add("two")
    mutableListIterator.next()
    mutableListIterator.set("three")
    println(numbers)
}