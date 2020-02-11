package app.sargis.khlopuzyan.kotlinlang.gettingStarted.idioms

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Calling multiple methods on an object instance (with)
 * */
fun main() {
    val turtle = Turtle()
    with(turtle) {
        speed = Integer(0)
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

private class Turtle {
    lateinit var speed: Integer
    fun penDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}
