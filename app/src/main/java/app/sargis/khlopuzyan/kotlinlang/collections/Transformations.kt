package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    mappingMain()
    zippingMain()
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

/**
 * INFO-TODO
 *
 * Zipping
 *
 * Zipping transformation is building pairs from elements with the same positions in both collections.
 * In the Kotlin standard library, this is done by the zip() extension function.
 * When called on a collection or an array with another collection (array) as an argument, zip() returns the List of Pair objects.
 * The elements of the receiver collection are the first elements in these pairs.
 * If the collections have different sizes, the result of the zip() is the smaller size;
 * the last elements of the larger collection are not included in the result. zip() can also be called in the infix form a zip b.
 * */
fun zippingMain() {
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))


    /**
     * You can also call zip() with a transformation function that takes two parameters: the receiver element and the argument element.
     * In this case, the result List contains the return values of the transformation function
     * called on pairs of the receiver and the argument elements with the same positions.
     * */
    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color" }) // [The Fox is red, The Bear is brown, The Wolf is grey]
    println(colors) // [red, brown, grey]
    println(animals) // [fox, bear, wolf]

    /**
     * When you have a List of Pairs, you can do the reverse transformation – unzipping – that builds two lists from these pairs:
     * The first list contains the first elements of each Pair in the original list.
     * The second list contains the second elements.
     * */

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip()) // ([one, two, three, four], [1, 2, 3, 4])
}