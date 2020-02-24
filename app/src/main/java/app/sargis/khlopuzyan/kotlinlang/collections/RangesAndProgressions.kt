package app.sargis.khlopuzyan.kotlinlang.collections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {

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