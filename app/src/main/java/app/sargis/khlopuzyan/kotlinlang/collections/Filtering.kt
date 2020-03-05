package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 3/5/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    filteringByPredicateMain()
    partitioningMain()
}

fun filteringByPredicateMain() {
    val numbers: List<String> = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    /**
     * The predicates in filter() can only check the values of the elements.
     * If you want to use element positions in the filter, use filterIndexed().
     * It takes a predicate with two arguments: the index and the value of an element.
     * */
    val filteredIdx = numbers.filterIndexed { index: Int, e: String ->
        e.length > 3 && index > 2
    }
    println(filteredIdx)

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
    println(filteredMap)

    /**
     * To filter collections by negative conditions, use filterNot().
     * It returns a list of elements for which the predicate yields false.
     * */
    val filteredNot = numbers.filterNot { it.length <= 3 }
    println(filteredNot)

    /**
     * filterIsInstance() returns collection elements of a given type.
     * Being called on a List<Any>, filterIsInstance<T>() returns a List<T>,
     * thus allowing you to call functions of the T type on its items.
     * */
    val objectsWithNull = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    objectsWithNull.filterIsInstance<String>().forEach {
        println(it.toUpperCase())
    }

    /**
     * filterNotNull() returns all non-null elements.
     * Being called on a List<T?>, filterNotNull() returns a List<T: Any>,
     * thus allowing you to treat the elements as non-null objects.
     * */
    val stringsWithNull = listOf(null, "one", "two", null)
    stringsWithNull.filterNotNull().forEach {
        println(it.length)   // length is unavailable for nullable Strings
    }
}

/**
 * Another filtering function – partition() – filters a collection by a predicate
 * and keeps the elements that don't match it in a separate list.
 * So, you have a Pair of Lists as a return value: the first list
 * containing elements that match the predicate and the second one
 * containing everything else from the original collection.
 * */
fun partitioningMain() {
    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 }

    println(match)
    println(rest)
}