package app.sargis.khlopuzyan.kotlinlang.v_1.gettingStarted.idioms

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    var a = 1
    var b = 2

    a = b.also {
        b = a
    }

    TODO()

}