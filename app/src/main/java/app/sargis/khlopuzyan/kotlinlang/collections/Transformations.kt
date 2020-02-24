package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    mappingMain()
}

fun mappingMain() {
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })

    /**
     * INFO-TODO
     *
     * If the transformation produces null on certain elements,
     * you can filter out the nulls from the result collection
     * by calling the mapNotNull() function instead of map(), or mapIndexedNotNull() instead of mapIndexed()
     * */
    println(numbers.mapNotNull { if (it == 2) null else it * 3 })
    println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

    /**
     *
     * When transforming maps, you have two options: transform keys leaving values unchanged and vice versa.
     * To apply a given transformation to keys, use mapKeys(); in turn, mapValues() transforms values.
     * Both functions use the transformations that take a map entry as an argument, so you can operate both its key and value.
     * */
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })
}