package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    fromFunctionMain()
    fromChunksMain()
}

/** Constructing */

/**
 * From elements
 *
 * INFO-TODO
 *
 * To create a sequence, call the sequenceOf() function listing the elements as its arguments.
 * */
val numbersSequence = sequenceOf("four", "three", "two", "one")

/**
 * From Iterable
 *
 * INFO-TODO
 *
 * If you already have an Iterable object (such as a List or a Set),
 * you can create a sequence from it by calling asSequence().
 * */
val numbers = listOf("one", "two", "three", "four")
val numbersSequence2 = numbers.asSequence()

val numbersSet = setOf("one", "two", "three", "four")
val numbersSequenceSet = numbersSet.asSequence()

/**
 * From function
 *
 * INFO-TODO
 *
 * One more way to create a sequence is by building it with a function that calculates its elements.
 * To build a sequence based on a function, call generateSequence() with this function as an argument.
 * Optionally, you can specify the first element as an explicit value or a result of a function call.
 * The sequence generation stops when the provided function returns null.
 * So, the sequence in the example below is infinite.
 * */

val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element

fun fromFunctionMain() {
    val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
    println(oddNumbers.take(5).toList())
//    println(oddNumbers.count())     // error: the sequence is infinite
    /** To create a finite sequence with generateSequence(), provide a function that returns null after the last element you need. */
    val oddNumbersLessThan10 = generateSequence(1) { if (it < 10) it + 2 else null }
    println(oddNumbersLessThan10.count())
}

/**
 * From chunks
 *
 * INFO-TODO
 *
 * Finally, there is a function that lets you produce sequence elements one by one or by chunks of arbitrary sizes – the sequence() function.
 * This function takes a lambda expression containing calls of yield() and yieldAll() functions.
 * They return an element to the sequence consumer and suspend the execution of sequence() until the next element is requested by the consumer.
 * yield() takes a single element as an argument; yieldAll() can take an Iterable object, an Iterator, or another Sequence.
 * A Sequence argument of yieldAll() can be infinite. However, such a call must be the last: all subsequent calls will never be executed.
 * */

fun fromChunksMain() {
    val oddNumbers = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(oddNumbers.take(5).toList())
//    println(oddNumbers.count()) // error: the sequence is infinite
}