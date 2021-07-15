package app.sargis.khlopuzyan.kotlinlang.v_1.collections

/**
 * Created by Sargis Khlopuzyan, on 3/6/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
/**
 * In Kotlin, plus (+) and minus (-) operators are defined for collections.
 * They take a collection as the first operand; the second operand can be either an element or another collection.
 * The return value is a new read-only collection:
 *
 * - The result of plus contains the elements from the original collection and from the second operand.
 *
 * - The result of minus contains the elements of the original collection except the elements from the second operand.
 * If it's an element, minus removes its first occurrence; if it's a collection, all occurrences of its elements are removed.
 * */
fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbers2 = listOf("one", "two", "three", "four", "xxxxx", "one", "two", "three", "four")

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    val minusList2 = numbers2 - listOf("one", "two", "three", "four")

    println(plusList)
    println(minusList)
    println(minusList2)
}