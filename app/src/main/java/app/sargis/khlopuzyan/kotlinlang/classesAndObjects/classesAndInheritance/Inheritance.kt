package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    var circle: Shape = Circle()
    circle.draw()
    circle.fill()

}

//**************************************************************************

open class Shape {

    open var varVertexCount: Int = 0

    open val valVertexCount: Int = 0


    open fun draw() {
        println("Shape -> draw...")
    }

    fun fill() {
        println("Shape -> fill...")
    }

}

class Circle : Shape() {

    override var varVertexCount = 4
//    override val varVertexCount = 4 // Will not compile

    override val valVertexCount = 4
    //or
//    override var valVertexCount = 4 // Will compile

    override fun draw() {
        println("Circle -> draw...")
    }
}

open class Rectangle : Shape() {
    final override fun draw() { /*...*/
    }
}

class Polygon(override val valVertexCount: Int = 4) : Shape()

//**************************************************************************