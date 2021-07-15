package app.sargis.khlopuzyan.kotlinlang.v_1.collections.constructingCollections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Collections can be created in result of various operations on other collections.
 * For example, filtering a list creates a new list of elements that match the filter
 * */
fun main() {

    val strings = listOf("one", "two", "three", "four")
    val longerThan3 = strings.filter { it.length > 3 }
    println(longerThan3)

    // Mapping produces a list of a transformation results:
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value ->
        if (idx % 2 == 0) {
            value * idx
        } else {
            value
        }
    })

    // Association produces maps:
    val numbers2 = listOf("one", "two", "three", "four")
    println(numbers2.associateWith { it.length })
}