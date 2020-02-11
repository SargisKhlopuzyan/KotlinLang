package app.sargis.khlopuzyan.kotlinlang.gettingStarted.idioms

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val turtle2 = Turtle2().apply {
        speed = Integer(0)
    }

}

private class Turtle2 {
    lateinit var speed: Integer
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}