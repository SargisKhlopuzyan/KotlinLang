package app.sargis.khlopuzyan.kotlinlang.v_1.collections.sequences

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

// Let's take a look at the difference between Iterable and Sequence with an example.

fun main() {
    iterableMain()
    sequenceMain()
}

// Iterable
fun iterableMain() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words.filter {
        println("filter -> it: $it")
        it.length > 3
    }
        .map { println("map -> length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)
}

// Sequence
fun sequenceMain() {
    println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *")

    val words = "The quick brown fox jumps over the lazy dog".split(" ")
//convert the List to a Sequence
    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence.filter { println("filter -> it: $it"); it.length > 3 }
        .map {
            println("map -> length: ${it.length}")
            it.length
        }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars")
// terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())
}