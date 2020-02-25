package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    mappingMain()
    zippingMain()
    associationMain()
    flatteningMain()
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

/**
 * INFO-TODO
 *
 * Association
 * */
fun associationMain() {

    /**
     * The basic association function associateWith() creates a Map in which the elements of the original collection are keys,
     * and values are produced from them by the given transformation function.
     * If two elements are equal, only the last one remains in the map.
     * */
    val numbers = listOf("one", "two", "three", "four", "one")
    println(numbers.associateWith { it.length })


    /**
     * For building maps with collection elements as values, there is the function associateBy().
     * It takes a function that returns a key based on an element's value.
     * If two elements are equal, only the last one remains in the map.
     * associateBy() can also be called with a value transformation function.
     * */
    println(numbers.associateBy { it.first().toUpperCase() })
    println(
        numbers.associateBy(
            keySelector = { it.first().toUpperCase() },
            valueTransform = { it.length })
    )

    /**
     * Another way to build maps in which both keys and values are somehow produced from collection elements is the function associate().
     * It takes a lambda function that returns a Pair: the key and the value of the corresponding map entry.
     *
     * Note that associate() produces short-living Pair objects which may affect the performance.
     * Thus, associate() should be used when the performance isn't critical or it's more preferable than other options.
     * */
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name ->
        parseFullName(name).let { it.lastName to it.firstName }
    })
}

fun parseFullName(fullName: String): FullName {
    val names = fullName.split(" ")
    return FullName(names.first(), names.last())
}

class FullName(var lastName: String, var firstName: String)

/**
 * Flattening
 *
 * INFO-TODO
 * */
fun flatteningMain() {

    /**
     * The flatten() function can be called on a collection of collections, for example, a List of Sets.
     * The function returns a single List of all the elements of the nested collections.
     * */
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten()) // [1, 2, 3, 4, 5, 6, 1, 2]

    /**
     * Another function – flatMap() provides a flexible way to process nested collections.
     * It takes a function that maps a collection element to another collection.
     * As a result, flatMap() returns a single list of its return values on all the elements.
     * So, flatMap() behaves as a subsequent call of map() (with a collection as a mapping result) and flatten().
     * */
    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight", "one"))
    )
    println(containers.flatMap { it.values }) // [one, two, three, four, five, six, seven, eight, one]
}

class StringContainer(var values: List<String>)