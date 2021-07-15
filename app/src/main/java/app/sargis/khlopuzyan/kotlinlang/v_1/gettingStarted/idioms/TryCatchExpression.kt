package app.sargis.khlopuzyan.kotlinlang.v_1.gettingStarted.idioms

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    test()
}

private fun test() {
    val list = listOf<String>()
    val result = try {
        list[0]
    } catch (e: IndexOutOfBoundsException) {
        throw IndexOutOfBoundsException("throw IllegalArgumentException")
    }
}