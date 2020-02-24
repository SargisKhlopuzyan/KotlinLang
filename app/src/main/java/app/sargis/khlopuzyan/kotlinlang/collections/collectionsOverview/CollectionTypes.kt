package app.sargis.khlopuzyan.kotlinlang.collections.collectionsOverview

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    /**
     * INFO-TODO
     * The read-only collection types are covariant. This means that, if a Rectangle class inherits from Shape,
     * you can use a List<Rectangle> anywhere the List<Shape> is required.
     * In other words, the collection types have the same subtyping relationship as the element types.
     * */
    val shapes: List<Shape> = listOf<Rectangle>(
        Rectangle(),
        Rectangle(),
        Rectangle(),
        Rectangle()
    )

    /**
     * INFO-TODO
     * mutable collections aren't covariant; otherwise, this would lead to runtime failures.
     * If MutableList<Rectangle> was a subtype of MutableList<Shape>, you could insert other Shape inheritors
     * (for example, Circle) into it, thus violating its Rectangle type argument.
     * */
//    val rectangles: MutableList<Shape> = mutableListOf<Rectangle>(Rectangle(), Rectangle(), Rectangle()) //Error !! Required MutableList<Shape>, found MutableList<Rectangle>

    printAll(
        setOf("a", "b", "c")
    )
    printAll(
        listOf("a", "b", "c")
    )

    collectionMain()
    listMain()
    setMain()
    mapMain()
}


open class Shape
open class Rectangle : Shape()
open class Circle : Shape()


/**
 * INFO-TODO
 *
 * Collection
 * */
fun collectionMain() {
    val strings = mutableListOf("b", "bxaa", "an", "asdasdsa", "ba", "csa", "dda")
    val shortWords = mutableListOf<String>()
    strings.getShortWordsTo(shortWords, 3)
    println("shortWords: $shortWords")
}

fun printAll(strings: Collection<String>) {
    for (s in strings) print("$s ")
    println()
}

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {

    this.filterTo(shortWords) {
        it.length <= maxLength
    }

    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}

/**
 * INFO-TODO
 *
 * List
 *
 * Two lists are considered equal if they have the same sizes and structurally equal elements at the same positions.
 */
fun listMain() {
    val bob =
        Person(
            "Bob",
            31
        )
    val people = listOf<Person>(
        Person(
            "Adam",
            20
        ), bob, bob)
    val people2 = listOf<Person>(
        Person(
            "Adam",
            20
        ),
        Person(
            "Bob",
            31
        ), bob)
    println(people == people2)
    bob.age = 32
    println(people == people2)
}

class Person(var name: String, var age: Int) {
    override fun equals(other: Any?): Boolean {
        if (other != null && other is Person) {
            return other.name == this.name && other.age == this.age
        }
        return false
    }
}

/**
 * INFO-TODO
 *
 * Set
 *
 * Set<T> stores unique elements; their order is generally undefined.
 * null elements are unique as well: a Set can contain only one null.
 * Two sets are equal if they have the same size, and for each element of a set there is an equal element in the other set.
 *
 * The default implementation of Set – LinkedHashSet – preserves the order of elements insertion.
 * Hence, the functions that rely on the order, such as first() or last(), return predictable results on such sets.
 *
 * An alternative implementation – HashSet – says nothing about the elements order,
 * so calling such functions on it returns unpredictable results.
 * However, HashSet requires less memory to store the same number of elements.
 * */
fun setMain() {
    val numbers = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbers.size}")
    if (numbers.contains(1)) println("1 is in the set")

    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers == numbersBackwards}")

    println(numbers.first() == numbersBackwards.first())
    println(numbers.first() == numbersBackwards.last())
}

/**
 * INFO-TODO
 *
 * Map
 *
 * Map<K, V> is not an inheritor of the Collection interface; however, it's a Kotlin collection type as well.
 * A Map stores key-value pairs (or entries); keys are unique, but different keys can be paired with equal values.
 * The Map interface provides specific functions, such as access to value by key, searching keys and values, and so on.
 *
 * The default implementation of Map – LinkedHashMap – preserves the order of elements insertion when iterating the map.
 * In turn, an alternative implementation – HashMap – says nothing about the elements order.
 * */
fun mapMain() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)

    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")
    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values) println("The value 1 is in the map")
    if (numbersMap.containsValue(1)) println("The value 1 is in the map") // same as previous

//    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)

    println("The maps are equal: ${numbersMap == anotherMap}")
}