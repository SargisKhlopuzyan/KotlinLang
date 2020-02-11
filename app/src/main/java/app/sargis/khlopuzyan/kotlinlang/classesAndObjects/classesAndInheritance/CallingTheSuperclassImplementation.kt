package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

//    FilledRectangleXX()

    FilledRectangleXX().Filler().drawAndFill()

}

open class RectangleX {

    open fun draw() { println("draw -> RectangleX -> Drawing a rectangleX") }

    open val borderColor: String
        get() = "black"
}

/*class FilledRectangleX : RectangleX() {

    override fun draw() {
        super.draw()
        println("Filling the rectangleX")
    }

    val fillColor: String
        get() = super.borderColor
}*/

class FilledRectangleXX: RectangleX() {

    override fun draw() {
        println("draw -> FilledRectangleXX")
    }

    override val borderColor: String get() = "black"

    inner class Filler {

        fun fill() { /* ... */ }

        fun drawAndFill() {

            draw()
//            super.draw()
            super@FilledRectangleXX.draw() // Calls RectangleXX's implementation of draw()

            fill()

            println("drawAndFill -> FilledRectangleXX -> Drawn a filled rectangle with color ${super@FilledRectangleXX.borderColor}") // Uses Rectangle's implementation of borderColor's get()

        }

    }
}