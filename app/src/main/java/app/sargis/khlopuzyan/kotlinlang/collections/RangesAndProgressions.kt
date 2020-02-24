package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    rangesAndProgressionsMain()
    rangeMain()
    progressionMain()
}

fun rangesAndProgressionsMain() {

    val i = 2
    if (i in 1..4) {  // equivalent of 1 <= i && i <= 4
        print(i)
    }

    /**
     * INFO-TODO
     *
     * Integral type ranges (IntRange, LongRange, CharRange) have an extra feature: they can be iterated over.
     * These ranges are also progressions of the corresponding integral types.
     * Such ranges are generally used for iteration in the for loops.
     * */

    for (i in 1..4) print(i)
    //To iterate numbers in reverse order, use the downTo function instead of ...
    for (i in 4 downTo 1) print(i)

    // It is also possible to iterate over numbers with an arbitrary step (not necessarily 1). This is done via the step function.
    for (i in 1..8 step 2) print(i)
    println()
    for (i in 8 downTo 1 step 2) print(i)

    // To iterate a number range which does not include its end element, use the until function:
    for (i in 1 until 10) {       // i in [1, 10), 10 is excluded
        print(i)
    }
}

//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

/**
 * Range
 * INFO-TODO
 *
 * To create a range for your class, call the rangeTo() function on the range start value and
 * provide the end value as an argument. rangeTo() is often called in its operator form ..
 * */
fun rangeMain() {
    val versionRange = Version(1, 1)..Version(3, 30)

    println(Version(0, 9) in versionRange)
    println(Version(4, 3) in versionRange)
}

class Version(var arg1: Int, var arg2: Int) : Comparable<Version> {

    override fun compareTo(other: Version): Int {
        return this.arg1.compareTo(other.arg1) and this.arg2.compareTo(other.arg2)
    }
}

//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

/**
 * Progression
 * INFO-TODO
 *
 * As shown in the examples above, the ranges of integral types, such as Int, Long, and Char, can be treated as arithmetic progressions of them.
 * In Kotlin, these progressions are defined by special types: IntProgression, LongProgression, and CharProgression.
 *
 * Progressions have three essential properties: the first element, the last element, and a non-zero step.
 * The first element is first, subsequent elements are the previous element plus a step.
 * Iteration over a progression with a positive step is equivalent to an indexed for loop in Java/JavaScript.
 * */
fun progressionMain() {

    for (i in 1..10)
        print(i)
    println()

    for (i in 1..8 step 2)
        print(i)
    println()

    /**
     * INFO-TODO
     *
     * The last element of the progression is calculated this way:
     * For a positive step: the maximum value not greater than the end value such that (last - first) % step == 0.
     * For a negative step: the minimum value not less than the end value such that (last - first) % step == 0.
     * */

    /**
     * INFO-TODO
     *
     * Progressions implement Iterable<N>, where N is Int, Long, or Char respectively,
     * so you can use them in various collection functions like map, filter, and other.
     * */
    println((1..10).filter { it % 2 == 0 })
}