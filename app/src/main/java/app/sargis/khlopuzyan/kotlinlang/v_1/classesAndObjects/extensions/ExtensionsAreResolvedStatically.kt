package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.extensions

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val shape = Shape()
    val rectangle = Rectangle()
    val shapeRectangle: Shape = Rectangle()

    println(shape.getName())
    println(rectangle.getName())
    println(shapeRectangle.getName())

//    println(shape.memberFunction())
    shape.memberFunction()
    println(shape.otherFunction())
}

open class Shape {

    fun memberFunction() {
        println("member function")
    }

    fun otherFunction() {}

}

class Rectangle : Shape()

fun Shape.memberFunction() = "extension function $this"

fun Shape.getName() = "Shape: $this"

fun Rectangle.getName() = "Rectangle: $this"