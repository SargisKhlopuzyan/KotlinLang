package app.sargis.khlopuzyan.kotlinlang.v_1.collections.retrievingCollectionParts

/**
 * Created by Sargis Khlopuzyan, on 3/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */


/**
 * Take and drop
 *
 * To get the specified number of elements starting from the first, use the take() function.
 * For getting the last elements, use takeLast(). When called with a number larger than the collection size, both functions return the whole collection.
 *
 * To take all the elements except a given number of first or last elements, call the drop() and dropLast() functions respectively.
 * */
fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))

    /**
     * You can also use predicates to define the number of elements for taking or dropping.
     * There are four functions similar to the ones described above:
     *
     *  - takeWhile() is take() with a predicate: it takes the elements up to but excluding the first one not matching the predicate.
     *    If the first collection element doesn't match the predicate, the result is empty.
     *
     *  - takeLastWhile() is similar to takeLast(): it takes the range of elements matching the predicate from the end of the collection.
     *    The first element of the range is the element next to the last element not matching the predicate.
     *    If the last collection element doesn't match the predicate, the result is empty;
     *
     *  - dropWhile() is the opposite to takeWhile() with the same predicate: it returns
     *    the elements from the first one not matching the predicate to the end.
     *
     *  - dropLastWhile() is the opposite to takeLastWhile() with the same predicate: it returns
     *    the elements from the beginning to the last one not matching the predicate.
     * */
    println(numbers.takeWhile { !it.startsWith('f') })
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })
}